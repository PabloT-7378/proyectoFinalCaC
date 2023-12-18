<%-- 
    Document   : alta
    Created on : 11/12/2023, 10:43:51
    Author     : Pablo
--%>

<html>
    <head>
            <%@include file="head.jsp" %>
    </head>

    <body>
        <main>
            <%@include file="navbar.jsp" %>
            <div class="container mt-4">
                <section class="border border-secondary rounded-4 col-6 mx-auto text-center" style="background-color: black">
                    <h1 class="text-center my-4 text-light">Alta</h1>
                    <!--  JSP -->
                    <form method="post" action="<%=request.getContextPath()%>/CreateController">
                        <div class="my-3 mx-3">
                            <input name="nombre"  type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="apellido" type="text" class="form-control" id="apellidoTextarea" placeholder="Apellido">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="mail" type="text" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                            <input name="tema" type="text" class="form-control" id="temaTextarea" placeholder="Tema">
                        </div>
                        <button class="btn btn-secondary my-3">
                            Dar de alta
                        </button>
                    </form>
                </section>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>	
</html>