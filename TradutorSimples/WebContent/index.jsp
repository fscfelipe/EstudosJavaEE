<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tradutor</title>
</head>
<body>

	<h1>Tradutor</h1><hr>
	<form action="tradutor">
		Palavra: <input type="text" name="palavra"> <input
			type="submit" value="Traduzir">
	</form>
	
	<c:if test = "${flag}">
         <p>Tradução:  <b><c:out value = "${palavra}"/></b><p>
    </c:if>
    
    <c:if test = "${(not empty palavra) && (!flag)}">
         <p>A palavra <b>${palavra}</b> não possui tradução <p>
    </c:if>
	

</body>
</html>