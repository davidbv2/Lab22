<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/resources/css/styles.css" rel="stylesheet">
    <title>David's Dark Roast - Home</title>
</head>
<body>
<h1> Welcome to David's Dark Roast! </h1>
If you are new to this new coffee spot, please register <a href="userform">here </a>!

<table border = "1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <d:forEach items="${itList}" var="item"> <%--jstl tag --%>
        <tr>
            <td>
                    ${item.name}
            </td>
            <td>
                    ${item.description}
            </td>
            <td>
                    ${item.quantity}
            </td>
            <td>
                    ${item.price}
            </td>
        </tr>
    </d:forEach>
</table>

</body>
</html>