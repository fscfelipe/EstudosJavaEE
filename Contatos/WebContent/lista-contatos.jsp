<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>

	<jsp:useBean id="dao" class="br.com.contatos.jdbc.dao.ContatoDAO"/>
	
	<table>
	  <c:forEach var="contato" items="${dao.listaContatos}" varStatus="id">
	    <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
	      <td>${contato.nome}</td>
	      <td>${contato.email}</td>
	      <td>${contato.endereco}</td>
	      <td>${contato.dataNascimento.time}</td>
	    </tr>
	  </c:forEach>
	</table>

</body>
</html>