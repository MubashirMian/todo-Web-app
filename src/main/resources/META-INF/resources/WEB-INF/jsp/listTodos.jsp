<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/navigation.jspf" %>
<html>
<head>
  <title>List Todos Page</title>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <style>
   .btn-custom-color-warning {
     background-color: #FF0266;
   }
   .btn-custom-color-success {
     background-color: #0336FF;
   }
   body {
     background-color: #FFDE03;
   }
 </style>
</head>
<body>

  <div class="container">
  
  	
    <hr>
    <h1>Your todos</h1>
    <hr>
    <table class="table">  
    
      <thead>
        <tr>
          
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done?</th>
          <th>Action</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
         <tr>
           
           <td>${todo.description}</td>
           <td>${todo.targetDate}</td>
           <td>${todo.done}</td>
           <td><a href="delete-todo?id=${todo.id}" class="btn btn-custom-color-warning">Delete</a></td>
           <td><a href="update-todo?id=${todo.id}" class="btn btn-custom-color-success">Update</a></td>
          </tr>
       </c:forEach>
     </tbody>
     
   </table>
   <a href="add-todo" class="btn btn-custom-color-warning" style="font-weight: bold;">Add Todo</a>
 </div>

<%@ include file="common/footer.jspf" %>





