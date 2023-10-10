#language: es

@API
Característica: REST API TESTS
  Como Usuario
  Quiero usar el api de ejemplo
  Para validarlo

  @API-1
  Escenario: Validar el api me liste todos los empleados [OK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Cuando ejecuto el api
      | url                                               | metodo |
      | https://dummy.restapiexample.com/api/v1/employees | GET    |
    Entonces valido que el codigo de respuesta sea "200"

  @API-2
  Esquema del escenario: Validar el api me muestre un emplado [OK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Cuando ejecuto el api
      | url                                                   | metodo |
      | https://dummy.restapiexample.com/api/v1/employee/<id> | GET    |
    Entonces valido que el codigo de respuesta sea "200"
    Ejemplos:
      | id |
      | 1  |
      | 2  |

  @API-3
  Escenario: Validar el api no muestre un usuario inexistente [NOK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Cuando ejecuto el api
      | url                                                   | metodo |
      | https://dummy.restapiexample.com/api/v1/employee/1000 | GET    |
    Entonces valido que el codigo de respuesta sea "200"
    Y valido los siguientes resultados en el json de respuesta
      | nodo | value |
      | data | null  |

  @API-4
  Escenario: Validar que se pueda agregar un empleado [OK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Y que configuro el body request
      | key    | value |
      | name   | test  |
      | salary | 123   |
      | age    | 23    |
    Cuando ejecuto el api
      | url                                            | metodo |
      | https://dummy.restapiexample.com/api/v1/create | POST   |
    Entonces valido que el codigo de respuesta sea "200"
    Y valido los siguientes resultados en el json de respuesta
      | nodo   | value   |
      | status | success |

  @API-5
  Escenario: Validar que pueda editar un empleado [OK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Y que configuro el body request
      | key    | value  |
      | name   | Prueba |
      | salary | 124    |
      | age    | 25     |
    Cuando ejecuto el api
      | url                                               | metodo |
      | https://dummy.restapiexample.com/api/v1/update/21 | PUT    |
    Entonces valido que el codigo de respuesta sea "200"
    Y valido los siguientes resultados en el json de respuesta
      | nodo   | value   |
      | status | success |

  @API-6
  Escenario: Validar que pueda eliminar un empleado [OK]
    Dado que configuro los headers
      | header       | value            |
      | Content-Type | application/json |
    Cuando ejecuto el api
      | url                                               | metodo |
      | https://dummy.restapiexample.com/api/v1/delete/79 | DELETE |
    Entonces valido que el codigo de respuesta sea "200"
    Y valido los siguientes resultados en el json de respuesta
      | nodo   | value   |
      | status | success |