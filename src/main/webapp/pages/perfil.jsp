<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tablero</title>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/perfil/vendors/feather/feather.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/perfil/vendors/simplebar/css/simplebar.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/perfil/vendors/simplebar.css">
    <link rel="stylesheet"href="<%=request.getContextPath()%>/css/perfil/style.css" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/perfil/examples.css" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/prismjs@1.23.0/themes/prism.css">
</head>
<body>
    <jsp:include page="/componentes/sidebarPerfil.jsp"></jsp:include>
    <div class="wrapper d-flex flex-column min-vh-100 bg-light">
      <header class="header header-sticky mb-4">
        <div class="container-fluid">
          <button class="header-toggler px-md-0 me-md-3" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
            <svg class="icon icon-lg">
              <use href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-menu"></use>
            </svg>
          </button><a class="header-brand d-md-none" href="#">
            <svg width="118" height="46" alt="CoreUI Logo">
              <use href="<%=request.getContextPath()%>/css/perfil/brand/coreui.svg#full"></use>
            </svg></a>
          <ul class="header-nav d-none d-md-flex">
            <h3 class="welcome-text">Good Morning, <span class="text-black fw-bold">John Doe</span></h3>
          </ul>
          <ul class="header-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="#">
                <svg class="icon icon-lg">
                  <use href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-bell"></use>
                </svg></a></li>
            <li class="nav-item"><a class="nav-link" href="#">
                <svg class="icon icon-lg">
                  <use href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-list-rich"></use>
                </svg></a></li>
            <li class="nav-item"><a class="nav-link" href="#">
                <svg class="icon icon-lg">
                  <use href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-envelope-open"></use>
                </svg></a></li>
          </ul>
          <ul class="header-nav ms-3">
            <li class="nav-item dropdown"><a class="nav-link py-0" data-coreui-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                <div class="avatar avatar-md"><img class="avatar-img" 
                src="<%=request.getContextPath()%>/images/avatars/2.jpg" alt="User"></div>
              </a>
              <div class="dropdown-menu dropdown-menu-end pt-0">
                <div class="dropdown-header bg-light py-2">
                  <div class="fw-semibold">Account</div>
                </div><a class="dropdown-item" href="#">
                  <svg class="icon me-2">
                    <use href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-bell"></use>
                  </svg>Cerrar sesi&oacute;n</a>
                  
              </div>
            </li>
          </ul>
        </div>
      </header>
        <div class="body flex-grow-1 px-3">
            <div class="container-lg"></div>
        </div>
    
        <jsp:include page="/componentes/footerPerfil.jsp"></jsp:include>
    </div>
    <script src="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/perfil/vendors/simplebar/js/simplebar.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/utils/js/coreui-utils.js"></script>
    <script src="<%=request.getContextPath()%>js/perfil/main.js.map"></script>
    <script src="https://kit.fontawesome.com/f823a176f3.js"
        crossorigin="anonymous"></script>
</body>
</html>