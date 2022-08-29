<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ralg.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hasta luego</title>
</head>
<body>
    <%
    session.removeAttribute("usuario");
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
    %>
</body>
</html>