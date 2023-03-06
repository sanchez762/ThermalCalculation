<!doctype html>
<html lang="en">
<head>
    <title>MENU</title>
</head>
<body>
<h1>Трансформаторы</h1><hr>
<h4>Список</h4>
<form action="/" method="get">
    Поиск по названию: <input type="text" name="name"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list menu as trans>
    <div>
        <p><b>${trans.power}</b> | <a href="/trans/${trans.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Нет тр</h3>
</#list>
<hr>
<h3>Добавить трансформатор</h3>
<form action="/trans/create" method="post">
    Название: <input type="text" name="name"/><br><br>
    Мощность: <input type="number" name="power"/><br><br>
    Потери кз: <input type="number" name="pk"/><br><br>
    Потери хх: <input type="number" name="pxx"/><br><br>
    Х: <input type="number" step="any" name="x"/><br><br>
    У: <input type="number" step="any" name="y"/><br><br>
    Тау: <input type="number" name="t"/><br><br>
    Vм: <input type="number" name="vm"/><br><br>
    Vннт: <input type="number" name="vnnt"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>