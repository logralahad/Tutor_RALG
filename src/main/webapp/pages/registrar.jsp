<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reg&iacute;strate</title>
<jsp:include page="/componentes/utilities.jsp"></jsp:include>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/registrar//material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/registrar/style.css">
</head>
<body>
    <%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
    <c:if test="${usuario != null }">
        <%
        response.sendRedirect(request.getContextPath() + "/pages/perfil.jsp");
        %>
    </c:if>
    <div class="main">
        <section class="signup">

            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Reg&iacute;strate</h2>
                        <form
                            action="<%=request.getContextPath()%>/Usuario/registrar"
                            class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="nombre"><i
                                    class="zmdi zmdi-account-circle"></i></label>
                                <input type="text" name="nombre" required
                                    id="nombre" placeholder="Tu nombre" />
                            </div>
                            
                            <div class="form-group">
                                <label for="paterno"><i
                                    class="zmdi zmdi-accounts-outline"></i></label>
                                <input type="text" name="paterno" required
                                    id="paterno" placeholder="Tu apellido paterno" />
                            </div>
                            
                            <div class="form-group">
                                <label for="materno"><i
                                    class="zmdi zmdi-accounts-alt"></i></label>
                                <input type="text" name="materno" required
                                    id="materno" placeholder="Tu apellido materno" />
                            </div>
                            <div class="form-group">
                                <label for="edad"><i
                                    class="zmdi zmdi-n-1-square"></i></label>
                                <input type="number" name="edad" required
                                    id="edad" placeholder="Tu edad" />
                            </div>
                            <div class="form-group">
                                <label for="telefono"><i
                                    class="zmdi zmdi-phone"></i></label>
                                <input type="text" name="telefono" required
                                    id="telefono" placeholder="Tu telefono" />
                            </div>
                            <div class="form-group">
                                <label for="email"><i
                                    class="zmdi zmdi-email"></i></label> <input
                                    type="email" name="correo" required
                                    id="correo" placeholder="Tu correo" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i
                                    class="zmdi zmdi-lock"></i></label> <input
                                    type="password" name="password"
                                    id="password" required
                                    placeholder="Contraseņa" />
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i
                                    class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" required
                                    name="re_password" id="re_password"
                                    placeholder="Confirma tu contraseņa" />
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term"
                                    id="agree-term" class="agree-term" />
                                <label for="agree-term"
                                    class="label-agree-term"><span><span></span></span>Acepto
                                    todos los <a href="#"
                                    class="term-service">T&eacute;rminos
                                        y condiciones</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup"
                                    id="signup" class="form-submit"
                                    value="Registrarse" />
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure>
                            <img
                                src="<%=request.getContextPath()%>/images/signup-image.jpg"
                                alt="sing up image">
                        </figure>
                        <a href="login.jsp" class="signup-image-link">Ya
                            tengo una cuenta</a> <a href="<%=request.getContextPath()%>/index.jsp"
                            class="signup-image-link">Regresar al inicio</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>
<script src="<%=request.getContextPath()%>/js/registrar/main.js"></script>
</html>