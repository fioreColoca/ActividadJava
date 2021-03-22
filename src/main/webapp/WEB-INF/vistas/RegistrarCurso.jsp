<%@ include file="header.jsp"%>
<div class="container">
	<h1 class="text-info m-2">Registrar curso</h1>
	<hr class="mb-3">


	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4 bg-secondary mt-5">
				<form action="cursoRegistrado" id="curso" class="mt-4 text-white">

					<label for="nombre">Nombre:</label> <input type="text"
						class="form-control mb-3" placeholder="Ingrese nombre del curso"
						required name="nombre" id="nombre"> <label for="apellido">Comision:</label>
					<input type="text" class="form-control mb-3"
						placeholder="Ingrese comision" required name="comision"
						id="comision"> 

					<button type="submit"
						class="btn btn-info btn-lg btn-block mt-5 mb-5">Registrar</button>
				</form>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>

</div>
