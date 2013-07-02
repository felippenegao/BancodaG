<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>JSP Page</title>
    </head>
    <body>
         <h2>Extrato do Cliente (Cliente ${usuarioLogado.nome})</h2>

         <table border = "1">
            <tr>
                <th>data</th>
                <th>titular</th>
                <th>tipo</th>
                <th>valor</th>
                
            </tr>
            
            <c:forEach items="${extratos}" var="mov">
                <tr>
                    <td>${mov.data}</td>
                    <td>${mov.titular}</td>
                    <td>${mov.tipoMovimentacao}</td>
                    <td>${mov.valor}</td>
                    
                </tr>
            </c:forEach>
                
        </table>
        <br/><a href="HomeCliente">Home</a>
    </body>
</html>
