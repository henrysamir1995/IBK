@IngestaAsync
Feature: Ingesta de Documentos - Manera Asincrona

Scenario Outline: CP001-CP050
    Given Que el Usuario completa el request para ingestar un PDF con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response devuelva un mensaje de envio exitoso del archivo R_<caso_de_prueba>.pdf

    Examples:
        |caso_de_prueba|
        |CP001         |
        |CP050         |

Scenario Outline: CP002-CP029
    Given Que el Usuario completa el request para ingestar un EXCEL con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response devuelva un mensaje de envio exitoso del archivo R_<caso_de_prueba>.xlsx

    Examples:
        |caso_de_prueba|
        |CP002         |
        |CP029         |

Scenario Outline: CP003-009-010-011-012-013-014-015-016-017-018-019-020-021-022-023-024-025-026-027-028
    Given Que el Usuario completa el request para ingestar un WORD con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response devuelva un mensaje de envio exitoso del archivo R_<caso_de_prueba>.docx

    Examples:
        |caso_de_prueba|
        |CP003         |
        |CP009         |
        |CP010         |
        |CP011         |
        |CP012         |
        |CP013         |
        |CP014         |
        |CP015         |
        |CP016         |
        |CP017         |
        |CP018         |
        |CP019         |
        |CP020         |
        |CP021         |

Scenario Outline: CP022-CP023-CP024-CP025-CP026-CP027-CP028-CP030
    Given Que el Usuario completa el request para ingestar un WORD con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "<error>"

    Examples:
        |caso_de_prueba|error|
        |CP022         |Peticion Incorrecta.            |
        |CP023         |Peticion Incorrecta.            |
        |CP024         |Peticion Incorrecta.            |
        |CP025         |Peticion Incorrecta.            |
        |CP026         |Peticion Incorrecta.            |
        |CP027         |Propiedad channelUser requerida.|
        |CP028         |Peticion Incorrecta.            |
        |CP030         |Peticion Incorrecta.            |

Scenario: CP031
    Given Que el Usuario completa el request para ingestar una C.R. con las condiciones del CP031
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "Peticion Incorrecta."

Scenario: CP032
    Given Que el Usuario completa el request para ingestar una Evidencia con las condiciones del CP032
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "El documento fue alterado."

Scenario: CP033
    Given Que el Usuario completa el request para ingestar una H.R. con las condiciones del CP033
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "Peticion Incorrecta."

Scenario Outline: CP034-CP035-CP036
    Given Que el Usuario completa el request para ingestar un archivo no permitido con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "Archivo no permitido."

        Examples:
            |caso_de_prueba|
            |CP034         |
            |CP035         |
            |CP036         |

Scenario Outline: CP046-CP047-CP048-CP049
    Given Que el Usuario completa el request para ingestar un PDF con las condiciones del <caso_de_prueba>
    When Usuario realiza la ingesta
    Then Valida que el response muestre un mensaje de error: "<error>"

    Examples:
        |caso_de_prueba|error                                        |
        |CP046         |Propiedad id_tramite requerida.              |
        |CP047         |Propiedad tipo_documento_identidad requerida.|
        |CP048         |Propiedad apellidos requerida                |
        |CP049         |Propiedad nombres requerida.                 |


