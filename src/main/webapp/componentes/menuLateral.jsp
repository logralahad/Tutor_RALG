<nav id="sidebarMenu"
    class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3 sidebar-sticky" id="menuLateral">
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link"
                aria-current="page"
                href="<%=request.getContextPath()%>/usuario/perfil.jsp">
                    <span class="align-text-bottom"></span><i
                    class="fa fa-slack" aria-hidden="true"></i>
                    Dashboard
            </a></li>

            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/usuario/rol.jsp">
                    <span class="align-text-bottom"></span><i
                    class="fa fa-cogs" aria-hidden="true"></i> Rol
            </a></li>
            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/usuario/usuario.jsp">
                    <span class="align-text-bottom"></span><i
                    class="fa fa-user" aria-hidden="true"></i> Usuario
            </a></li>
            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/usuario/persona.jsp">
                    <span class="align-text-bottom"></span><i
                    class="fa fa-male" aria-hidden="true"></i> Persona
            </a></li>
            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/usuario/producto.jsp">
                    <span class="align-text-bottom"></span><i
                    class="fa fa-cubes"></i> Producto
            </a></li>
        </ul>
    </div>
</nav>

