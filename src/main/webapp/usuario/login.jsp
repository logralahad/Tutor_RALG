<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesi&oacute;n</title>
<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
    href="<%=request.getContextPath()%>/css/bootstrap-5.0.2/signin.css">
</head>
  <body class="text-center">
    
<main class="form-signin w-100 m-auto">
  <form action="<%=request.getContextPath()%>/Usuario/login">
    <img class="mb-4" src="<%=request.getContextPath()%>/images/login.png" alt="" width="72">
    <h1 class="h3 mb-3 fw-normal">Iniciar sesi&oacute;n</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" name="correo" placeholder="name@example.com">
      <label for="floatingInput">Correo electr&oacute;nico</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="contrasenia" placeholder="Password">
      <label for="floatingPassword">Contrase&ntilde;a</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Recuerdame
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017 - 2022</p>
  </form>
</main>
</body>
</html>