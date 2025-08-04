<html>
    <meta charset="UTF-8">
    <title>User List</title>
<body>
    <h3>User List</h3>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <#list list as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
        </#list>
    </table>
</body>
</html>