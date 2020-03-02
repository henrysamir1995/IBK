@ConsultaPuntual
Feature: Consulta Puntual

  Scenario Outline: CP043 - CP044
    Given Que el Usuario completa las cabeceras y parametros
    When Usuario realiza la consulta por documento: <id>
    Then Valida que la respuesta sea exitosa con status code: "<code>" y el response contenga el id de documento: <id>
    And El documento <cp> se encuentre almacenado en el ECM

    Examples:
      | id                                  |code|cp   |
      | C089AA6F-0000-C510-B60A-F8D18000E302|200 |CP099|
      | 0027AA6F-0000-CC1D-9D30-335F6771C8E0|200 |CP099|

  Scenario Outline: CP045
    Given Que el Usuario completa las cabeceras y parametros
    When Usuario realiza la consulta con un documento que no existe: <id_documento>
    Then Valida que la respuesta devuelva un mensaje de error: "<mensaje>", con status code: "<code>"

    Examples:
      |id_documento                        |mensaje                                     |code |
      |804AAA6F-0000-C01F-B8E9-B78CCDEE13CB|Error sin mensaje definido en el properties.|404  |

