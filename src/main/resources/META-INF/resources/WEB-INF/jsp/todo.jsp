 <%@ include file="common/navigation.jspf" %>
   <%@ include file="common/header.jspf" %>
  
 <div class="container">

   <h1>Enter todos detail </h1>
   <fieldset class="mb-3">
   <form:form method="post" modelAttribute="todo">
    <form:label path="description">Description</form:label>
    <form:input type="text" path="description" required="required"/>
    <form:errors path="description" cssClass="text-warning"/>
    </fieldset>
    
    <feildset class="mb-3">
    	<form:label path="description">Target Date</form:label>
    	<form:input type="text" path="targetDate" required="required"/>
    	<form:errors path="description" cssClass="text-warning"/>
    </feildset>
   	<form:input type="hidden" path="id"/>
   	<form:input type ="hidden" path ="done"/>
   	<input type="submit" class ="btn btn-custom-color"/>
   	
   
   </form:form>
   </div>

 
  <%@ include file="common/footer.jspf" %>
 <script type="text/javascript">
 $('#targetDate').datepicker({
    format: 'yyyy-mm-dd',});</script>
</body>
</html>
