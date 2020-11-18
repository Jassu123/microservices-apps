<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<h2 style="background: yellow;"> Customer Details</h2> 
<hr>
Phone Number : <c:out value="${customer.phoneNumber}"/> <br>
Username : <c:out  value="${customer.username}"/> <br>
Email : <c:out  value="${customer.email}"/> <br>
<br>
<h2 style="background: cyan;">Current Plan Details </h2> 
<hr>
Planid : <c:out value="${customer.currentPlan.planId}"/> <br>
Plan name: <c:out value="${customer.currentPlan.planName}"/> <br>
validity : <c:out value="${customer.currentPlan.validity}"/> <br>
description : <c:out value="${customer.currentPlan.description}"/> <br>
<br>
<h2  style="background: grey;">Friends Contact Numbers</h2> 
<hr>
 <c:forEach  items="${customer.friendsContactNumbers}"  var="friendNo">
    <c:out  value="${friendNo}"/> <br>
 </c:forEach>    
