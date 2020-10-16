<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
</head>
<body>
<%@include file="navbar.jsp" %>
 <div class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
	 <div class="panel-heading">confirmation d'ajout d'un client</div>
	   <div class="panel-body">
	      
	           <div class="form-group">
	            <label class="label-control">ID :</label>
	            <label>${client.id}</label>
	           </div>
	           
	            <div class="form-group">
	            <label class="label-control">NOM DE FAMILLE :</label>
	            <label>${client.nomF}</label>
	           </div>
	           
	             <div class="form-group">
	            <label class="label-control">TELEPHONE</label>
	            <label>${client.telephone}</label>
	           </div>
	           
	           <div class="form-group">
	            <label class="label-control">VILLAGE</label>
	            <label>${client.village.nomV}</label>
	           </div>
	      
	   </div>
	</div>
 </div>
</body>
</html>