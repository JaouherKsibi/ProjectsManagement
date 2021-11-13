<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<!-- Importation bootstrap   -->
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand active" href="../home" >Home <span class="sr-only">(current)</span></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="addProject">Add Project</a></li>
        <li><a href="addEmployee">Add Employee</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="//{orderId}">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
<h1>projects by departement</h1>
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Title</th>
		      <th scope="col">Etat</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach var="p" items="${listeProjects}">
			  	<tr>
			      <th scope="row">${p.id}</th>
			      <td>${p.titre}</td>
			      <td>${p.etat }</td>
			      <td><a href="../employeeByProject/${p.id}">Employees list</a></td>
			    </tr>
			  </c:forEach>
		  </tbody>
		</table>
</div>
<!-- les scripts de jquery  -->
<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>