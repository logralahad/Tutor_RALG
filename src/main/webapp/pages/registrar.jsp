<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div class="main">
        <section class="signup">

            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Reg&iacute;strate</h2>
                        <form action="<%=request.getContextPath()%>/Usuario/registrar" class="register-form"
                            id="register-form">
                            <div class="form-group">
                                <label for="name"><i
                                    class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name"
                                    placeholder="Tu nombre" />
                            </div>
                            <div class="form-group">
                                <label for="email"><i
                                    class="zmdi zmdi-email"></i></label> <input
                                    type="email" name="email" id="email"
                                    placeholder="Tu correo" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i
                                    class="zmdi zmdi-lock"></i></label> <input
                                    type="password" name="pass"
                                    id="pass" placeholder="Contraseña" />
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i
                                    class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass"
                                    id="re_pass"
                                    placeholder="Confirma tu contraseña" />
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
                            tengo una cuenta</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>
<script src="<%=request.getContextPath()%>/js/registrar/main.js"></script>
</html>