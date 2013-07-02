<%-- 
    Document   : saldo
    Created on : 04/04/2013, 10:30:23
    Author     : Thalyta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>Saldos (Cliente ${usuarioLogado.nome})</title>
    </head>
    <body>

        <h2>Saldo por conta (Cliente ${usuarioLogado.nome})</h2>

        <table border = "1" style=" padding: 10px">
            <tr>
                <th>Conta</th>
                <th>Saldo</th>
            </tr>
            
            <c:forEach items="${contas}" var="conta">
                <tr>
                    <td>${conta.numero}</td>
                    <td>${conta.saldo}</td>
                </tr>
            </c:forEach>
                <a href="HomeCliente">Home</a>
        </table>
        
    </body>
</html>
