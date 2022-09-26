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