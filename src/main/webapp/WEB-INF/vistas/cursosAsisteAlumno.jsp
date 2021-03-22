<%@ include file="header.jsp" %>

<div class = "container">
			<h1 class="text-info m-2">Inscripto</h1>
			<hr class="mb-3">
			
			<h3>Alumno: ${alumno.getNombre()} ${alumno.getApellido()} esta inscripto a los siguientes cursos</h3>
			
		<div class="table-responsive-xl">
        <table class="table">
        <thead>
        <tr class="text-center bg-secondary text-light" >
            <th scope="col">ID</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">COMISION</th> 
            <th scope="col">ABANDONAR</th>
            
        </tr>
        </thead>
        
       <c:if test="${empty cursos}">  
       <tbody>
       	<tr class="text-center">
    	<th scope="row">No disponible</th>
    	<td scope="col">No disponible</td>
   	    <td scope="col">No disponible</td>
   	    <td scope="col"><button type="button"  disabled="true"  class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  		<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
		</svg></button></td>

   	    
  		</tr> 	
        </tbody> 
       
       </c:if>
        
       <c:if test="${not empty cursos}">   
       <c:forEach items="${cursos}" var="curso">
        <tbody>
       	<tr class="text-center">
    	<th scope="row">${curso.getId()}</th>
    	<td scope="col">${curso.getNombreDelCurso()}</td>
   	    <td scope="col">${curso.getComision()}</td>
   	    
   	    <form action="eliminarAlumnoDelCurso">
   	    <input type=hidden id="idAlumno" name="idAlumno" value="${alumno.getId()}">
   	    <input type=hidden  id="idCurso" name="idCurso" value="${curso.getId()}">
   	    
   	    
   	    <td scope="col"><button type="submit" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  		<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
		</svg></button></td>
		</form>
		
	
   	    
  		</tr> 	
        </tbody>
        </c:forEach>    
        </c:if> 
		</table>
			

	</div>
</div>

