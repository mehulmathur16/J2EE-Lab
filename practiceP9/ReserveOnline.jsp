<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Flight Reservation System</h1>

<form action = "ReserveTicket" method = "get">
	Enter Name : <input type = "text" name = "name">
	Enter Phone Number : <input type = "text" name = "phoneNo">
	Date : <input type = "date" name = "date">
	Flight Number : <input type = "text" name = "flightNo">
	
	<button type = "submit">Reserve Ticket</button>
</form>

<br>

<form action = "ViewFlights" method = "get">
	Enter Week Day : <input type = "text" name = "weekDay">
	<button type = "submit">View Flights</button>
</form>

</body>
</html>