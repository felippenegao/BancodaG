<%-- 
    Document   : detalhes_saldo_clientes_geral
    Created on : 26/04/2013, 10:52:31
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
                    <td>Contas</td>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="conta">
                            <tr> 
                                <td><a href="SelectConta?id=${conta.id}">${conta.numero}</a></td>
                            </tr>
                      </c:forEach>
                    </tbody>
                
         </table>
                   <br/><a href="HomeGerenteGeral">Home</a>
        </div>
</html>
