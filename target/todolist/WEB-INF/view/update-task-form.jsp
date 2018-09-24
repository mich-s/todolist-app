<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Update task form</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style type="text/css">
			.container {
				margin-top:50px;
			}
			.logo {
				width:40px;
				height: auto;
				margin-right: 15px;
			}
			#btn-add {
				text-align:center;
				margin-top:10px;
			}
			.btn {
				width:150px;
			}
			#back {
				float:right;
			}
			
		</style>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="#"><img class="logo" src="<c:url value="resources/img/logo.png"/>" >update your task</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto"></ul>
		    
		    <form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/logout" method="POST">
				<input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Logout"/>
			</form:form>
		  </div>
		</nav>
		
		<div class="container">
			<form:form action="updateTask"  modelAttribute="task" method="post">
				<form:hidden path="id"/>
				
				<div >
					<div>Name:</div>
					<form:input path="task" type="text" class="form-control form-control-lg"/>
				</div>
				<div id="btn-add">
					<input class="btn btn-secondary" type="submit" value="Save">
				</div>
				
			</form:form>
			<div id="back">
				<a href="${pageContext.request.contextPath}" class="btn btn-default" role="button">Back to To Do List</a>
			</div>
		</div>
	</body>
</html>
