<!doctype html>
<html lang="ru">
<head>
    <title>MENU</title>
</head>
<body>
<h2>Подробные данные</h2>
<form action="/trans/create" method="post">
    Название: <input type="text" value=${transformer.name} name="name"/><br><br>
    Мощность: <input type="number" value=${transformer.power} name="power"/><br><br>
    Потери кз: <input type="number" value=${transformer.pk} name="pk"/><br><br>
    Потери хх: <input type="number" value=${transformer.pxx} name="pxx"/><br><br>
    Х: <input type="number" step="any" value=${transformer.x} name="x"/><br><br>
    У: <input type="number" step="any" value=${transformer.y} name="y"/><br><br>
    Тау: <input type="number" value=${transformer.tau} name="tau"/><br><br>
    Vм: <input type="number" value=${transformer.vm} name="vm"/><br><br>
    Vннт: <input type="number" value=${transformer.vnnt} name="vnnt"/><br><br>
    <input type="submit" value="Сохранить тр в базу данных"/>
</form>
<hr>
<h3>Удалить трансформатор</h3>
<form action="/trans/delete/${transformer.id}" method="post">
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>