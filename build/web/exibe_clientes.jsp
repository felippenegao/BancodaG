<%-- 
    Document   : listagem_clientes
    Created on : 12/04/2013, 08:24:36
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
         <c:when test="${listaDeUsuarios.size() > 0}">
           <table border="1">
                <thead>
                    <td>Nome</td>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="0" end="${listaDeUsuarios.size()-1}">
                        <tr>
                            <td><a href="SelectCliente?id=${listaDeUsuarios.get(i).id}&agencia=${numeroAgencia}">${listaDeUsuarios.get(i).nome}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            ${mensagem}<br/>
        </c:otherwise>
    </c:choose>
            <a href="listarUsuarios.jsp">Voltar</a>
</body>
</html>
