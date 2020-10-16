<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
</head>
<body>
<%@include file="navbar.jsp" %>
 <div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-primary">
	 <div class="panel-heading">Recherche de Client</div>
	   <div class="panel-body">
	       <form action="client.php" method="get">
	       <label>mot clés</label>
	       <input type="text" name="mc" value="">
	       <button class="btn btn-primary">chercher</button>
	       </form>
	       <p> </p>
	       <table class="table table-striped">
	         <tr> 
	           <th>ID</th>
	           <th>NOM DE FAMILLE</th>
	           <th>VILLAGE</th>
	           <th>TELEPHONE</th>
	           <th>ACTION</th>
	           <th>ACTION</th>
	         </tr>
	         <c:forEach items="${model.cl }" var="c"> 
		         <tr> 
		          <td>${c.id}</td>
		          <td>${c.nomF}</td>
		          <td>${c.village.nomV}</td>
		          <td>${c.telephone} </td>
		          <td> <a onclick="return confirm('voulez vous supprimer')" href="SupprimerClient.php?id=${c.id}">delete</a> </td>
		          <td> <a href="EditClient.php?id=${c.id}">edit</a> </td>
		         </tr>
	         </c:forEach> 
	       </table>
	   </div>
	</div>
 </div>
</body>
</html>