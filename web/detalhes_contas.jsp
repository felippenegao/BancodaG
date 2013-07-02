<%-- 
    Document   : detalhes_clientes
    Created on : 12/04/2013, 09:16:23
    Author     : Thalyta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Diretiva --%>
<%@page import="entidades.Conta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <td>ID da Conta</td>
                    <td>Numero</td>
                    <td>Saldo</td>
                    <td>Id_Usuário</td>
                    <td>Id_Agencia </td>
                </tr>
            </thead>
            <thead>
                <!--Espressao-->
                <%
                    Conta conta = (Conta)request.getAttribute("contaSelecionada"); 
                %>
               <tr>
                   <!-- Scriplet -->
                   <td><%= conta.getId() %></td>
                   <td><%= conta.getNumero() %></td>
                   <td><%= conta.getSaldo() %></td>
                   <td><%= conta.getId_usuario() %></td>
                   <td><%= conta.getId_agencia() %></td>
                </tr>
            </thead>
        <p>
            <a href="HomeGerenteGeral">Home</a>
        </p>

</body>
</html>
