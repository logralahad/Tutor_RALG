<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tutor</title>
	<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>
</head>
<body>
	  <div class="container px-4 py-5" id="featured-3">

		<div class="list-group w-auto">
			
			<h2 class="pb-2 border-bottom">Proyecto Tutor</h2> 
			
			<a href="<%=request.getContextPath()%>/usuario/login.jsp"
				class="list-group-item list-group-item-action d-flex gap-3 py-3"
				aria-current="true"> 
				
				<img src="<%=request.getContextPath()%>/images/crear.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
				
				<div class="d-flex gap-2 w-100 justify-content-between">
					<div>
						<h6 class="mb-0">Login</h6>
						<p class="mb-0 opacity-75">Autenticar usuario.</p>
					</div>
					<small class="opacity-50 text-nowrap">>></small>
				</div>
			</a> 
			
			<a href="<%=request.getContextPath()%>/usuario/registrar.jsp"
				class="list-group-item list-group-item-action d-flex gap-3 py-3"
				aria-current="true"> 
				
				<img src="<%=request.getContextPath()%>/images/leer.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
				
				<div class="d-flex gap-2 w-100 justify-content-between">
					<div>
						<h6 class="mb-0">Registrar</h6>
						<p class="mb-0 opacity-75">Crear usuario nuevo.</p>
					</div>
					<small class="opacity-50 text-nowrap">>></small>
				</div>
			</a>
			
			<a href="<%=request.getContextPath()%>/EjeCookiesServlet/"
				class="list-group-item list-group-item-action d-flex gap-3 py-3"
				aria-current="true"> 
				
				<img src="<%=request.getContextPath()%>/images/actualizar.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
				
				<div class="d-flex gap-2 w-100 justify-content-between">
					<div>
						<h6 class="mb-0">Cookies</h6>
						<p class="mb-0 opacity-75">Uso de cookies.</p>
					</div>
					<small class="opacity-50 text-nowrap">>></small>
				</div>
			</a>
            
            <a href="<%=request.getContextPath()%>/EjeCookiesServlet/tiposCookies"
                class="list-group-item list-group-item-action d-flex gap-3 py-3"
                aria-current="true"> 
                
                <img src="<%=request.getContextPath()%>/images/actualizar.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
                
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <div>
                        <h6 class="mb-0">Cookies</h6>
                        <p class="mb-0 opacity-75">Persistencia vs Session.</p>
                    </div>
                    <small class="opacity-50 text-nowrap">>></small>
                </div>
            </a>
            
            <a href="<%=request.getContextPath()%>/EjeCookiesServlet/contadorCookies"
                class="list-group-item list-group-item-action d-flex gap-3 py-3"
                aria-current="true"> 
                
                <img src="<%=request.getContextPath()%>/images/actualizar.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
                
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <div>
                        <h6 class="mb-0">Cookies</h6>
                        <p class="mb-0 opacity-75">Modificar valor de cookie.</p>
                    </div>
                    <small class="opacity-50 text-nowrap">>></small>
                </div>
            </a>
            
            <a href="<%=request.getContextPath()%>/FormularioRegistroServlet"
                class="list-group-item list-group-item-action d-flex gap-3 py-3"
                aria-current="true"> 
                
                <img src="<%=request.getContextPath()%>/images/actualizar.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
                
                <div class="d-flex gap-2 w-100 justify-content-between">
                    <div>
                        <h6 class="mb-0">Cookies</h6>
                        <p class="mb-0 opacity-75">Registro con Servlet.</p>
                    </div>
                    <small class="opacity-50 text-nowrap">>></small>
                </div>
            </a>
		</div>

	</div>
	<br/><br/><br/>
	<jsp:include page="/componentes/footerPublico.jsp"></jsp:include>
</body>
</html>