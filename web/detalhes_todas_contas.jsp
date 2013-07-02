<%-- 
    Document   : detalhes_clientes
    Created on : 12/04/2013, 09:16:23
    Author     : Thalyta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${listaDeContas.size() > 0}">
                <table border="1">
                    <thead>
                    <td>Numero</td>
                </thead>
                <tbody>
                    <c:forEach  items="${listaDeContas}" var="conta">
                        <tr>
                            <td><a href="SelectConta?id=${conta.id}">${conta.numero}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
    </c:choose>
    <br/>
    <a href="HomeGerenteGeral">Home</a>
</body>
</html>
