<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en" >

<jsp:include page="../../views/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
	
		<h1>Listado Clientes</h1>
		
		<td>
		<button class="btn btn-success" onclick="this.disabled=true;post('${pageContext.request.contextPath}/clients/add')">Agregar</button>
		</td>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Code</th>
					<th>Razon Social</th>					
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="client" items="${clients}">
			    <tr>
				<td>
					${client.clientId}
				</td>
				<td>${client.clientCode}</td>
				<td>${client.clientName}</td>				
				<td>
				  
				  <button class="btn btn-info"
                                          onclick="location.href='${pageContext.request.contextPath}/clients/${client.clientId}'">Ver</button>
				  <button class="btn btn-primary"
                                          onclick="location.href='${pageContext.request.contextPath}/clients/${client.clientId}/update/'">Actualizar</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${pageContext.request.contextPath}/clients/${client.clientId}/delete/')">Eliminar</button>
               
               		
                </td>	
			    </tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../../views/footer.jsp" />

</body>
</html>