#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		gecarmon@bancolombia.com.co
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por Oauth con clave dinamica.
  Yo como usuario quiero solicitar un credito de libranza por Oauth para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaExitosamente
  Esquema del escenario: El cliente solicita un credito de libranza, y se realiza correctamente el desembolso.
    Dado que el cliente ingresa por oauth con el usuario 'NLBRANZA11'
    Cuando empieza la solicitud de un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   | tipoDesembolso   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> | <tipoDesembolso> |
    Y firma electronicamente los documentos con la OTP y cedula '2019050434'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | convenio   | cuenta   | cedula   | cta   |
      | <convenio> | <cuenta> | <cedula> | <cta> |

    Ejemplos:
      | monto   | plazo | cuenta      | riesgo | segmento | cedula     | convenio | cta         | tipoDesembolso |
      | 1000000 | 96    | *******4008 | G3     | S2       | 2019050436 | 70036    | 40670434008 | seguroDesempleo |


