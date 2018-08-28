<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rooms</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1 style = "text-align: center;">Welcome to TaskList !</h1>
	<p style= "text-align: center;"><a href= "/registration">user registration!</a></p>
		<h1>To Do List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>user</th><th>description</th><th>dueDate</th><th>complete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
				<tr>
					<td>${task.user}</td>
					<td>${task.description}</td>
					<td>${task.dueDate}</td>
					<td>${task.complete}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<button><a href="/delete">Delete</a></button>
		<button><a href="/add">Add</a></button>
	</div>
</body>
</html>