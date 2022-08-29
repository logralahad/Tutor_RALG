<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tutor</title>
	<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/componentes/headerPublico.jsp"></jsp:include>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">

					<%  String msg = null;
						if(request.getAttribute("msg") != null) {
							msg = request.getAttribute("msg").toString();
						}
					%>
					<c:if test="${msg!=null}">
						<div class="alert alert-warning alert-dismissible fade show" role="alert">
							<strong>Error:</strong>
							<%=msg %>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
					</c:if>
					
					<h2 class="pb-2 border-bottom">Autenticar</h2>
					<form action="<%=request.getContextPath()%>/Usuario/login"
							method="post">						
						<div class="form-outline mb-4">
							<input type="email" id="correo" class="form-control form-control-lg"
								placeholder="Escriba correo electrónico" 
								name="correo"/> 
							<label class="form-label" for="correo">Usuario</label>
						</div>
						
						<div class="form-outline mb-3">
							<input type="password" id="contrasenia"
								class="form-control form-control-lg"
								placeholder="Ingresar contraseña" 
								name="contrasenia"/> 
							<label class="form-label" for="contrasenia">Contraseña</label>
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Ingresar</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</section>
	<br/><br/><br/>
	<jsp:include page="/componentes/footerPublico.jsp"></jsp:include>
</body>
</html>