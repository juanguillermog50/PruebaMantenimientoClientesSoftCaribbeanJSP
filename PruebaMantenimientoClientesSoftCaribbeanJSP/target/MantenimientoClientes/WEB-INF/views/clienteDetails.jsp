<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Clientes</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}

#divErrores {
	color: yellow;
	background-color: red;
	margin-bottom: 10px;
}

.error {
	font-weight: bold;
}
</style>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#registrar").validate({
			rules : {
				"txtNombre" : {
					required : true,
					lettersonly : true
				},
				"txtUsuario" : {
					required : true,
					lettersonly : true
				},
				"txtEmail" : {
					required : true,
					email : true
				}
			},
			messages : {
				"txtNombre" : {
					required : "Introduce el nombre",
					lettersonly : "Sólo se admiten letras en el nombre"
				},
				"txtUsuario" : {
					required : "Introduce los apellidos",
					lettersonly : "Sólo se admiten letras en los apellidos"
				},
				"txtEmail" : {
					required : "Introduce tu E-Mail",
					email : "La dirección E-Mail no tiene formato correcto"
				}
			},
			errorContainer : $("#divErrores"),
			errorLabelContainer : "#divErrores ul",
			errorElement : "span",
			wrapper : "li",
			submitHandler : function(form) {
				alert("Los datos son correctos");
			}
		});
	});
</script>
</head>
<body>
	<div id="divErrores">
		<ul id="lista"></ul>
	</div>
	<form:form id="registrar" name="registrar" method="post" modelAttribute="cliente"
		action="${pageContext.request.contextPath}/addCliente">
		<table>
			<tr>
				<th colspan="2">Agregar Cliente</th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="codigo">Documento Cliente:</form:label></td>
				<td><form:input path="codigo" size="15" maxlength="15"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input id="txtNombre" path="nombre" size="120"
						maxlength="120"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="direccion">Dirección:</form:label></td>
				<td><form:input path="direccion" size="120" maxlength="120"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input id="txtEmail" path="email" size="120"
						maxlength="120"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="fechaRegistro">Fecha de Registro:</form:label></td>
				<td><form:input path="fechaRegistro" type="date"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="fechaBaja">Fecha de Baja:</form:label></td>
				<td><form:input path="fechaBaja" type="date"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="usuario">Usuario:</form:label></td>
				<td><form:input id="txtUsuario" path="usuario" size="120"
						maxlength="120"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="activo">Activo:</form:label></td>
				<td><form:input path="activo" size="1" maxlength="1"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Teléfono:</form:label></td>
				<td><form:input path="telefono" size="60" maxlength="60"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="contacto">Contacto:</form:label></td>
				<td><form:input path="contacto" size="120" maxlength="120"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="logo">Logo:</form:label></td>
				<td><form:input path="logo" size="50" maxlength="50"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	<h3 id="h3">Lista de Clientes</h3>
	<c:if test="${!empty listOfClientes}">
		<table id="tclientes" class="tg">
			<tr>
				<th width="30">Id</th>
				<th width="30">Documento</th>
				<th width="120">Nombre</th>
				<th width="120">Dirección</th>
				<th width="60">Email</th>
				<th width="30">Registro</th>
				<th width="30">Baja</th>
				<th width="30">Usuario</th>
				<th width="20">Activo</th>
				<th width="30">Teléfono</th>
				<th width="30">Contacto</th>
				<th width="30">Logo</th>
			</tr>
			<c:forEach items="${listOfClientes}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.codigo}</td>
					<td>${cliente.nombre}</td>
					<td>${cliente.direccion}</td>
					<td>${cliente.email}</td>
					<td>${cliente.fechaRegistro}</td>
					<td>${cliente.fechaBaja}</td>
					<td>${cliente.usuario}</td>
					<td>${cliente.activo}</td>
					<td>${cliente.telefono}</td>
					<td>${cliente.contacto}</td>
					<td>${cliente.logo}</td>
					<td><a href="<c:url value='/updateCliente/${cliente.id}' />">Editar</a></td>
					<td><a href="<c:url value='/deleteCliente/${cliente.id}' />">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>