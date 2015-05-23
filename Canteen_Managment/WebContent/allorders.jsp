<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Current Orders...</title>
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
	<link rel="stylesheet" href="css/feedback.css">
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
							<h2>All current orders are...</h2>
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
		<form action="order" method="post">
			<table class="table2">
                <thead>
                    <tr>
                        <th scope="col" abbr="Token Number">Token Number</th>
                        <th scope="col" abbr="Name of Student">Name of Student</th>
                        <th scope="col" abbr="Order">Order</th>
                        <th scope="col" abbr="Amount">Amount</th>
                        <th scope="col" abbr="Time">Order Time</th>
                        <th scope="col" abbr="Time">Expected Delay</th>
                        <th scope="col" abbr="Confirm ?">Done?</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="x">
                    <tr>
					<td>${x.token}</td>
					<td>${x.name}</td>
					<td>${x.items}</td>
					<td>${x.amount}</td>
					<td>${x.time}</td>
					<td>
						<c:choose>
							<c:when test="${x.isConfirmed}">
								<input type="number" value="${x.expected_time}" readonly="readonly" name="${x.token}"/>
							</c:when>
							<c:otherwise>
								<input type="number" value="0" placeholder="Enter Delay Time" name="${x.token}"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
					<c:choose>
					<c:when test="${x.isConfirmed}">
					<input type="checkbox" name="delete" value="${x.token}" checked="checked" disabled="disabled"/>
					</c:when>
					<c:otherwise>
					<input type="checkbox" name="delete" value="${x.token}"/>
					</c:otherwise>
					</c:choose>
					</td>
					
				</tr>

			</c:forEach>
                   
                  
                </tbody>
            </table>
            <div style="padding-top: 20px;">
            <input type="submit" value="Refresh" name="order" style="color: red;font-size: larger;"/>
            <input type="submit" value="Handle Orders" name="order" style="color: black;font-size: larger;">
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