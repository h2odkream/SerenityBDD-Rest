#--------------------------------------------------------------------------------
#          PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por Oauth
  Yo como usuario quiero solicitar un credito de libranza por un medio digital para tener un desembolso automatico en mi cuenta.

  @PruebaDeMonitoreo
  Escenario: El cliente solicita un credito de libranza, y se realiza correctamente el desembolso. Prueba de monitoreo.
    Dado que el cliente 31LIBRANZA esta en la pantalla de Bienvenida monitoreo
    Cuando solicita un credito con los datos monitoreo
      | monto   | plazo | cuenta      |
      | 1333000 |    72 | *******8018 |
    Y firma electronicamente los documentos monitoreo
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta monitoreo
