<%-- 
    Document   : listado
    Created on : 11/12/2023, 10:46:24
    Author     : Pablo
--%>

<%@page import="java.util.List"%>
<%@page import="com.codoacodo.dto.Orador"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="head.jsp" %>
        <title>
          Listado
        </title>	
    </head>
	
    <body>
        <%@include file="navbar.jsp" %>
        <main>
            <div class="container">
                
                <section class="bg-secondary-subtle border rounded-5 m-4 px-2 pt-2 pb-3 col-12 mx-auto text-center">
      <h2 class="my-4">Listado</h2>
      <table class="table table-sm table-striped table-hover border border-success">
                      <thead>
                        <tr>
                          <th scope="col">ID</th>
                          <th scope="col">NOMBRE</th>
                          <th scope="col">APELLIDO</th>
                          <th scope="col">MAIL</th>
                          <th scope="col">TEMA</th>
                        </tr>
                      </thead>
          <% 
            List<Orador> listado = (List<Orador>)request.getAttribute("listado");
          %>
        <tbody>
            <%
                 for( Orador  unOrador : listado) {
            %>

             <tr>
                <th scope="row"> <%=unOrador.getIdOrador()%> </th>
                <td><%=unOrador.getNombre() %></td>
                <td><%=unOrador.getApellido() %></td>
                <td><%=unOrador.getMail() %></td>
                <td><%=unOrador.getTema() %></td>
                <td>
                  <button class="btn btn-danger" onclick="confirmarEliminar(<%=unOrador.getIdOrador()%>)">Eliminar</button> | 
                  <a class="btn btn-secondary" href="<%=request.getContextPath()%>/EditarController?id=<%=unOrador.getIdOrador()%>" role="button">Editar</a>
                </td>
              </tr>
             <%
                  }
             %>

        </tbody>
      </table>
    </section>

                      
            </div>
        </main>
             
     <%@include file="footer.jsp" %>
     <script>
        function confirmarEliminar(idOrador) {
            if (confirm("¿Realmente deseas eliminar este orador?")) {
                window.location.href = "<%=request.getContextPath()%>/EliminarController?id=" + idOrador;
            }
        }
    </script>
    </body>	
</html>