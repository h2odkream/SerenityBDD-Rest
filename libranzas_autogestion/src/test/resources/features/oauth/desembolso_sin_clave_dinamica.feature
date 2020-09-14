#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por Oauth sin clave dinamica.
  Yo como usuario quiero solicitar un credito de libranza sin clave dinamica por Oauth para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaSinClaveDinamicaExitosamente
  Esquema del escenario: El cliente (sin estar enrolado en autenticacion fuerte) desembolsa un credito de libranzas sin clave dinamica.
    Dado que el cliente ingresa por oauth con el usuario '23LIBRANZA'
    Cuando empieza la solicitud de un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma los documentos con el token y cedula '1989648288'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |


    Ejemplos:
      | monto   | plazo | cuenta      | riesgo | segmento | cedula     | nombre | cta         |
      | 1000000 | 72    | *******8020 | G3     | S5       | 1989648288 | 70036  | 40678288020 |
