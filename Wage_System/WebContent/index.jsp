<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="index.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Job</title>
</head>
<body>
	<div class="testbox">
  <h1>Enter JOB</h1>

  <form action="getLabour">
  
  <input type="text" name="jobDisc" placeholder="Job Discription" required="required"/>
  <input type="number" name="renum" placeholder="Renumeration" required min="0" />
  <input type="text" name="location" placeholder="Location" required/>
	<label>Start Date</label>
	<input type="date" name="startdate"required/><br/>
	<label>End Date</label>
	<input type="date" name="enddate" placeholder="End Date" required/><br/>
 	<label>Select Skill</label>
	<select class="select" multiple="multiple" required="required" name="skills">
		<option>Java</option>
		<option>Php</option>
		<option>Android</option>
		<option>Dot Net</option>
		<option>C#</option>
		<option>IOS</option>
		<option>Jsp</option>
		<option>C</option>
		</select>
   
   <input type="submit" class="button" value="Submit"/>
  </form>
</div>
</body>
</html>