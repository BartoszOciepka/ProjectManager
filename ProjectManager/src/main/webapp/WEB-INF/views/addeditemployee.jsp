<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form:form modelAttribute="employee" method="post">

 Name: 
 <form:input path="firstName" id="firstName"></form:input>
 <form:errors path="firstName" cssclass="error" />
 <br />

 Surname: 
 <form:input path="lastName" id="lastName"></form:input>
 <form:errors path="lastName" cssclass="error" />
 <br />

 <input type="submit" value="Zapisz " />
</form:form>