<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
    <title>Women Safety Portal</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">
    
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/templatemo_misc.css">
	<link rel="stylesheet" href="css/templatemo_style.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.6/integration/bootstrap/3/dataTables.bootstrap.css">
</head>
<body>
	

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="#"><h1>Women Safety</h1></a>
			<span>the women safety portal</span>
		</div> <!-- /.logo -->

		<div >
	        <ul class="main-menu">
	            <li class="home"><a href="#home">Requests</a></li>
	            <li class="portfolio"><a href="#users">Users</a></li>
	            <li class="portfolio"><a href="Logout">Logout</a></li>
	        </ul>
		</div> <!-- /.navigation -->

	</div> <!-- /#main-sidebar -->

	<div id="main-content">

		<div id="home" class="section-content">
					<div class="container-fluid">
					<div class="row">
					<div class="col-md-12">
						<div class="section-title">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h2>Recent Request Occured</h2>
						</div>
					</div>
				</div>
			</div>
		
			<div class="main-slider">
			<div class="row">
					<div class="col-md-12">
				<table id="requests"
					class="table  table-striped table-bordered" cellspacing="0" width="100%">
					<thead>
						<tr>
							<td>Mobile No</td>
							<td>IMEI</td>
							<td>Latitude</td>
							<td>Longitude</td>
							<td>Address</td>
							<td>Done ?</td>
						</tr>
					</thead>

				</table>
			</div>
			</div>
			</div>
			
		</div> <!-- /#sTop -->

		<div class="container-fluid">

			<div id="users" class="section-content">
				<div class="container-fluid">
					<div class="row">
					<div class="col-md-12">
						<div class="section-title">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h2>Registered Users</h2>
						</div>
					</div>
				</div>
			</div>
		
			<div class="main-slider">
			<div class="row">
					<div class="col-md-12">
				<table id="user"
					class="table  table-striped table-bordered" cellspacing="0" width="100%">
					<thead>
						<tr>
							<td>Name</td>
							<td>Mobile No</td>
							<td>Parent No</td>
							<td>Voter Id</td>
							<td>IMEI</td>
							<td>Postal Code</td>
							<td>Email Id</td>
							<td>Address</td>
						</tr>
					</thead>

				</table>
			</div>
			</div>
			</div>
			
			</div> <!-- /#about -->
			
			

		</div> <!-- /.container-fluid -->

		<div class="site-footer">
			<div class="bottom-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<p class="copyright">Copyright © 2014 <a href="#">Women Safety Portal</a>
                            </p>
						</div> <!-- /.col-md-6 -->
						<div class="col-md-6 credits">
							<p>by <a rel="nofollow" href="https://www.facebook.com/teamandappers">TeamAndAppers</a></p>
						</div> <!-- /.col-md-6 -->
					</div> <!-- /.row -->
				</div> <!-- /.container-fluid -->
			</div> <!-- /.bottom-footer -->
		</div> <!-- /.site-footer -->

	</div> <!-- /#main-content -->

	<!-- JavaScripts -->
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="js/jquery.singlePageNav.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/custom.js"></script>
	<script src="//cdn.datatables.net/1.10.6/js/jquery.dataTables.min.js"></script>
	<script src="//cdn.datatables.net/plug-ins/1.10.6/integration/bootstrap/3/dataTables.bootstrap.js"></script>
	<script src="js/index.js"></script>
	<script>
		$(document).ready(function(){
			$("a[data-gal^='prettyPhoto']").prettyPhoto({hook: 'data-gal'});
		});

        function initialize() {
          var mapOptions = {
            zoom: 11,
            center: new google.maps.LatLng(16.8451789,96.1439764)
          };

          var map = new google.maps.Map(document.getElementById('map-canvas'),
              mapOptions);
        }

        function loadScript() {
          var script = document.createElement('script');
          script.type = 'text/javascript';
          script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' +
              'callback=initialize';
          document.body.appendChild(script);
        }

        window.onload = loadScript;
    </script>

</body>
</html>