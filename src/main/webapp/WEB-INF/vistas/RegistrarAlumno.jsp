<%@ include file="header.jsp"%>
<div class="container">
	<h1 class="letraRellena2 m-2">Registrar alumno</h1>
	<hr class="mb-3">


	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4 bg-secondary mt-5">

				<form id="alumno" action="alumnoRegistrado" class="mt-4 text-white">

					<label for="nombre">Nombre:</label> <input name="nombre"
						id="nombre" class="form-control" placeholder="Nombre(s)" /> <label
						for="apellido">Apellido:</label> <input name="apellido"
						id="apellido" class="form-control" placeholder="Apellido(s)">

					<label for="dni">DNI:</label> <input name="dni" id="dni"
						class="form-control" placeholder="dni" type="number" />

					<button type="submit"
						class="btn btn-info btn-lg btn-block mt-5 mb-5">Registrar</button>
				</form>

			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>


</div>

<%@ include file="footer.jsp" %>

