<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>
<%@taglib   uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>
<br>  <br>
<c:if   test="${message ne  null }">
     <c:out  value="${message}"/>
</c:if>
<hr>
<br> <br>
<form:form   action="addCustomer"   method="post"    modelAttribute="registerBean">
  <table>
     <tr>
        <td>PhoneNo </td> 
        <td> <form:input path="phoneNumber"/> </td>
        <td> <form:errors path="phoneNumber"/> </td>
     </tr>
     
     <tr>
        <td>UserName </td> 
        <td> <form:input path="username"/> </td>
        <td> <form:errors path="username"/> </td>
     </tr>
     
     <tr>
        <td>Password(8 to 20) </td> 
        <td> <form:input path="password"/> </td>
        <td> <form:errors path="password"/> </td>
     </tr>
     
     <tr>
        <td>Email </td> 
        <td> <form:input path="email"/> </td>
        <td> <form:errors path="email"/> </td>
     </tr>
     
     <tr>
        <td> PlanId </td>
        <td>
                 <form:select   path="planId">
                          <form:option  value="">----select-----</form:option>
                          <form:options  items="${registerBean.plansList}"     itemValue="planId"   itemLabel="planId"/>
                 </form:select>
        </td>
        <td>
              <form:errors   path="planId"/>
        </td>
        
        <tr>
            <td  colspan=3  align="center">
                <input  type=submit    value="REGISTER">
            </td>
        </tr>
  </table>     
   
</form:form>