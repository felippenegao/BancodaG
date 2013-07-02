<%-- 
    Document   : detalhes_agencia
    Created on : 26/04/2013, 13:41:11
    Author     : Thalyta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="entidades.Agencia"%>
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
                    <td>ID da Agencia</td>
                    <td>Numero</td>
                    <td>Nome</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                    <td>Telefone</td>
                </tr>
            </thead>
            <thead>
               
                <%
                    Agencia agencia = (Agencia)request.getAttribute("agenciaSelecionada"); 
                %>
               <tr>
                   
                   <td><%= agencia.getId() %></td>
                   <td><%= agencia.getNumero() %></td>
                   <td><%= agencia.getNome() %></td>
                   <td><%= agencia.getRua() %></td>
                   <td><%= agencia.getBairro() %></td>
                   <td><%= agencia.getCidade() %></td>
                   <td><%= agencia.getEstado() %></td>
                   <td><%= agencia.getTelefone() %></td>
                </tr>
            </thead>
        <p>
            <a href="HomeGerenteGeral">Home</a>
        </p>
    </body>
</html>
