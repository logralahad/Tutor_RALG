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

    <div class="service-content" id="services"
        style="background-image: url('<%=request.getContextPath()%>/images/2nd-section.jpg')"></div>

    <div class="parallax-content projects-content" id="portfolio"
        style="background-image: url('<%=request.getContextPath()%>/images/3rd-section.jpg')"></div>

    <div class="tabs-content" id="our-story"
        style="background-image: url('<%=request.getContextPath()%>/images/4th-section.jpg')"></div>

    <div class="parallax-content contact-content" id="contact-us"
        style="background-image: url('<%=request.getContextPath()%>/images/5th-section.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="contact-form">
                        <div class="row">
                            <form id="contact" action="" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <fieldset>
                                            <input name="name"
                                                type="text"
                                                class="form-control"
                                                id="name"
                                                placeholder="Your name..."
                                                required="">
                                        </fieldset>
                                    </div>
                                    <div class="col-md-12">
                                        <fieldset>
                                            <input name="email"
                                                type="email"
                                                class="form-control"
                                                id="email"
                                                placeholder="Your email..."
                                                required="">
                                        </fieldset>
                                    </div>
                                    <div class="col-md-12">
                                        <fieldset>
                                            <textarea name="message"
                                                rows="6"
                                                class="form-control"
                                                id="message"
                                                placeholder="Your message..."
                                                required=""></textarea>
                                        </fieldset>
                                    </div>
                                    <div class="col-md-12">
                                        <fieldset>
                                            <button type="submit"
                                                id="form-submit"
                                                class="btn">Send
                                                Message</button>
                                        </fieldset>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="map">
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1197183.8373802372!2d-1.9415093691103689!3d6.781986417238027!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xfdb96f349e85efd%3A0xb8d1e0b88af1f0f5!2sKumasi+Central+Market!5e0!3m2!1sen!2sth!4v1532967884907"
                            width="100%" height="390" frameborder="0"
                            style="border: 0" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/componentes/footerIndex.jsp"></jsp:include>
    <script src="<%=request.getContextPath()%>/js/index/plugins.js"></script>
    <script src="<%=request.getContextPath()%>/js/index/main.js"></script>
</body>
</html>