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
            <jsp:param value="Personas registradas" name="textoSeccion" />
        </jsp:include>
        <div class="body flex-grow-1 px-3">
            <div class="container-lg">
                <div class="row">
                    <main class="col-12">
                        <div
                            class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-4 border-bottom">
                            <a class="btn btn-labeled btn-primary"
                                href="<%=request.getContextPath()%>/pages/persona/crearPersona.jsp"
                                role="button"><span
                                class="btn-label pe-2"><i
                                    class="fa fa-plus"></i></span>Nueva persona</a>
                            <a
                                class="btn btn-labeled btn-success text-white"
                                href="<%=request.getContextPath()%>/Persona/descargarExcel"
                                role="button"><span
                                class="btn-label pe-2"><i
                                    class="fa fa-file-excel-o"></i></span>Exportar
                                a Excel</a>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                    <tr>
                                        <th
                                            class="col-2 text-center align-middle"
                                            scope="col">Id</th>
                                        <th
                                            class="col-4 text-center align-middle"
                                            scope="col">Nombre</th>
                                        <th
                                            class="col-4 text-center align-middle"
                                            scope="col">RFC</th>
                                        <th scope="col"
                                            class="col-1 text-center align-middle"></th>
                                        <th scope="col"
                                            class="col-1 text-center align-middle"></th>
                                    </tr>
                                </thead>


                                <c:if test="${listaPersonas != null}">
                                    <tbody>
                                        <c:forEach
                                            items="${listaPersonas}"
                                            var="persona">
                                            <tr>
                                                <th scope="row"
                                                    class="text-center align-middle"><c:out
                                                        value="${persona.getId()}" /></th>
                                                <td
                                                    class="text-center align-middle"><c:out
                                                        value="${persona.getNombreCompleto()}" /></td>
                                                <td
                                                    class="text-center align-middle"><c:out
                                                        value="${persona.getRfc()}" /></td>
                                                <td
                                                    class="text-center align-middle">
                                                    <a
                                                    class="btn btn-labeled btn-warning w-50"
                                                    href="<%=request.getContextPath()%>/Persona/editar?id=${persona.getId()}"
                                                    role="button"><i
                                                        class="fa fa-pencil-square-o"
                                                        aria-hidden="true"></i></a>
                                                </td>
                                                <td
                                                    class="text-center align-middle">
                                                    <button
                                                        type="button"
                                                        class="btn btn-danger w-50"
                                                        onclick="askAction(
                                                            '<%=request.getContextPath()%>/Persona/eliminar?id=${persona.getId()}',
                                                            '¿Desea eliminar el elemento?')">
                                                        <i
                                                            class="fa fa-trash"
                                                            aria-hidden="true"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </c:if>
                            </table>
                        </div>
                    </main>
                </div>
            </div>
        </div>
        <jsp:include page="/componentes/footerPerfil.jsp"></jsp:include>
    </div>

    <jsp:include page="/componentes/actionsUtilities.jsp"></jsp:include>
</body>
</html>