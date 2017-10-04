<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form:form modelAttribute="project" method="post">

 Name: 
 <form:input path="name" id="name"></form:input>
 <form:errors path="name" cssclass="error" />
 <br />

 Date: 
 <form:input path="date" id="date"></form:input>
 <br />
 
  Scale: 
 <form:input path="scale" id="scale"></form:input>
 <form:errors path="scale" cssclass="error" />
 <br />

 <input type="submit" value="Zapisz " />
</form:form>