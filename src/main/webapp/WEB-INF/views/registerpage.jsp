<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>David's Dark Roast - Registration</title>

    <script>
        function validateForm() {
            var a = document.forms["regform"]["firstname"].value;
            var b = document.forms["regform"]["lastname"].value;
            var c = document.forms["regform"]["num"].value;
            var d = document.forms["regform"]["email"].value;
            if (a === "") {
                alert("A complete first name must be entered.");
                return false;
            } else if (b === "") {
                alert("A complete last name must be entered.");
                return false;
            } else if (c <= 2999999999) {
                alert("A valid area code & phone number must be enter.");
                return false;
            } else if (d === "" || !(d.includes('@')) || !(d.includes(".com"))) { //or doesn't contain an @
                alert("A complete email address is needed. Make sure that you include an '@' symbol & '.com' at the end.");
                return false;
            }
        }

</script>
</head>

<body>
${inst}
<br>
<form name="regform" action="formhandler" onsubmit="return validateForm()" method="post">
    <fieldset>
        <legend> Java Lover Registration </legend>
    First Name: <input type="text" name="firstname" > <br>
    Last Name: <input type="text" name="lastname" > <br>
    Gender: <br>
            <input type="radio" name="gender" value="Female" checked> Female <br>
            <input type="radio" name="gender" value="Male"> Male <br>
            <input type="radio" name="gender" value="Other"> Other <br>
    Phone #: <input type="number" name="num" > <br>
    Email: <input type ="text" name="email"> <br>
    Favorite type of coffee:
        <select name="javaselect">
        <option value="cappucino">Cappucino</option>
        <option value="cafe americano">Cafe Americano</option>
        <option value="cafe mocha">Cafe Mocha</option>
        <option value="latte">Latte</option>
        <option value="cafe macchiato">Cappucino</option>
        <option value="espresso">Espresso</option>
        <option value="iced coffee">Iced Coffee</option>
        <option value="frappe">Frappe</option>
        <option value="black">Black</option>
        <option value="none">None</option>
        </select>
        <br>
    <input type="submit" name="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>
