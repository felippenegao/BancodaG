<%-- 
    Document   : transferencia
    Created on : 05/04/2013, 08:17:25
    Author     : Thalyta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${cmd == null || cmd == ''}" var="cmd" >
    <% String cmd = "passo1";%>
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>Realizar Transferência</title>
    </head>
    <body>

        <h1>Realizar Transferência</h1>
        
        <c:if test="${aviso != null && aviso != ''}" var="cmd" >
            <h2>Aviso: ${aviso}</h2>
        </c:if>

        <c:choose>

            <c:when test="${cmd == 'passo1'}" >

                <h2>Informe os dados a seguir:</h2>

                <form method="POST" action="TransferenciaPasso2" >

                    <label id="conta_label" for="conta_debitar">Conta: </label>
                    <select id="conta_debitar" name="conta_debitar" >
                        <c:forEach items="${contas}" var="conta">
                            <option value="${conta.numero}">${conta.numero}</option>
                        </c:forEach>
                    </select>

                    <br />

                    <label id="conta_creditar_label" for="conta_creditar">Conta Creditada: </label>
                    <input type="text" id="conta_creditar" name="conta_creditar" />
                    
                    <br />
                    
                    <label id="valor_label" for="conta_creditar">Valor: </label>
                    <input type="text" id="valor" name="valor" />

                    <input type="submit" value="Transferir" />

                </form>
                
                <a href="HomeCliente">Home</a>

            </c:when>

            <c:otherwise>

                <p>${conteudo}</p>
                
                <a href="HomeCliente" >Home</a>
                
            </c:otherwise>

        </c:choose>

    </body>
</html>
