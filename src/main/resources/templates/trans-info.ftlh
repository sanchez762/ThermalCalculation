<!doctype html>
<html lang="en">
<head>
    <title>MENU</title>
</head>
<body>
<h1>Трансформаторы</h1><hr>
<h4>Подробные данные</h4>
<b>Мощность тр: </b>${menu.power}<br>
<b>Потери кз: </b>${menu.pk}<br>
<b>Потери хх: </b>${menu.pxx}<br>
<hr>
<h3>Удалить трансформатор</h3>
<form action="/trans/delete/${menu.id}" method="post">
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>