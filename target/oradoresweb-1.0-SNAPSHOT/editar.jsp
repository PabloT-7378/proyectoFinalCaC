<%-- 
    Document   : editar
    Created on : 11/12/2023, 10:45:09
    Author     : Pablo
--%>

<%@page import="com.codoacodo.dto.Orador"%>
<html>
    <head>
            <%@include file="head.jsp" %>	
    </head>

    <body>
        <main>
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section>
                    <% 
                        Orador orador = (Orador)request.getAttribute("orador");
                    %>
                    <h1>Editar Orador</h1>
                    <form method="POST"
                            action="<%=request.getContextPath()%>/EditarController">
                            <div class="mb-3">
                              <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                              <input name="nombre"
                                    value="<%=orador.getNombre()%>"  
                                    type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50">
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlTextarea1" class="form-label">Apellido</label>
                                <input name="apellido"
                                    value="<%=orador.getApellido()%>" 
                                    type="text" class="form-control" id="exampleFormControlTextarea1">
                            </div>
                            <div class="my-3">
                                <label for="mail" class="form-label">Mail</label>
                                <input value="<%=orador.getMail()%>" name="mail" type="text" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="70">
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlTextarea1" class="form-label">Tema</label>
                                <input name="tema"
                                    value="<%=orador.getTema()%>" 
                                    type="text" class="form-control" id="exampleFormControlTextarea1" maxlength="100">
                            </div>
                            <button class="btn btn-secondary btn-lg">
                                Guardar
                            </button>
                    </form>
                </section>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>	
</html>