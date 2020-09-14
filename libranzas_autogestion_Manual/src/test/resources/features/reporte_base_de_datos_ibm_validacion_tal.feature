#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar la información almacenada en la base de datos de IBM de los usuarios sin clave dinámica.
  Yo como usuario quiero validar la información almacenada en la base de datos de IBM de los usuarios sin clave dinámica.

  #------------------------------------------------------------------------------------
  @CampoMecanismoEnrolamiento_Manual
  Escenario: En la base de datos de IBM, se visualiza el campo MECANISMO_ENROLAMIENTO con el valor TAL.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo MECANISMO_ENROLAMIENTO queda registrado el valor "TAL"

  #------------------------------------------------------------------------------------
  @CampoMetodoEnvioOTP_ODA_Manual
  Escenario: En la base de datos de IBM, se visualiza el campo METODO_ENVIO_OTP_ODA con el valor SMS.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo METODO_ENVIO_OTP_ODA queda registrado el valor "SMS"

  #------------------------------------------------------------------------------------
  @ActivarLibranzasSinClaveDinamica
  Escenario: Se ejecuta un call en ISeries, el cual cambia el campo OTP en 'N' para permitir los desembolsos de Libranzas sin clave dinÃ¡mica.
    Dado El usuario esta en ISeries
    Cuando ejecuta el call 'call WWWLIBRP.WWWRESPFIL'
    Entonces se visualiza que en el programa 'WWWRPRFILT' de la libreria 'WWWLIBRP', Libranzas tiene el campo 'OTP' en 'N'
