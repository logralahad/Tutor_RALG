<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
        function askAction(ruta, mensaje){
            Swal.fire({
                  title: mensaje,
                  showDenyButton: true,
                  confirmButtonText: 'Aceptar',
                  confirmButtonColor: '#4c9141',
                  denyButtonText: 'Cancelar',
                }).then((result) => {
                  if (result.isConfirmed) {
                      var aTag = document.createElement('a');
                      aTag.href = ruta;
                      document.body.appendChild(aTag);
                      aTag.click();
                  }
                })
        }
</script>
<script>
        async function uploadFile(){
            let formData = new FormData();
            formData.append("file", fileAdd.files[0]);
            await fetch('<%=request.getContextPath()%>/Producto/subirImagen', {
                method: "POST",
                body: formData
            });
            Swal.fire('Imagen subida al servidor');
            var output = document.getElementById('imagenProducto');
            var inputFileAdd = document.getElementById('fileAdd');
            var inputImg = document.getElementById('imagenActual');
            
            output.src = URL.createObjectURL(fileAdd.files[0]);
            output.onload = function() {
              URL.revokeObjectURL(output.src)
            }
            inputImg.value = inputFileAdd.value.split("\\").pop();
        }
</script>
<script>
  var previewImage = function(event) {
    var output = document.getElementById('imagenProducto');
    var inputImg = document.getElementById('imagenActual');
    output.src = event.target.value;
    output.onload = function() {
        URL.revokeObjectURL(output.src)
      }
    inputImg.value = event.target.value;
  };
</script>
