<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
</head>
<body>
 <p> </p>
 <div class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
	 <div class="panel-heading">modifier client</div>
	 
	   <div class="panel-body">

	       <form action="updateClient.php" method="post">
	       
	            <div class="form-group">
	            <label class="label-control">Id</label>
	            <input type="text" class="form-control" name="id" value="${client.id}" readonly="readonly" >
	            <span></span>   
	           </div>
	           
	           <div class="form-group">
	            <label class="label-control">Nom Famille</label>
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
	            <input type="text" class="form-control" name="id_village" value="${client.village.id }">
	            <span></span>   
	           </div>
	           
	           <div>
	             <button class="btn btn-primary">modifier</button>
	           </div>
	           
	       </form>
	      
	   </div>
	</div>
 </div>
</body>
</html>