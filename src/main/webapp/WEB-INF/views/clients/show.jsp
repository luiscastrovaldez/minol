<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../views/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Detalle Cliente</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${client.clientId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">CODIGO</label>
		<div class="col-sm-10">${client.clientCode}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">NOMBRE</label>
		<div class="col-sm-10">${client.clientName}</div>
	</div>

</div>

<jsp:include page="../../views/footer.jsp" />

</body>
</html>