<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap JSP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>
  <body>
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>

  <h1>Hello JSP page!</h1>
  <h3><%= request.getRequestURI() %></h3>
  <div>Hello <%= request.getAttribute("str") %></div>
  <div>Name: <%= request.getParameter("name") %></div>

</body>
</html>
