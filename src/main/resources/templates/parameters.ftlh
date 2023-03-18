<!doctype html>
<html lang="ru">
<head>
    <title>Parameters</title>
</head>
<body>
<h2>Подробные данные</h2>
<form action="/parameters/apply" method="post">
    Температура: <input type="number" step="any" value="-15" name="temperature"/><br><br>
    Кол-во тр: <input type="number" value="1" name="n"/><br><br>
    Smax: <input type="number" step="any" value="33.33" name="smax"/><br><br>
    Число итераций расчета: <input type="number" value="2" name="iter"/><br><br>
    Максимальная температура масла: <input type="number" value="115" name="tmMax"/><br><br>
    Максимальная температура ннт: <input type="number" value="160" name="tnntMax"/><br><br>
    <input type="submit" value="Применить"/>
</form>
</body>
</html>