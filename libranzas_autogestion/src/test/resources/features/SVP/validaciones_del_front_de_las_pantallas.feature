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
  @RegistroDeTransaccionYErrorEnElServicioRecuperarCuentasDeposito
  Escenario: El cliente solicita un credito de libranza pero cuando se invoca el servicio recuperarCuentasDeposito falla y queda la transaccion en el log
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces aparece el error 'VAL008' en pantalla y queda el registro de transaccion el numero '0012', al ingresar con la cedula '18062995475'

  #-------------------------------------------------------------------------------------
  @ValidacionInvocacionServicios
  Escenario: El cliente solicita un credito de libranza y al autenticarse se verifica la invocacion de los servicios consultarAutenticacionFuerte y consultarPrecalculados
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces en el Log STIFFLGSBC queda la transaccion '0110' y en el log STIFFLGVP1 la transaccion '0120', al ingresar con la cedula '18062995475'

  #------------------------------------------------------------------------------------
  @FechaDeNovedadMenorA5DiasOtp
  Escenario: El cliente solicita un credito de libranza pero como tiene la fecha de novedad otp menor a cinco dias no lo deja iniciar con la experiencia
    Dado El cliente se autentica por la SVP con el usuario 'PITLIBRANZA9'
    Entonces no se debe visualizar el banner por tener la fecha de novedad menor a '5' dias con la cedula '18062995475'

  #-----------------------------------------------------------------------------------
  @MontoMenorAlPermitido
  Escenario: El cliente solicita un credito de libranza con un monto menor al permitido
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando trata de iniciar con la experiencia desde la SVP
    Y solicita un credito con 500000 de monto
    Entonces Aparece el error 'No menor a'

  #-----------------------------------------------------------------------------------
  @MontoMayorAlPermitidoDelCredito
  Escenario: El cliente solicita un credito de libranza con un monto menor al permitido
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando trata de iniciar con la experiencia desde la SVP
    Y solicita un credito con 99999999999 de monto
    Entonces Aparece el error 'No mayor a'

  #----------------------------------------------------------------------------------
  @VentanaDeIndisponibilidad
  Escenario: El cliente ingresa en el momento donde la pantalla de mantenimiento esta activa
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Entonces podra ver la pantalla de mantenimiento

  #----------------------------------------------------------------------------------------
  @MensajeDeTransicionPantallaBienvenida
  Escenario: El cliente ingresa a la experiencia de libranzas y le aparece un mensaje en la transicion de la pantalla de bienvenida a la pantalla de oferta.
    Dado El cliente se autentica por la SVP con el usuario 'PITLIBRANZA9'
    Entonces se visualiza un gif con el mensaje 'Por favor no actualice la página, esto puede tardar unos minutos.'

  #-------------------------------------------------------------------------------------
  @MensajeDeTransicionPantallaOferta
  Escenario: El cliente ingresa a la experiencia de libranzas y le aparece un mensaje en la transicion de la pantalla de oferta a la pantalla de documentos.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces se visualiza un gif con el mensaje 'Por favor no actualice la página, esto puede tardar unos minutos.'

  #-------------------------------------------------------------------------------------
  @MensajeDeTransicionPantallaDocumentos
  Esquema del escenario: El cliente ingresa a la experiencia de libranzas y le aparece un mensaje en la transicion de la pantalla de documentos a la pantalla de finalizacion.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'LIBRANZAPP2'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma electronicamente los documentos con la OTP y cedula '18062995475'
    Entonces se visualiza un gif con el mensaje 'Por favor no actualice la página'

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre  | cta         |
      | 1000000 |    72 | *******5008 | G4     | S2       | 18062995475 | Lourdes | 40675475008 |

  #-------------------------------------------------------------------------------------------------------------------------------
  @TextoSoftokenSVP
  Esquema del escenario: El cliente solicita un credito de libranza por la SVP, verifica el texto cuando el tipo de ODA  es Softoken, y se sale de la experiencia.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'LIBRANZAPP2'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y declara que ha leido el pagare y aceptado terminos
    Entonces aparece el mensaje 'La encuentras en App Bancolombia'

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre  | cta         |
      | 1000000 |    72 | *******5008 | G4     | S2       | 18062995475 | Lourdes | 40675475008 |

  #-----------------------------------------------------------------------------------
  @ConsultaDeCreditosSVP
  Escenario: El cliente revisa el credito previamente adquirido
    Dado El cliente se autentica por la SVP con el usuario 'LIBRANZAPP2'
    Cuando ingresa a ver los creditos adquiridos
    Entonces podra ver el credito en la SVP
