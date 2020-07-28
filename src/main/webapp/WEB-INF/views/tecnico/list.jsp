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

		<h1>Listado Tecnicos</h1>
		
				<td>
		<button class="btn btn-success" onclick="this.disabled=true;post('${pageContext.request.contextPath}/tecnico/add')">Agregar</button>
		</td>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>NOMBRE Y APELLIDO</th>
					
					
				</tr>
			</thead>

			<c:forEach var="tecnico" items="${tecnico}">
			    <tr>
				<td>
					${tecnico.idtecnico}
				</td>
				<td>${tecnico.nombre} ${tecnico.apellido}</td>
			
				<td>
				  
				  <button class="btn btn-info"
                                          onclick="location.href='${pageContext.request.contextPath}/tecnico/${tecnico.idtecnico}'">Ver</button>
				  <button class="btn btn-primary"
                                          onclick="location.href='${pageContext.request.contextPath}/tecnico/${tecnico.idtecnico}/update/'">Actualizar</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${pageContext.request.contextPath}/tecnico/${tecnico.idtecnico}/delete/')">Eliminar</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../../views/footer.jsp" />

</body>
</html>