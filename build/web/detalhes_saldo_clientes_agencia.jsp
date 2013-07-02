<%-- 
    Document   : detalhes_saldo_clientes
    Created on : 22/04/2013, 08:26:59
    Author     : Thalyta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main">
         <table border="1">
                    <thead>
                    <td>Nome</td>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="cliente">
                            <tr> 
                                <td><a href="ControleAgenciaServlet?cmd=detail_clientes_agencia&id=${cliente.id}">${cliente.nome}</a></td>
                            </tr>
                      </c:forEach>
                    </tbody>
                
         </table>
                   <br/><a href="HomeGerenteDeAgencia">Home</a>
        </div>
</html>
