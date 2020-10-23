<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>ajout client</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="public/vendors/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="public/vendors/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="public/vendors/images/favicon-16x16.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="public/vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="public/vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="public/src/plugins/datatables/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="public/src/plugins/datatables/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="public/vendors/styles/style.css">

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
</head>
<body>


	<div class="header">
		<div class="header-left">
			<div class="menu-icon dw dw-menu"></div>
			<div class="search-toggle-icon dw dw-search2" data-toggle="header_search"></div>
			<div class="header-search">

			</div>
		</div>
		<div class="header-right">
			<div class="dashboard-setting user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow" href="javascript:;" data-toggle="right-sidebar">
						<i class="dw dw-settings2"></i>
					</a>
				</div>
			</div>
			<div class="user-notification">
				<div class="dropdown">
					<a class="dropdown-toggle no-arrow" href="#" role="button" data-toggle="dropdown">
						<i class="icon-copy dw dw-notification"></i>
						<span class="badge notification-active"></span>
					</a>
					<div class="dropdown-menu dropdown-menu-right">
					
					</div>
				</div>
			</div>
			<div class="user-info-dropdown">
				<div class="dropdown">
					<a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="vendors/images/photo1.jpg" alt="">
						</span>
						<span class="user-name">Mafatime Gadiaga</span>
					</a>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
						<a class="dropdown-item" href="profile.html"><i class="dw dw-user1"></i> Profile</a>
						<a class="dropdown-item" href="profile.html"><i class="dw dw-settings2"></i> Setting</a>
						<a class="dropdown-item" href="faq.html"><i class="dw dw-help"></i> Help</a>
						<a class="dropdown-item" href="login.jsp"><i class="dw dw-logout"></i> Log Out</a>
					</div>
				</div>
			</div>
			<div class="github-link">
				<a href="https://github.com/dropways/deskapp" target="_blank"><img src="vendors/images/github.svg" alt=""></a>
			</div>
		</div>
	</div>

	<div class="right-sidebar">
		<div class="sidebar-title">
			<h3 class="weight-600 font-16 text-blue">
				Layout Settings
				<span class="btn-block font-weight-400 font-12">User Interface Settings</span>
			</h3>
			<div class="close-sidebar" data-toggle="right-sidebar-close">
				<i class="icon-copy ion-close-round"></i>
			</div>
		</div>
		
				<div class="reset-options pt-30 text-center">
					<button class="btn btn-danger" id="reset-settings">Reset Settings</button>
				</div>
			</div>


	<div class="left-side-bar">
		<div class="brand-logo">
			<a href="index.html">
				<img src="vendors/images/deskapp-logo.svg" alt="" class="dark-logo">
				<img src="vendors/images/deskapp-logo-white.svg" alt="" class="light-logo">
			</a>
			<div class="close-sidebar" data-toggle="left-sidebar-close">
				<i class="ion-close-round"></i>
			</div>
		</div>
		<div class="menu-block customscroll">
			<div class="sidebar-menu">
				<ul id="accordion-menu">
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle">
							<span class=""></span><span class="mtext">Clients</span>
						</a>
						<ul class="submenu">
							<li><a href="client.php">Liste des clients</a></li>
							<li><a href="ajoutClient.php">Inscrire un client</a></li>
						</ul>
					</li>
					
					<li class="dropdown">
						<a href="javascript:;" class="dropdown-toggle">
							<span class=""></span><span class="mtext">Village</span>
						</a>
						<ul class="submenu">
								<li><a href="index.html">Liste des village</a></li>
							<li><a href="index2.html">Ajouter un village</a></li>
						</ul>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
	<div class="mobile-menu-overlay"></div>

<div class="main-container">
	
	       <!-- Default Basic Forms Start -->
<div class="pd-20 card-box mb-30">
    <div class="clearfix">
        <div class="pull-left">
            <h4 class="text-blue h4">Espace Responsable</h4>
            <p class="mb-30">Inscription Client</p>
        </div>
      
    </div>
 		<form action="ajoutC.php" method="post">
        <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">NOM DE FAMILLE</label>
            <div class="col-sm-12 col-md-10">
               
	            <input type="text" class="form-control" name="nomF" value="${client.nomF}" required="required">
            </div>
        </div>
        <div class="form-group row">
              <label class="col-sm-12 col-md-2 col-form-label">Telephone</label>
            <div class="col-sm-12 col-md-10">

	            <input type="text" class="form-control" name="telephone" value="${client.telephone }">
            </div>
        </div>
            <div class="form-group row">
					<label class="col-sm-12 col-md-2 col-form-label">Village</label>
					<div class="col-sm-12 col-md-10">
				 <select class="custom-select col-12" name="id_village">
					<option selected="">Faite votre choix</option>
				       <c:forEach items="${villages}" var="v"> 
							<option value="${v.id}">${v.nomV}</option>			         
			           </c:forEach>
				</select>
					</div>
			</div>
	           
  			   <div>
	             <button class="btn btn-primary">Enregistrer</button>
	           </div>
</form>
            </code></pre>
        </div>
         <p> </p>
	<div class="footer-wrap pd-20 mb-20 card-box" >
     	Senforage  by <a href="https://github.com/mafdele20" target="_blank">Mafatime Gadiaga</a>
	</div>
    </div>

<!-- Default Basic Forms End -->

	


 


	<!-- js -->
	<script src="public/vendors/scripts/core.js"></script>
	<script src="public/vendors/scripts/script.min.js"></script>
	<script src="public/vendors/scripts/process.js"></script>
	<script src="public/vendors/scripts/layout-settings.js"></script>
	<script src="public/src/plugins/apexcharts/apexcharts.min.js"></script>
	<script src="public/src/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="public/src/plugins/datatables/js/dataTables.bootstrap4.min.js"></script>
	<script src="public/src/plugins/datatables/js/dataTables.responsive.min.js"></script>
	<script src="public/src/plugins/datatables/js/responsive.bootstrap4.min.js"></script>
	<script src="public/vendors/scripts/dashboard.js"></script>
</body>
</html>