<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Generate report...</title>
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
	<link rel="stylesheet" href="css/report.css">
	<link rel="stylesheet" href="css/updateItem.css">
		<script src="js/classie.js"></script>
	<script src="js/modernizr.custom.js"></script>
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
	        </ul>
		</div> <!-- /.navigation -->

	</div> <!-- /#main-sidebar -->

	<div id="main-content">

		<div id="templatemo">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h2>Choose option to generate report...</h2>
						</div>
					</div>
				</div>
			</div>
		</div> <!-- /#sTop -->

		<div class="container-fluid">
		<div >
		<div class="message">
		<h3>${message}</h3>
		</div>
		  <form action="report" method="post">
		   <div class="left_report" style="margin-right: 60px;">
   
  <div class="report">
<input type="checkbox" checked value="amount" name="check" id="check_amount" class="radio" />
<label  class="report" for="check_amount">Amount</label>
</div>

<div  class="report">
<input type="checkbox" checked value="customer" name="check" id="check_customer" class="radio"/>
<label  class="report" for="check_customer">Customer</label>
</div>

<div class="report">	
<input type="checkbox" checked value="date" name="check" id="check_date" class="radio"/>
<label class="report" for="check_date">Date</label>
</div>

<div class="report">	
<input type="checkbox" checked value="item" name="check" id="check_item" class="radio"/>
<label class="report" for="check_item">Item</label>
</div>
<div class="report" style="padding-top:40px;">
		<input style="width: 200px;" class="button" type="submit" value="Submit"/>
  
</div>
</div>
		<div class="left_report" >
   
  <div class="report">
<input type="radio" value="1day" name="radio" id="radio1" class="radio" checked/>
<label  class="report" for="radio1">today</label>
</div>

<div  class="report">
<input type="radio" value="2day" name="radio" id="radio2" class="radio"/>
<label  class="report" for="radio2">last day</label>
</div>

<div class="report">	
<input type="radio" value="3day" name="radio" id="radio3" class="radio"/>
<label class="report" for="radio3">last 2 days</label>
</div>

<div class="report">	
<input type="radio" value="4day" name="radio" id="radio4" class="radio"/>
<label class="report" for="radio4">last 3 days</label>
</div>
<div class="report">	
<input type="radio" value="5day" name="radio" id="radio5" class="radio"/>
<label class="report" for="radio5">last 4 days</label>
</div>

  </div>
            <div class="left_report">
   
  <div class="report">
<input type="radio" value="1week" name="radio" id="radio6" class="radio" />
<label  class="report" for="radio6">this week</label>
</div>

<div  class="report">
<input type="radio" value="2week" name="radio" id="radio7" class="radio"/>
<label  class="report" for="radio7">last week</label>
</div>

<div class="report">	
<input type="radio" value="3week" name="radio" id="radio8" class="radio"/>
<label class="report" for="radio8">last 2 weeks</label>
</div>

<div class="report">	
<input type="radio" value="4week" name="radio" id="radio9" class="radio"/>
<label class="report" for="radio9">last 3 weeks</label>
</div>
<div class="report">	
<input type="radio" value="5week" name="radio" id="radio10" class="radio"/>
<label class="report" for="radio10">last 4 weeks</label>
</div>

  </div>
           
            <div class="left_report">
   
  <div class="report">
<input type="radio" value="1month" name="radio" id="radio11" class="radio" />
<label  class="report" for="radio11">this month</label>
</div>

<div  class="report">
<input type="radio" value="2month" name="radio" id="radio12" class="radio"/>
<label  class="report" for="radio12">last month</label>
</div>

<div class="report">	
<input type="radio" value="3month" name="radio" id="radio13" class="radio"/>
<label class="report" for="radio13">last 2 months</label>
</div>

<div class="report">	
<input type="radio" value="4month" name="radio" id="radio14" class="radio"/>
<label class="report" for="radio14">last 3 months</label>
</div>
<div class="report">	
<input type="radio" value="5month" name="radio" id="radio15" class="radio"/>
<label class="report" for="radio15">last 4 months</label>
</div>

  </div>
  

  </form>
  </div>
		</div> <!-- /.container-fluid -->


</div> <!-- /#main-content -->

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
<!-- templatemo 394 sonic -->
</body>
</html>