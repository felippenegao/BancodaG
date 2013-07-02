<%-- 
    Document   : detalhe_saldo
    Created on : 22/04/2013, 08:55:06
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
            <table>
                
            <c:forEach items="${usuario}" var="u">
                <td>Nome: ${u.nome}</td>
                <td>Email: ${u.email}</td>
                <td>Login: ${u.login}</td>
                <td>CPF: ${u.cpf}</td>
                <td>RG: ${u.rg}</td>
                <td>Data Nascimento: ${u.dataNasc}</td>
                <td>Rua: ${u.rua}</td>
                <td>Bairro: ${u.bairro}</td>
                <td>CEP: ${u.cep}</td>
                <td>Cidade: ${u.cidade}</td>
                <td>Estado: ${u.estado}</td>
            </c:forEach>
            </table>
        </div>
    </body>
</html>
