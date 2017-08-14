<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<table border = "1">
    <tr>
    <th>Customer ID</th>
    <th>Company Name</th>
    </tr>
    <c:forEach items="${cList}" var="item"> <%--jstl tag --%>
        <tr>
            <td>
                ${item.customerID}
            </td>
            <td>
                ${item.companyName}
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
