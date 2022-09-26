<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tablero</title>
<jsp:include page="/componentes/perfilUtilities.jsp"></jsp:include>
</head>
<body>
    <%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
    <c:if test="${usuario == null }">
        <%
        response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        %>
    </c:if>
    <jsp:include page="/componentes/sidebarPerfil.jsp"></jsp:include>
    <div class="wrapper d-flex flex-column min-vh-100 bg-light">
        <jsp:include page="/componentes/headerPerfil.jsp">
            <jsp:param value="Rol" name="textoSeccion" />
        </jsp:include>
        <div class="body flex-grow-1 px-3">
            <div class="container-lg">
                <div class="row">
                    <main class="col-12">
                        <c:choose>
                            <c:when test="${errorCrear != null}">
                                <div class="alert alert-danger mt-3"
                                    role="alert">
                                    <h4 class="alert-heading">Hubo
                                        un error</h4>
                                    <p>${errorCrear}</p>
                                </div>
                            </c:when>
                        </c:choose>
                        <div
                            class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                            <h1 class="h2">Registrar rol</h1>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col">
                                <form method="post"
                                    action="<%=request.getContextPath()%>/Rol/crear">
                                    <div class="mb-3 row">
                                        <label for="nombre"
                                            class="col-sm-2 col-form-label">Nombre</label>
                                        <div class="col-sm-10">
                                            <input type="text"
                                                class="form-control"
                                                name="nombre">
                                        </div>
                                    </div>

                                    <div class="mb-3 row">
                                        <label for="descripcion"
                                            class="col-sm-2 col-form-label">Descripcion</label>
                                        <div class="col-sm-10">
                                            <input type="text"
                                                class="form-control"
                                                name="descripcion">
                                        </div>
                                    </div>

                                    <div
                                        class="mb-3 row justify-content-end">
                                        <div class="col-3">
                                            <button type="submit"
                                                class="btn btn-success text-white mb-3 w-100">Agregar</button>
                                        </div>

                                        <div class="col-3">
                                            <a
                                                class="btn btn-labeled btn-danger text-white mb-3 w-100"
                                                href="<%=request.getContextPath()%>/pages/rol/registrosRol.jsp"
                                                role="button">Cancelar</a>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
        </div>
        <jsp:include page="/componentes/footerPerfil.jsp"></jsp:include>
    </div>
</body>
</html>