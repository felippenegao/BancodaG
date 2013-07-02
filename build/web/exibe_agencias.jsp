<%-- 
    Document   : exibe_agencias
    Created on : 26/04/2013, 10:43:55
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

        <div id="main">
            <table border="1">
                <thead>
                <td>Numero</td>
                </thead>
                <tbody>
                    <c:forEach items="${listaDeAgencias}" var="agencia">
                        <tr> 
                            <td><a href="SelectAgencia?numero=${agencia.numero}">${agencia.numero}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            <br/><a href="HomeGerenteGeral">Home</a>
        </div>

    </body>
</html>
