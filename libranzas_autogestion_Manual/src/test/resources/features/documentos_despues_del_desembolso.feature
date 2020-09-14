#--------------------------------------------------------------------------------
#            DESPUÉS DEL DESEMBOLSO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		gecarmon@bancolombia.com.co
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar los diferentes documentos que se generan al desembolsar un crédito de Libranzas.
	Yo como usuario quiero validar los diferentes documentos que se generan al desembolsar un crédito de Libranzas.

  #------------------------------------------------------------------------------------
  @DocumentosEnElCorreo_Manual
  Escenario: El cliente visualiza en su correo, el correo de bienvenida y el archivo adjunto de la solicitud de credito de libranza realizada.
    Dado El cliente ingresa al correo registrado en alertas y notificaciones
    Cuando busca el correo de 'no-reply@bancolombia.com' con asunto 'Solicitud de Libranza.'
    Entonces podra ver en el correo la informacion del Credito de Libranza

  #------------------------------------------------------------------------------------
  @DocumentosExperiencia_Manual
  Escenario: El cliente visualiza en la pantalla de finalizacion el link de descarga de la carta de bienvenida y la solicitud de credito de libranza realizada.
    Dado El cliente  se encuentra en la pantalla de finalizacion 
    Cuando visualiza el link 'Descarga los documentos legales, condiciones y recomendaciones que acabas de firmar.'
    Entonces podra ver en el pdf descargado la carta de bienvenida con la informacion del Credito de Libranza

  #------------------------------------------------------------------------------------
  
  @TrazabilidadPantallasTxtBizagi_Manual
  Escenario: El cliente visualiza la trazabilidad de las pantallas en el txt de bizagi.
    Dado El cliente ingresa a bizagi
    Cuando busca el txt del credito de libranza con el numero de caso
    Entonces podra ver en el txt la informacion de lo que se hizo en cada pantalla de la experiencia de libranzas separado por salto de linea

  #------------------------------------------------------------------------------------
  @DocumentosEnUCMyDeceval_Manual
  Escenario: El cliente visualiza en UCM y en Deceval, los documentos de la solicitud de credito de libranza realizada.
    Dado El cliente ingresa a UCM y Deceval
    Cuando busca los documentos con el numero de identificacion del cliente
    Entonces podra ver en los documentos la información de la solicitud del Credito de Libranza realizada
