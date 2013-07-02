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
            <c:when test="${usuarioSelecionadoPelaAgencia != null}">
                <table border="1">
                    <thead>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Login</td>
                    <td>Cpf</td>
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cep</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                </thead>
                <tbody>
                    <tr> 
                        <td>${usuarioSelecionadoPelaAgencia.nome}</td>
                        <td>${usuarioSelecionadoPelaAgencia.email}</td>
                        <td>${usuarioSelecionadoPelaAgencia.login}</td>
                        <td>${usuarioSelecionadoPelaAgencia.cpf}</td>
                        <td>${usuarioSelecionadoPelaAgencia.rg}</td>
                        <td>${usuarioSelecionadoPelaAgencia.datanasc}</td>
                        <td>${usuarioSelecionadoPelaAgencia.rua}</td>
                        <td>${usuarioSelecionadoPelaAgencia.bairro}</td>
                        <td>${usuarioSelecionadoPelaAgencia.cep}</td>
                        <td>${usuarioSelecionadoPelaAgencia.cidade}</td>
                        <td>${usuarioSelecionadoPelaAgencia.estado}</td>
                    </tr>
                </tbody>
                <p>
                    <a href="ControleAgenciaServlet?cmd=listUsers&agencia=${agencia}">Voltar</a>
                </p>
            </c:when>
            <c:when test="${usuarioLocalizadoPeloGerenteGeralPeloSaldo != null}">
                <table border="1">
                    <thead>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Login</td> 
                    <td>Cpf</td>
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cep</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                    </thead>
                    <tbody>
                        <tr> 
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.nome}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.email}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.login}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.cpf}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.rg}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.datanasc}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.rua}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.bairro}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.cep}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.cidade}</td>
                            <td>${usuarioLocalizadoPeloGerenteGeralPeloSaldo.estado}</td>
                        </tr>
                    </tbody>
                    <br/><a href="HomeGerenteGeral">Home</a>
                </table>
            </c:when>
            <c:when test="${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo != null}">
                <table border="1">
                    <thead>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Login</td> 
                    <td>Cpf</td>
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cep</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                    </thead>
                    <tbody>
                        <tr> 
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.nome}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.email}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.login}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.cpf}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.rg}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.datanasc}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.rua}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.bairro}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.cep}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.cidade}</td>
                            <td>${usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo.estado}</td>
                        </tr>
                    </tbody>
                    <br/><a href="HomeGerenteDeAgencia">Home</a>
                </table>
            </c:when>
            <c:when test="${usuarioLocalizadoPeloCpf != null}">
                <table border="1">
                    <thead>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Login</td> 
                    <td>Cpf</td>
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cep</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                    </thead>
                    <tbody>
                        <tr> 
                            <td>${usuarioLocalizadoPeloCpf.nome}</td>
                            <td>${usuarioLocalizadoPeloCpf.email}</td>
                            <td>${usuarioLocalizadoPeloCpf.login}</td>
                            <td>${usuarioLocalizadoPeloCpf.cpf}</td>
                            <td>${usuarioLocalizadoPeloCpf.rg}</td>
                            <td>${usuarioLocalizadoPeloCpf.datanasc}</td>
                            <td>${usuarioLocalizadoPeloCpf.rua}</td>
                            <td>${usuarioLocalizadoPeloCpf.bairro}</td>
                            <td>${usuarioLocalizadoPeloCpf.cep}</td>
                            <td>${usuarioLocalizadoPeloCpf.cidade}</td>
                            <td>${usuarioLocalizadoPeloCpf.estado}</td>
                        </tr>
                    </tbody>
                    <br/><a href="HomeGerenteDeAgencia">Home</a>
                </table>
            </c:when>


            <c:when test="${lista != null}">
                <table border="1">
                    <thead>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Login</td> 
                    <td>Cpf</td>
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>Rua</td>
                    <td>Bairro</td>
                    <td>Cep</td>
                    <td>Cidade</td>
                    <td>Estado</td>
                    </thead>
                    <c:forEach items="${lista}" var="cliente">
                        <tbody>
                            <tr> 
                                <td>${lista.nome}</td>
                                <td>${lista.email}</td>
                                <td>${lista.login}</td>
                                <td>${lista.cpf}</td>
                                <td>${lista.rg}</td>
                                <td>${lista.datanasc}</td>
                                <td>${lista.rua}</td>
                                <td>${lista.bairro}</td>
                                <td>${lista.cep}</td>
                                <td>${lista.cidade}</td>
                                <td>${lista.estado}</td>
                            </tr>
                        </tbody>
                        <br/><a href="HomeGerenteDeAgencia">Home</a>
                    </c:forEach>
                </table>
            </c:when>

        </c:choose>

</body>
</html>
