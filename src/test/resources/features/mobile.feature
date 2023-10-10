#language: es

Característica: MOBILE TESTS
  Como Usuario
  Quiero usar la app mobile de exito
  Para realizar las pruebas de validación

  Antecedentes: Iniciar el navegador
    Dado que ingreso a la aplicacion mobile

  @MOBILE-1
  Escenario: Validar que puedo registrarme en la app de exito
    Dado que ingreso a registrarme
    E ingreso los valores a registrar
    Cuando confirmo el registro
    Entonces valido que se confirme

  @MOBILE-2
  Escenario: Validar que puedo registrarme en la app de exito
    Dado que ingreso al login
    E ingreso los valores de inicio de sesion
    Cuando al iniciar sesion
    Entonces valido que pueda hacer login

  @MOBILE-3
  Escenario: Validar que puedo registrarme en la app de exito
    Dado inicio sesion
    Y selecciono un producto
    Cuando al ingreso al carrito
    Entonces valido el carrito