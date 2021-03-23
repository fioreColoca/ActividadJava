<%@ include file="header.jsp" %>
<%@ include file="headerBody.jsp" %>


<div class = "container">
			<h1 class="letraRellena2 m-2">Inscripcion a cursos</h1>
			<hr class="mb-3">
			
			<h3 class="letraRellena3">Alumno: ${alumno.getNombre()} ${alumno.getApellido()} </h3>
			
		<div class="table-responsive-xl">
        <table class="table">
        <thead>
        <tr class="text-center bg-secondary text-light" >
            <th scope="col">ID</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">COMISION</th> 
            <th scope="col">ANOTARSE</th>
            
        </tr>
        </thead>
        
       <c:if test="${empty cursos}">  
       <tbody class="bg-light">
       	<tr class="text-center">
    	<th scope="row">No disponible</th>
   	    <td scope="col">No disponible</td>
   	    <td scope="col">No disponible</td>
   	    <td scope="col"><button type="button"  disabled="true"  class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  		<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
		</svg></button></td>

   	    
  		</tr> 	
        </tbody> 
       
       </c:if>
        
       <c:if test="${not empty cursos}">   
       <c:forEach items="${cursos}" var="curso">
        <tbody class="bg-light">
       	<tr class="text-center">
    	<th scope="row">${curso.getId()}</th>
    	<td scope="col">${curso.getNombreDelCurso()}</td>
   	    <td scope="col">${curso.getComision()}</td>
   	    
   	    <form action="alumnoIncripcionCurso">
   	    <input type=hidden id="idAlumno" name="idAlumno" value="${alumno.getId()}">
   	    <input type=hidden  id="idCurso" name="idCurso" value="${curso.getId()}">
   	    
   	    <td scope="col"><button type="submit" class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  		<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
		</svg></button></td>
		</form>
		
	
   	    
  		</tr> 	
        </tbody>
        </c:forEach>    
        </c:if> 
			

	</div>
</div>


<%@ include file="footer.jsp" %>

