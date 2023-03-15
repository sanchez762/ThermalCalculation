<!doctype html>
<html lang="ru">
<head>
    <title>MENU</title>
</head>
<body>
<h1>Программа для расчета теплового режима</h1><hr>
<h4>Выбор трансформатора</h4>
<form action="/choiceTrans" method="get">
    <button type="submit">Выбрать</button>
</form><br>
<#if tr??>
    Выбранный трансформатор: ${tr.name}
<#else>
    Трансформатор не выбран
</#if>
<hr>
<form action="/loadChart" method="get">
    <button type="submit">Установить график нагрузки</button>
</form>
<#if power??>График нагрузки определен</#if>
<form action="/parameters" method="get">
    <button type="submit">Перейти к параметрам расчета</button>
</form>
<form action="/chart" method="get">
    <button type="submit">График</button>
</form>
</body>
</html>