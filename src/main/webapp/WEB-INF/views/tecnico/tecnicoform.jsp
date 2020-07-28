<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../views/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${tecnicoForm['new']}">
			<h1>Agregar Tecnico</h1>
		</c:when>
		<c:otherwise>
			<h1>Actualizar Tecnico</h1>
		</c:otherwise>
	</c:choose>
	<br />

	

	<form:form class="form-horizontal" method="post"
		modelAttribute="tecnicoForm" action="${pageContext.request.contextPath}/tecnico">

		<form:hidden path="idtecnico" />

		<spring:bind path="nombre">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nombre</label>
				<div class="col-sm-10">
					<form:input path="nombre" type="text" class="form-control "
						id="name" placeholder="Nombre" />
					<form:errors path="nombre" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="apellido">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Apellido</label>
				<div class="col-sm-10">
					<form:input path="apellido" class="form-control" id="email"
						placeholder="Apellido" />
					<form:errors path="apellido" class="control-label" />
				</div>
			</div>
		</spring:bind>

		


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${tecnicoForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>


		<!-- Custom Script, Spring map to model via 'name' attribute
		<div class="form-group">
			<label class="col-sm-2 control-label">Number</label>
			<div class="col-sm-10">

				<c:forEach items="${numberList}" var="obj">
					<div class="radio">
						<label> 
							<input type="radio" name="number" value="${obj}">${obj}
						</label>
					</div>
				</c:forEach>
			</div>
		</div>
 		-->


	</form:form>

</div>

<jsp:include page="../../views/footer.jsp" />

</body>
</html>