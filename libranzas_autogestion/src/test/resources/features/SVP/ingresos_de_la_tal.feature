#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Caracter�stica: Solicitar un cr�dito de Libranzas por la SVP sin clave dinamica.
  Yo como usuario quiero solicitar un credito de libranza sin clave dinamica por la SVP para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @MaximoNumeroDeGeneracionDelToken
  Escenario: El cliente ingresa a la experiencia de Libranzas, pero al intentar generar el token por 6 vez (1 cuando da clic al seguro y 4 al darle clic a Generar un nuevo codigo) le sale una ventana de alerta por haber superado el numero maximo de generacion del token (5).
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA45'
    Cuando genera el token 6 veces en la pantalla de documentos
    Entonces se visualiza una alerta con el mensaje 'Tenemos inconvenientes con el sistema pero estamos trabajando para darte una soluci�n. �Podr�as realizar el proceso m�s tarde? Gracias.' y el codigo de error '4-CSGEOTAP019'

  #------------------------------------------------------------------------------------
  @TokenExpirado
  Escenario: El cliente ingresa a la experiencia de Libranzas, pero al ingresar el token le sale una ventana de alerta porque la vigencia del token ha expirado.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA45'
    Cuando esta en la pantalla de documentos
    Y ingresa el token expirado de la cedula '18062995475'
    Entonces se visualiza una alerta con el mensaje 'Tu c�digo ha expirado.' y el codigo de error '4-GENST0116'

  #------------------------------------------------------------------------------------
  @TokenBloqueadoPorIntentosFallidos
  Escenario: El cliente ingresa a la experiencia de Libranzas, pero al ingresar por 3 vez el token despues de fallar el maximo de intentos (2 y no se le avisa en el 2 intento que le falta 1 intento), le sale una ventana de alerta porque el token se ha bloquedo.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA45'
    Cuando esta en la pantalla de documentos
    Y ingresa el token con intentos fallidos
    Entonces se visualiza una alerta con el mensaje 'PIN bloqueado por n�mero de intentos fallidos.' y el codigo de error '4-GENST0117'

  #------------------------------------------------------------------------------------
  @TokenIncorrecto
  Escenario: El cliente ingresa a la experiencia de Libranzas, pero al ingresar el token incorrecto, le sale una ventana de alerta porque el token es incorrecto.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA45'
    Cuando esta en la pantalla de documentos
    Y ingresa el token incorrecto
    Entonces se visualiza una alerta con el mensaje 'C�digo incorrecto.' y el codigo de error '4-GENST0118'
