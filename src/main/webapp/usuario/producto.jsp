<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
    href="<%=request.getContextPath()%>/css/bootstrap-5.0.2/dashboard.css">

<link rel="stylesheet" type="text/css"
    href="<%=request.getContextPath()%>/css/bootstrap-5.0.2/dashboard.rtl.css">
</head>
<body>
    <%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    %>
    <c:if test="${usuario == null }">
        <jsp:forward page="./login.jsp"></jsp:forward>
    </c:if>
    <jsp:include page="/componentes/adminHeader.jsp">
        <jsp:param value="${usuario.getCorreo()}" name="correoUsuario" />
    </jsp:include>

    <div class="container-fluid">
        <div class="row">
            <jsp:include page="/componentes/menuLateral.jsp"></jsp:include>
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">PRODUCTO</h1>


                    <a class="btn btn-labeled btn-primary"
                        href="<%=request.getContextPath()%>/usuario/registrarProducto.jsp"
                        role="button"><span class="btn-label pe-2"><i
                            class="fa fa-plus"></i></span>Nuevo producto</a>

                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th class="col-md-1" scope="col">Id</th>
                                <th class="col-md-3" scope="col">Nombre</th>
                                <th class="col-md-4" scope="col">Descripcion</th>
                                <th class="col-md-2" scope="col">Precio</th>
                                <th class="col-md-2" scope="col">Existencias</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Bocadin</td>
                                <td>Galleta con cobertura de chocolate</td>
                                <td>$10.00</td>
                                <td>65,000</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Chupa Chups</td>
                                <td>Paletas de caramelo Chupa Chups Cremosa sabor helado</td>
                                <td>$8.00</td>
                                <td>420,000</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Paleta Payaso</td>
                                <td>Paleta de malvavisco Ricolino con cobertura sabor chocolate y gomitas</td>
                                <td>$25.00</td>
                                <td>120,000</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </div>
</body>
</html>