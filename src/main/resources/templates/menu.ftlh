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
</form><br>
<#if power??>График нагрузки определен</#if>
<hr>
<form action="/parameters" method="get">
    <button type="submit">Перейти к параметрам расчета</button>
</form>
<hr>
<form action="/calculate" method="get">
    <button type="submit">Выполнить расчет</button>
</form>
<#if condition??>
    <#if condition[0]> Темературы масла не превышают максимальных значений
    <#else>Темературы масла превышают максимальные значения
    </#if><br>
    <#if condition[1]> Темературы ннт не превышают максимальных значений
    <#else>Темературы ннт превышают максимальные значения
    </#if>
</#if>
<hr>
<form action="/chart" method="get">
    <button type="submit">График</button>
</form><br>
</body>
</html>