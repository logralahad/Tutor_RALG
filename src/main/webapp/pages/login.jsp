<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesi&oacute;n</title>
<jsp:include page="/componentes/utilities.jsp"></jsp:include>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/login/icomoon/icons.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/login/style.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/login/owl-carousel.min.css">
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
    <div class="d-lg-flex half">
        <div class="bg order-1 order-md-2"
            style="background-image: url('<%=request.getContextPath()%>/images/bg_1.jpg');"></div>
        <div class="contents order-2 order-md-1">

            <div class="container">
                <div
                    class="row align-items-center justify-content-center">
                    <div class="col-md-7">
                        <div class="row justify-content-between mb-4">
                            <div class="col-11">
                                <h3>Iniciar sesi&oacute;n</h3>
                                <p class="mb-4">Es un gusto tenerte
                                    de vuelta.</p>
                            </div>

                            <div class="col-1 align-self-center">
                                <a
                                    href="<%=request.getContextPath()%>/index.jsp">
                                    <i class="fa-solid fa-house fa-xl"></i>
                                </a>
                            </div>
                        </div>
                        <form method="post"
                            action="<%=request.getContextPath()%>/Usuario/login">
                            <div class="form-group first">
                                <label for="username">Correo</label> <input
                                    type="text" class="form-control"
                                    name="username">
                            </div>
                            <div class="form-group last mb-3">
                                <label for="password">Contrase&ntilde;a</label>
                                <input type="password"
                                    class="form-control" name="password">

                            </div>

                            <div
                                class="d-flex mt-3 mb-3 justify-content-center">
                                <c:if test="${errorLogin != null}">
                                    <span
                                        class="badge rounded-pill bg-danger">
                                        <i
                                        class="fa fa-exclamation-triangle"
                                        aria-hidden="true"></i> <c:out
                                            value="${errorLogin}" />
                                    </span>
                                </c:if>
                            </div>

                            <div
                                class="d-flex mb-5 justify-content-between">
                                <label
                                    class="control control--checkbox mb-0"><span
                                    class="caption">Recuerdame</span> <input
                                    type="checkbox" checked="checked" />
                                    <div class="control__indicator"></div>
                                </label> <span class="ml-auto"><a
                                    href="#" class="forgot-pass">Olvid&eacute;
                                        mi contrase&ntilde;a</a></span> <span
                                    class="ml-auto"><a
                                    href="registrar.jsp"
                                    class="forgot-pass">No tengo
                                        cuenta</a></span>
                            </div>

                            <input type="submit" value="Entrar"
                                class="btn btn-block btn-primary w-100">

                            <span
                                class="d-block text-center my-4 text-muted">&mdash;
                                o &mdash;</span>

                            <div class="social-login">
                                <a href="#"
                                    class="facebook btn d-flex justify-content-center align-items-center">
                                    <span class="icon-facebook pe-3"></span>Iniciar
                                    sesi&oacute;n con Facebook
                                </a> <a href="#"
                                    class="twitter btn d-flex justify-content-center align-items-center">
                                    <span class="icon-twitter pe-3"></span>Iniciar
                                    sesi&oacute;n con Twitter
                                </a> <a href="#"
                                    class="google btn d-flex justify-content-center align-items-center">
                                    <span class="icon-google pe-3"></span>Iniciar
                                    sesi&oacute;n con Google
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script
        src="<%=request.getContextPath()%>/js/login/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/login/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/login/main.js"></script>
</body>
</html>