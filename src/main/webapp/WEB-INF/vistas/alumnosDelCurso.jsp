<%@ include file="header.jsp" %>
<%@ include file="headerBody.jsp" %>


<div class = "container">
			<h1 class="letraRellena2 m-2">Curso</h1>
			<hr class="mb-3">
			
			<h3 class="letraRellena3 m-3" >${curso.getNombreDelCurso()}, asisten:</h3>
			
				<div class="table-responsive-xl">
        <table class="table">
        <thead>
        <tr class="text-center table-active bg-secondary text-light">
            <th scope="col">ID</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">APELLIDO</th>
            <th scope="col">DNI</th> 
            <th scope="col">ELIMINAR</th> 
            
            
        </tr>
        </thead>
        
       <c:if test="${empty alumnos}">  
       <tbody class="bg-light">
       	<tr class="text-center">
    	<th scope="col">No disponible</th>
    	<td scope="col">No disponible</td>
   	    <td scope="col">No disponible</td>
   	    <td scope="col">No disponible</td>
   	    <td scope="col"><button type="button"  disabled="true" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  		<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
		</svg></button></td>
		</c:if>
   	    
   	    <c:if test="${not empty alumnos}">   
        <c:forEach items="${alumnos}" var="alumno">
        <tbody class="bg-light">
       	<tr class="text-center">
    	<th scope="row">${alumno.getId()}</th>
    	<td scope="col">${alumno.getNombre()}</td>
    	<td scope="col">${alumno.getApellido()}</td>
   	    <td scope="col">${alumno.getDni()}</td>
   	   
		
		<form action="eliminarAlumnoDelCurso">
		<input type=hidden name="idAlumno" id="idAlumno" value="${alumno.getId()}">
		<input type=hidden name="idCurso" id="idCurso" value="${curso.getId()}">
		<input type=hidden name="auxiliar" id="auxiliar" value="1">
		
   	    <td scope="col"><button type="submit" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  		<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
		</svg></button>
		</td></form>
   	    
   	    
  		</tr>  		
        </tbody>
        </c:forEach>
        </c:if>
        
  		</tr> 	
        </tbody> 
       
       </table>
       </div>
			

</div>

<%@ include file="footer.jsp" %>
