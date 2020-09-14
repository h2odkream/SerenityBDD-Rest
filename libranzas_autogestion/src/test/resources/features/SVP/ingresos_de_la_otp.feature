#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por la SVP.
  Yo como usuario quiero solicitar un credito de libranza por la SVP para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @IngresarClaveDinamicaConReintentos
  Esquema del escenario: El cliente solicita un credito de libranza, pero al ingresar la clave dinamica incorrecta sin consumir el numero maximo de intentos, realiza correctamente el desembolso.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y ingresa '4' veces incorrecta la clave dinamica
    Y ingresa la clave dinamica correcta y firma los documentos con la cedula '18062995625'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |
    Y aparece el dashboard

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre | cta         |
      | 1000000 |    72 | *******5004 | G2     | S2       | 18062995625 | Juan   | 40675625004 |

  #------------------------------------------------------------------------------------
  @IngresarClaveDinamicaFallidaConElNumeroMaximoDeReintentos
  Esquema del escenario: El cliente solicita un credito de libranza pero al ingresar la clave dinamica, se consume el numero maximo de intentos y se sale de la experiencia.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y declara que ha leido el pagare y aceptado el seguro de vida
    Y ingresa la clave dinamica de forma incorrecta
    Entonces aparece un mensaje de error con codigo '4-ACOACOO1022'

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre | cta         |
      | 1000000 |    72 | *******5004 | G2     | S2       | 18062995625 | Juan   | 40675625004 |

  #------------------------------------------------------------------------------------
  @MaximoNumeroDeGeneracionDeLaOtp
  Escenario: El cliente ingresa a la experiencia de Libranzas, pero al intentar generar la OTP por 6 vez (1 cuando da clic al seguro y 4 al darle clic a Generar un nuevo codigo) le sale una ventana de alerta por haber superado el numero maximo de generacion de la OTP (5).
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA13'
    Cuando genera el token 6 veces en la pantalla de documentos
    Entonces se visualiza una alerta con el mensaje 'Tenemos inconvenientes con el sistema pero estamos trabajando para darte una solución. ¿Podrías realizar el proceso más tarde? Gracias.' y el codigo de error '4-CSGEOTAP019'
