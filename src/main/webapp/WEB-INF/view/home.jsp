<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>To Do List App</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
		
		<script src="https://unpkg.com/ionicons@4.2.4/dist/ionicons.js"></script>
		
	</head>

	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="#"><img class="logo" src="<c:url value="resources/img/logo.png"/>">
		  <span id="username">${username}'s</span> <i>To Do</i> lists</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		      	<div class="container">
			      <form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/showFormAddList" method="POST">
			      	<button type="submit" class="btn btn-outline-success new-todo-list">Add new To Do List</button>
			      </form:form>
			      </div>
		      </li>
		    </ul>
		    
		    <form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/logout" method="POST">
				<input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Logout"/>
			</form:form>
		  </div>
		</nav>
		
			    
	    <div class="container-fluid">
	    	<div class="box">
	    		<c:forEach var="tempTodoList" items="${todoLists}">
					<c:set var="tempTodoList" value="tempTodoList" scope="request"/>
					<form:form class="todo-list rounded-top" action="manageTodoList" modelAttribute="todoList" method="post">
						<form:hidden path="id"  value="${tempTodoList.id}"/>
						<form:hidden path="name" value="${tempTodoList.name}" />
						<form:hidden path="todoListUser" value="${tempTodoList.todoListUser.username}" />
					
						<c:set var = "username" value = "${tempTodoList.todoListUser.username}"/>
						
						<c:url var="deleteList" value="/deleteList">
							<c:param name="tempTodoListId" value="${tempTodoList.id}"/>
						</c:url>
						<c:url var="updateList" value="/updateList">
							<c:param name="tempTodoListId" value="${tempTodoList.id}"/>
						</c:url>
						
						<div class="todo-list-name rounded">
							<h5>${tempTodoList.name}</h5> 
							
							<div class="icons1">
								<a href="${updateList}"><ion-icon
									src="<c:url value="resources/img/_ionicons_svg_md-create.svg"/>"></ion-icon></a>
								<a href="${deleteList}" 
									onclick="if (!(confirm('Are you sure you want to delete this list?'))) return false"><ion-icon 
									src="<c:url value="resources/img/_ionicons_svg_md-close-circle.svg"/>"></ion-icon></a>
							</div>
						</div>
								
						<ul class="tasks">
							<c:forEach var="task" items="${tempTodoList.tasks}" varStatus="loop" >
								<c:set var="i" value="${loop.index}" scope="request"/>
								<form:hidden path="tasks[${i}].id" value="${task.id}"/>
								<form:hidden path="tasks[${i}].done" value="${task.done}"/>
								<form:input  path="tasks[${i}].task" value="${task.task}" readonly="true" type="hidden"/>
								
								<c:url var="deleteTask" value="/deleteTask">
									<c:param name="taskId" value="${task.id}"/>
								</c:url>
								<c:url var="updateTaskForm" value="/updateTaskForm">
									<c:param name="taskId" value="${task.id}"/>
									<c:param name="todoListE" value="${task.todoList}"/>												
									<c:param name="todoListId" value="${task.todoList.id}"/>												
								</c:url>
								<c:url var="toggleDone" value="/toggleDone">
									<c:param name="taskDone" value="${task.done}"/>											
								</c:url>
								
								<li class="<c:if test="${task.done == 1}">done</c:if>">
									<div class="show">
										<button class="btn toggleBtn" name="toggleDone" value="${i}">
											<i class="fa fa<c:if test="${task.done == 1}">-check</c:if>-square-o"></i>
										</button>
										${task.task}
										<div class="icons">
											<a href="${updateTaskForm}"><ion-icon
												src="<c:url value="resources/img/_ionicons_svg_md-create.svg"/>"></ion-icon></a>
										
											<a href="${deleteTask}" 
											onclick="if (!(confirm('Are you sure you want to delete this task?'))) return false">
											<ion-icon class="del" 
												src="<c:url value="resources/img/_ionicons_svg_md-close-circle.svg"/>"></ion-icon></a>
										</div>
									</div>		
								</li>	
							</c:forEach>
						</ul>
						<div class="input-group">
							<input class="form-control" name="task" placeholder="new task"/>
							<div class="input-group-append">
								<input class="btn btn-secondary add-btn" name="addTask" type="submit" value="Add">				
							</div>
					    </div>
					</form:form>
				</c:forEach>
	    	</div>
	    </div>
	</body>
</html>