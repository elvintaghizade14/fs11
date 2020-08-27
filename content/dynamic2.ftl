<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
    <p>Hello, ${name} !</p>
    <table border="1">
        <tbody>
        <#list students as student>
            <tr>
                <td>${student.name}</td>
                <td>${student.getName()}</td>
                <td>${student.uname()}</td>
                <td>${student.age}</td>
                <td>${student.group}</td>
            </tr>
        </#list>
        </tbody>
        </tbody>
    </table>
    <p>Total ${total}</p>
</body>
</html>
