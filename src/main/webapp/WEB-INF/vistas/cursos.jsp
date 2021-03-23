<%@ include file="header.jsp" %>
	<div class = "container">
			<h1 class="letraRellena2 m-2">Listado de todos los cursos</h1>
			<hr class="mb-3">
			
			
		<a href="RegistrarCurso" type="button" class="btn btn-info botonHome mb-3"><span>Agregar curso </span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
  		<path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
  		<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
		</svg> </a>	
			
		<div class="table-responsive-xl">
        <table class="table">
        <thead>
        <tr class="text-center bg-secondary text-light" >
            <th scope="col">ID</th>
            <th scope="col">NOMBRE</th>
            <th scope="col">COMISION</th> 
            <th scope="col">VER ALUMNOS</th>
            <th scope="col">ELIMINAR</th>
            
        </tr>
        </thead>
        
       <c:if test="${empty cursos}">  
       <tbody class="bg-light">
       	<tr class="text-center">
    	<th scope="row">No disponible</th>
    	<td scope="col">No disponible</td>
   	    <td scope="col">No disponible</td>
   	    <td scope="col"><button type="button"  disabled="true"  class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
  		<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
		</svg></button></td>
   	    <td scope="col"><button type="button"  disabled="true" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  		<path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
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
   	    
   	    <form action="alumnosDelCurso">
   	    <input type=hidden name="idCurso" id="idCurso" value="${curso.getId()}"> 
   	    <td scope="col"><button type="submit" class="btn btn-secondary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
  		<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
		</svg></button></td>
		</form>
		
		<form action="eliminarCurso">
		<input type=hidden name="eliminarCurso" id="eliminarCurso" value="${curso.getId()}">
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
		
<%@ include file="footer.jsp" %>
		
