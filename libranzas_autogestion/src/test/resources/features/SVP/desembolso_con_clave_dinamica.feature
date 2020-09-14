#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por la SVP con clave dinámica.
  Yo como usuario quiero solicitar un credito de libranza por la SVP para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaExitosamente
  Esquema del escenario: El cliente solicita un credito de libranza, y se realiza correctamente el desembolso.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'NLBRANZA13'
    Cuando empieza la solicitud de un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma electronicamente los documentos con la OTP y cedula '2019050436'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula     | nombre | cta         |
      | 1000000 |    84 | *******6007 | G5     | S2       | 2019050489 |  70000 | 40670436007 |
