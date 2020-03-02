@ConsultaPorFiltro
Feature: Consulta por Filtro

  Scenario Outline: CP037 - CP038 - CP040
    Given Que el Usuario completa las cabeceras, parametros y request: <campo1>=<valor1>, <campo2>=<valor2>
    When Usuario realiza la consulta
    Then Valida que el response devuelva la metadata con status code: "<code>"

    Examples:
      |campo1              |valor1   |campo2        |valor2 |code|
      |id_tramite          |SRT_00036|tipo_documento|TDR0001|200 |
      |tipo_documento      |TDR0001  |tipo_tramite  |TTR0002|200 |
      |codigo_unico_cliente|02157867 |producto      |PDO0004|200 |

  Scenario Outline: CP039
    Given Que el Usuario completa los headers, parametros y request: <campo1>=<valor1>, <campo2>=<valor2>, <campo3>=<valor3>
    When Usuario realiza la consulta
    Then Valida que el response devuelva la metadata con status code: "<code>"

    Examples:
      |campo1              |valor1   |campo2        |valor2 |campo3        |valor3     |code|
      |tipo_documento      |TDR0003  |tipo_tramite  |TTR0001|nombres       |Henry Samir|200 |

  Scenario Outline: CP041 - CP042
    Given Que el Usuario completa las cabeceras, parametros y request: <campo1>=<valor1>, <campo2>=<valor2>
    When Usuario realiza la consulta
    Then Valida que el response devuelva un mensaje de error: "<mensaje>", con status code: "<code>"

    Examples:
      |campo1                  |valor1      |campo2   |valor2           |mensaje                  |code|
      |tipo_documento          |TDR0005     |apellidos|Jimenez Seminario|Filtro sin coincidencias.|404 |
      |tipo_documento_identidad|TDI0001$%$&/|producto |PDO0001          |Dato invalido.           |400 |
