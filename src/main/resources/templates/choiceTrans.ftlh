<!doctype html>
<html lang="ru">
<head>
    <title>choice</title>
</head>
<body>
<h1>Выбор трансформатора</h1><hr>
<#list list as transformer>
    <div>
        <p><b>${transformer.name}</b> | <a href="/trans/${transformer.id}">Подробнее...</a><br>
        <form action="/setTrans/${transformer.id}" method="post">
            <button type="submit">Выбрать</button>
        </form>
    </div>
<#else>
    <h3>Нет тр</h3>
</#list>
</body>
</html>