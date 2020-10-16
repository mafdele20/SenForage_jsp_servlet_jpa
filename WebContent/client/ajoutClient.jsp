<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>client</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
</head>
<body>
<%@include file="navbar.jsp" %>
 <div class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
	 <div class="panel-heading">ajout d'un client</div>
	   <div class="panel-body">
	       <form action="ajoutC.php" method="post">
	           
	           <div class="form-group">
	            <label class="label-control">NOM DE FAMILLE</label>
	            <input type="text" class="form-control" name="nomF" value="${client.nomF}" required="required">
	            <span></span>   
	           </div>
	           
	           <div class="form-group">
	            <label class="label-control">Telephone</label>
	            <input type="text" class="form-control" name="telephone" value="${client.telephone }">
	            <span></span>   
	           </div>
	           
	           <div class="form-group">
	            <label class="label-control">Village</label>
	            <input type="text" class="form-control" name="id_village" value="${client.village.nomV }">
	            <span></span>   
	           </div>
	           
	           <div>
	             <button class="btn btn-primary">Enregistrer</button>
	           </div>
	           
	       </form>
	      
	   </div>
	</div>
 </div>
</body>
</html>