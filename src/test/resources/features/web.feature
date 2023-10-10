#language: es

Característica: WEB TESTS
  Como Usuario
  Quiero usar la web de exito.com
  Para realizar las pruebas de validación

  Antecedentes: Iniciar el navegador
    Dado que ingreso a la web

  @WEB-1
  Escenario: Validar que el nombre de los productos agregados deberá ser igual que en el carrito
    Dado que elijo una categoria y subcategoria
    Y elijo los productos con sus cantidades
    Cuando ingreso al carrito
    Entonces valido los nombres de los productos
    Y valido el total de los precios de los productos agregados
    Y valido las cantidades de los productos agregados
    Y valido el numero de productos agregados
