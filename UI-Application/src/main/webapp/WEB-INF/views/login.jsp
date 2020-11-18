<%@taglib   uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>
<br>  <br>
<c:if   test="${message ne  null }">
     <c:out  value="${message}"/>
</c:if>
<hr>
<br>
<form   action="loginCustomer"   method="post">
  <table>
    <tr>
         <td> PhoneNo </td>
         <td> <input type="text"    name="phoneNo">
    </tr>
    <tr>
         <td> Password </td>
         <td> <input  type="password"   name="password">
    </tr>
    <tr>
       <td  colspan=2   align="center">
             <input  type="submit"   value="click">
       </td>
  </table>

</form>


