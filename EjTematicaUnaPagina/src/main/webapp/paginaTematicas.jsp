<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paginas tematicas</title>
</head>
<body>
    <h1>${tematica.nombreTematica}</h1>
    
    <p>${tematica.detalle1}</p>
    <a href="${tematica.enlace1}">${tematica.nombre1}</a>
    <br>
    <p>${tematica.detalle2}</p>
    <a href="${tematica.enlace2}">${tematica.nombre2}</a>
    <br>
    <p>${tematica.detalle3}</p>
    <a href="${tematica.enlace3}">${tematica.nombre3}</a>
    <br>
    <br>
    <button onclick="window.location.href='index.html'">Volver a la pagina principal</button>
</body>
</html>