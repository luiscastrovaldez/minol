<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en" >

<jsp:include page="../views/header.jsp" />

<body>

	<div class="container">
		
		<h1>Menu</h1>
		<spring:url value="/clients" var="clientUrl" />
		<a href="${pageContext.request.contextPath}/clients">Clientes</a>
		
		<spring:url value="/maquina" var="maquinaUrl" />
		<a href="${pageContext.request.contextPath}/maquina">Maquinas</a>
		
		<spring:url value="/tecnico" var="tecnicoUrl" />
		<a href="${pageContext.request.contextPath}/tecnico">Tecnicos</a>
	</div>

	<jsp:include page="../views/footer.jsp" />

</body>
</html>