<%@taglib   uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<br>  <br>
<c:if   test="${message ne  null }">
     <c:out  value="${message}"/>
</c:if>
<hr>
<br>  <br>
 
 To Register as a new customer?  &nbsp; &nbsp;
 <a  href="registerPage">SignUp</a>   
 <br> <br>
 If you are already existing customer? &nbsp; &nbsp;
 <a  href="loginPage">SignIn</a>
 