<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inicio</title>
<jsp:include page="/componentes/utilities.jsp"></jsp:include>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/index/fontAwesome.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/index/hero-slider.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/index/templatemo-main.css">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/index/owl-carousel.css">
</head>
<body>
    <%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
    <div class="fixed-side-navbar">
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link" href="#home"><span>Inicio</span></a></li>
            <c:if test="${usuario == null }">
                <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/pages/login.jsp"><span>Login</span></a></li>
            <li class="nav-item"><a class="nav-link"
                href="<%=request.getContextPath()%>/pages/registrar.jsp"><span>Registrarse</span></a></li>
            </c:if>
            <c:if test="${usuario != null }">
                <li class="nav-item"><a class="nav-link"
                    href="<%=request.getContextPath()%>/pages/perfil.jsp"><span>Tablero</span></a></li>
            </c:if>

        </ul>
    </div>

    <div class="parallax-content baner-content" id="home"
        style="background-image: url('<%=request.getContextPath()%>/images/1st-section.jpg')">
        <div class="container">
            <div class="first-content">
                <h1>OJO DE PEZ</h1>
                <span><em>Arte &</em> Fotograf&iacute;a</span>
                <div class="primary-button">
                    <a href="#services">Descubrir m&aacute;s</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/componentes/footerIndex.jsp"></jsp:include>
    <script src="<%=request.getContextPath()%>/js/index/plugins.js"></script>
    <script src="<%=request.getContextPath()%>/js/index/main.js"></script>
</body>
</html>