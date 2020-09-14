#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un crédito de Libranzas por la SVP sin clave dinamica.
  Yo como usuario quiero solicitar un credito de libranza sin clave dinamica por la SVP para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaSinClaveDinamicaExitosamente
  Esquema del escenario: El cliente (sin estar enrolado en autenticacion fuerte) desembolsa un credito de libranzas sin clave dinamica.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA47'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma los documentos con el token y cedula '18062995123'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |
    Y aparece el dashboard

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre | cta         |
      | 1000000 |    72 | *******3050 | G4     | S2       | 18062995475 | Angel  | 40675123050 |


