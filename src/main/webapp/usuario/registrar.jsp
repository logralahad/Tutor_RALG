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
	<section class="vh-200">
		<div class="container-fluid h-custom">
			<div class="row d-flex justify-content-center align-items-center h-200">
				<div class="col-md-12 col-lg-10 col-xl-6">

					<%  String msg = null;
						if(request.getAttribute("msg") != null) {
							msg = request.getAttribute("msg").toString();
						}
					%>
					<c:if test="${msg!=null}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>Error:</strong>
							<%=msg %>
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</c:if>

					<h2 class="pb-2 border-bottom">Registrar</h2>
					<form method="POST"
						action="<%=request.getContextPath()%>/Usuario/registrar">
						<div class="mb-3 row">
							<label for="nombre" class="col-sm-3 col-form-label">Nombre:</label>
							<div class="col-sm-9">
								<input type="text" name="nombre" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="apePaterno" class="col-sm-3 col-form-label">Apellido paterno:</label>
							<div class="col-sm-9">
								<input type="text" name="apePaterno" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="apeMaterno" class="col-sm-3 col-form-label">Apellido materno:</label>
							<div class="col-sm-9">
								<input type="text" name="apeMaterno" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="edad" class="col-sm-3 col-form-label">Edad:</label>
							<div class="col-sm-9">
								<input type="number" name="edad" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="telefono" class="col-sm-3 col-form-label">Teléfono:</label>
							<div class="col-sm-9">
								<input type="number" name="telefono" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="correo" class="col-sm-3 col-form-label">Correo electrónico:</label>
							<div class="col-sm-9">
								<input type="email" name="correo" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="password" class="col-sm-3 col-form-label">Contraseña:</label>
							<div class="col-sm-9">
								<input type="password" name="password" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="nombreEmpresa" class="col-sm-3 col-form-label">Nombre empresa:</label>
							<div class="col-sm-9">
								<input type="text" name="nombreEmpresa" class="form-control">
							</div>
						</div>
						<div class="mb-3 row">
							<label for="direccion" class="col-sm-3 col-form-label">Dirección:</label>
							<div class="col-sm-9">
								<input type="text" name="direccion" class="form-control">
							</div>
						</div>
						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Crear cuenta</button>
						</div>
					</form>
					<label><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%></label>
				</div>
			</div>
		</div>
	</section>
	<br/><br/><br/><br/>
	<jsp:include page="/componentes/footerPublico.jsp"></jsp:include>
</body>
</html>