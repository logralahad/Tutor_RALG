<div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
      <div class="sidebar-brand d-none d-md-flex">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Dot_Art_logo.svg/1200px-Dot_Art_logo.svg.png"
           width="118" height="46" class="mx-auto"/>
      </div>
      <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/perfil.jsp">
            <i class="fa-solid fa-house-user nav-icon"></i>Principal</a></li>
        <li class="nav-title">USUARIO</li>
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/usuario/registrosUsuario.jsp">
            <i class="fa-solid fa-users nav-icon"></i>Ver usuarios</a></li>
            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/usuario/crearUsuario.jsp">
            <i class="fa-solid fa-user-plus nav-icon"></i>Crear usuario</a></li>
        <li class="nav-divider"></li>
        
        <li class="nav-title">ROL</li>
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/rol/registrosRol.jsp">
            <i class="fa-solid fa-users-gear nav-icon"></i>Ver roles</a></li>
            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/rol/crearRol.jsp">
            <i class="fa-solid fa-user-gear nav-icon"></i>Crear rol</a></li>
        <li class="nav-divider"></li>
        
        <li class="nav-title">PERSONA</li>
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/persona/registrosPersona.jsp">
            <i class="fa-solid fa-person nav-icon"></i>Ver personas</a></li>
            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/persona/crearPersona.jsp">
            <i class="fa-solid fa-person-circle-plus nav-icon"></i>Crear persona</a></li>
        <li class="nav-divider"></li>
        
        <li class="nav-title">PRODUCTO</li>
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/producto/registrosProducto.jsp">
            <i class="fa-solid fa-boxes-stacked nav-icon"></i>Ver productos</a></li>
            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/pages/producto/crearProducto.jsp">
            <i class="fa-solid fa-box nav-icon"></i>Crear producto</a></li>
        <li class="nav-divider"></li>
      </ul>
    </div>