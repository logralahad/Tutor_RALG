<header
    class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap px-4 shadow">
    <img src="<%=request.getContextPath()%>/images/admin.png"
        class="rounded" width="30" height="30"
        alt="${param.correoUsuario}"> <a
        class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-center rounded-pill"
        href="#">${param.correoUsuario}</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed"
        type="button" data-bs-toggle="collapse"
        data-bs-target="#sidebarMenu" aria-controls="sidebarMenu"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3"
                href="<%=request.getContextPath()%>/usuario/logout.jsp"><span
                class="pe-2"><i class="fa fa-sign-out"></i></span>Salir</a>
        </div>
    </div>
</header>