<%-- 
    Document   : intervalo_saldo
    Created on : 19/04/2013, 12:45:37
    Author     : Thalyta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="recursos/css/geral.css" />
        <title>Consultar pelo intervalo de saldo</title>
    </head>
    <body>
        <form method="POST" action="ControleSaldoServlet">
            <div align="center">
            <h2 align="center">Digite os valores:</h2>
            <label for="saldo1" >Digite o valor 1:</label>
            <input type="text" name="saldo1" id="saldo1"/></br>
            <label for="saldo2">Digite o valor 2:</label>
            <input type="text" name="saldo2" id="saldo2"/></br>
            <input type="submit" name="buscar" value="Enviar"  /></br>
        </form>
        </br><a href="HomeGerenteDeAgencia">Home</a>
    </body>
</html>
