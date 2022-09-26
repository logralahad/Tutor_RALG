<header class="header header-sticky mb-4">
    <div class="container-fluid">
        <button class="header-toggler px-md-0 me-md-3" type="button"
            onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
            <svg class="icon icon-lg">
              <use
                    href="<%=request.getContextPath()%>/js/perfil/vendors/@coreui/icons/svg/free.svg#cil-menu"></use>
            </svg>
        </button>
        <a class="header-brand d-md-none" href="#"> <svg width="118"
                height="46" alt="CoreUI Logo">
              <use
                    href="<%=request.getContextPath()%>/css/perfil/brand/coreui.svg#full"></use>
            </svg></a>
        <ul class="header-nav d-none d-md-flex">
            <h3 class="welcome-text">
                ${param.inicioPerfil != null ? param.inicioPerfil : param.textoSeccion}
                <span class="text-black fw-bold">${param.correoPerfil}</span>
            </h3>
        </ul>
        <ul class="header-nav ms-auto">
            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/index.jsp"> <i
                    class="fa-solid fa-house"></i>
            </a></li>

        </ul>
        <ul class="header-nav ms-3">
            <li class="nav-item dropdown"><a class="nav-link py-0"
                data-coreui-toggle="dropdown" href="#" role="button"
                aria-haspopup="true" aria-expanded="false">
                    <div class="avatar avatar-md">
                        <img class="avatar-img"
                            src="<%=request.getContextPath()%>/images/avatars/2.jpg"
                            alt="User">
                    </div>
            </a>
                <div class="dropdown-menu dropdown-menu-end pt-0">
                    <div class="dropdown-header bg-light py-2">
                        <div class="fw-semibold">General</div>
                    </div>
                    <a class="dropdown-item" href="<%=request.getContextPath()%>/pages/logout.jsp"> <i
                        class="fa-solid fa-right-from-bracket icon me-2"></i>
                        Cerrar sesi&oacute;n
                    </a>

                </div></li>
        </ul>
    </div>
</header>