<%-- 
    Document   : index
    Created on : 11/12/2023, 10:33:44
    Author     : Pablo
--%>

<!DOCTYPE html>
<html lang="es-ar">
<head>
    <%@include file="head.jsp" %>
    <title>Inicio</title>
    <style>
        body {
            background-color: #f8f9fa;
        }
        main {
            margin-top: 20px; 
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp" %>		
    <main class="container mt-4"> 
    <section>
        <h1 class="text-center">ABM de oradores</h1>
        <p class="lead text-center">Bienvenido a la aplicación de ABM de Oradores.</p>
        
        <!-- Enlaces a las páginas de Alta y Listado -->
        <div class="text-center">
            <a href="<%=request.getContextPath()%>/alta.jsp" class="btn btn-secondary btn-lg me-2" style="width: 150px;">Alta</a>
            <a href="<%=request.getContextPath()%>/api/ListadoController" class="btn btn-secondary btn-lg" style="width: 150px;">Listado</a>
        </div>
        <div class="text-center mt-3">
            <img src="https://th.bing.com/th/id/OIP.umRxF06MC6z3e2Mpt14Q8AAAAA?rs=1&pid=ImgDetMain" alt="imagen orador" style="width: 500px; height: auto;">
        </div>
    </section>
</main>

    <%@include file="footer.jsp" %>
</body>
</html>

