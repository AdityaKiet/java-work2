<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>e-CAN</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
<!-- 
Sonic Template 
http://www.templatemo.com/preview/templatemo_394_sonic 
-->
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">
    
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/templatemo_misc.css">
	<link rel="stylesheet" href="css/templatemo_style.css">
	

<script type="text/javascript">

function redirect(cnt) {
  window.location = 'index?rqst='+ cnt;
  return false;
}

</script>
</head>
<body>
	
	

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="index.jsp"><h1>e-CAN</h1></a>
			<span>Online Catering System</span>
		</div> <!-- /.logo -->

		<div class="navigation">
	        <ul class="main-menu">
	            <li class="about"><a onclick="return redirect('All Orders')" href="#">All Orders</a></li>
	            <li class="services"><a onclick="return redirect('Available Items')" href="#">Close Canteen</a></li>
	            <li class="portfolio"><a onclick="return redirect('Change Availability')" href="#">Change Availability</a></li>
	            <li class="home"><a onclick="return redirect('Add New Item')" href="#">Add An Item</a></li>
	            <li class="contact"><a onclick="return redirect('Update an Item')" href="#">Update An Item</a></li>
	            <li class="about"><a onclick="return redirect('Delete an Item')" href="#">Delete An Item</a></li>
	            <li class="services"><a onclick="return redirect('Recharge')" href="#">Recharge</a></li>
	            <li class="portfolio"><a onclick="return redirect('Add new Customer')" href="#">Add new Customer</a></li>
	            <li class="contact"><a onclick="return redirect('Delete customer')" href="#">Delete customer</a></li>
	            <li class="about"><a onclick="return redirect('Report')" href="#">Generate Report</a></li>
	            <li class="home"><a onclick="return redirect('Feedback')" href="#">Feedback</a></li>
	            <!-- <li class="home"><p>copyright@2014 e-CAN Company</p></li> -->
	        </ul>
		</div> <!-- /.navigation -->

	</div> <!-- /#main-sidebar -->

	<div id="main-content">

		<div id="templatemo">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h2>Welcome to e-CAN</h2>
							<p style="
    padding-bottom: 60px;
">Our Online Canteen provides an online platform for parents to order direct to their school canteens from the comfort of their home, 24/7. The service allows Canteen Managers a virtual volunteer who automatically tallies orders, counts money, and keeps track of stock at the click of a button, saving time and money. Our system is the product of extensive research and feedback from both faculty and students .</p>
						</div>
					</div>
				</div>
			</div>
		</div> <!-- /#sTop -->

		<div class="container-fluid">

			
			<div id="services" class="section-content">
				<div class="row">
					
				</div> <!-- /.row -->
				<div class="row">
					<div class="col-md-4">
						<div class="service-item clearfix">
							<div class="service-icon">
								<i class="fa fa-bolt fa-2x"></i>
							</div>
							<div class="service-content">
								<h3>The Best<br>Support </h3>
							</div>
						</div> <!-- /.service-item -->
					</div> <!-- /.col-md-4 -->
					<div class="col-md-4">
						<div class="service-item">
							<div class="service-icon">
								<i class="fa fa-laptop fa-2x"></i>
							</div>
							<div class="service-content">
								<h3>Fully<br>Responsive Product</h3>
							</div>
						</div> <!-- /.service-item -->
					</div> <!-- /.col-md-4 -->
					<div class="col-md-4">
						<div class="service-item">
							<div class="service-icon">
								<i class="fa fa-pencil fa-2x"></i>
							</div>
							<div class="service-content">
								<h3>Fully<br>Reliable</h3>
							</div>
						</div> <!-- /.service-item -->
					</div> <!-- /.col-md-4 -->
				</div> <!-- /.row -->
				<div class="row our-skills">
					<div class="">
						<h3>Advantages</h3>
						The Canteen Management System is the replacement of printing Canteen Coupons (paperless) and manually maintaining a record of its usage is a tedious and time consuming task. It can help to keeps track of daily activities carried out in a canteen and finally can calculate the monthly consumption of subsided from company for each employee or do the payment for stall holders
Many organizations provide Canteen as an additional subsidized facility to their Employees as a welfare measure. The usage of the canteen by the employees depends on many factors like centralized food distribution center with swift and Simplicity in operations.
					</div>
				</div>
			</div> <!-- /#services -->

			
			
		</div> 
	</div> 

	<!-- JavaScripts -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery.singlePageNav.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/custom.js"></script>
	<script>
		$(document).ready(function(){
			$("a[data-gal^='prettyPhoto']").prettyPhoto({hook: 'data-gal'});
		});

        function initialize() {
          var mapOptions = {
            zoom: 13,
            center: new google.maps.LatLng(40.7809919,-73.9665273)
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