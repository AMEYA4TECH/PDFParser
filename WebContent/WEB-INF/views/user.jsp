<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home Page</title>
</head>
<body>

<%-- <h3>Hi ${userName}</h3>
<c:forEach var="country" items="${capitalList}">
	Country: ${country.key}  - Capital: ${country.value}
</c:forEach>
 --%>
 <h1><center>Invoice Data</center></h1>  
<%-- <table>
	<tr>
		<th>Key</th>
		<th>Value</th>
	</tr>
	<c:forEach items="${contactForm.contactMap}" var="contactMap" varStatus="status">
		<tr>
			<td>${contactMap.key}</td>
			<td><input name="contactMap['${contactMap.key}']" value="${contactMap.value}"/></td>
		</tr>
	</c:forEach>
</table>	 --%>
<div class="container">
    <div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-bordered table-hover" id="tab_logic">
				<thead>
					<tr >
						<th class="text-center">
							Data Point
						</th>
						<th class="text-center">
							Value
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${contactForm.contactMap}" var="contactMap" varStatus="status">
					<tr id='addr0'>
						<td>
						${contactMap.key}
						</td>
						<td><input  type="text"  name="contactMap['${contactMap.key}']" value="${contactMap.value}" class="form-control"/></td>						
						</tr>
					</c:forEach>
                    <tr id='addr1'></tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- <a id="add_row" class="btn btn-default pull-left">Add Row</a><a id='delete_row' class="pull-right btn btn-default">Delete Row</a> -->
</div>
<a class="btn btn-home btn-lg btn1" style="margin: 0px 41% auto;" href="<c:url value='/uploadFile.htm' />"><i class="fa fa-home" aria-hidden="true"></i> Home</a>
</body>
</html>
