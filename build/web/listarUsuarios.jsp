
<%-- 
    Document   : listarUsuarios
    Created on : 09/04/2013, 10:41:27
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
        <h2 align="center">Digite o numero da agencia:</h2>
        
        <form method="POST" action="ControleAgenciaServlet?cmd=listUsers">            
            <label>Agencia:</label>
            <input type="text" name="agencia" var="agencia"/></br>            
            
            <input type="submit" name="listar" value="Listar"/></br>
        </form>
        </div>
        
        <a href ="HomeGerenteDeAgencia" >Home</a>
        
    </body>
</html>
