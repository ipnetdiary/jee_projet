<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.javabeins.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int i = 1;
	List<Personne> list = (List) request.getAttribute("personnes");

	for (Personne u : list) {
	%>

	<span><%=i++%></span>
	<span><%=u.getNom()%></span>
	<span><%=u.getPrenom()%></span>

	<%
	}
	%>


	<c:forEach items="${personnes}" var="value">
		<c:out value="${value.nom}" />
	</c:forEach>
</body>
</html>