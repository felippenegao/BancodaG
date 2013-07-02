<%-- 
    Document   : listar_cpf
    Created on : 12/04/2013, 11:35:54
    Author     : Thalyta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h2 align="center">Digite o numero do CPF:</h2>
        <form method="POST" action="ControleCpfServlet?cmd=listUsers">
            <label>CPF:</label>
            <input type="text" name="cpf"/></br>
            <input type="submit" name="listar" value="Listar"/></br>
        </form>
        
        <h2>${msg}</h2>
        </div>
    </body>
</html>
