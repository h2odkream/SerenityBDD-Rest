#--------------------------------------------------------------------------------
#            SERVICIO CONSULTA PRODUCTO DEPOSITOS - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Caracter�stica: Validar errores del Servicio de consulta producto depositos
  Yo como usuario quiero replicar los errores del servicio de consulta producto depositos, para validar que los errores generados por el servicio, est�n controlados en la experiencia de libranzas.

  #------------------------------------------------------------------------------------
  @TipoDeCuentaNoValidoFront
  Escenario: El cliente ingresa a la experiencia, pero el tipo de cuenta no es v�lido y le sale error en la pantalla de oferta despu�s de darle click al bot�n "Calcula tu cuota".
    Dado el cliente esta en la pantalla de oferta
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal f�sica para realizar la solicitud. Si deseas recibir m�s informaci�n sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-CASCA001'

  #------------------------------------------------------------------------------------
  @TipoDeCuentaNoValidoREPORTE
  Escenario: El cliente ingresa a la experiencia, pero el tipo de cuenta no es v�lido y le sale error en la pantalla de oferta pero en el reporte queda registrado.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces ve en el campo 'CODIGO_FUNCIONAL' el error '4-CASCA001'
    Y en el campo 'DESCRIPCION_ERROR' queda registrado 'No se encuentran cuentas de credito o debito disponibles'

  #------------------------------------------------------------------------------------
  @FallaServicioConsultaProductoDepositoFront
  Escenario: El cliente ingresa a la experiencia de libranza pero en la pantalla de oferta le muestra error por que el servicio de consulta producto deposito esta fallando.
    Dado el cliente esta en la pantalla de oferta
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal f�sica para realizar la solicitud. Si deseas recibir m�s informaci�n sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-CASCA001'

  #------------------------------------------------------------------------------------
  @FallaServicioConsultaProductodepositoREPORTE
  Escenario: El cliente ingresa a la experiencia, pero el tipo de cuenta no es v�lido y le sale error en la pantalla de oferta pero en el reporte queda registrado.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces ve en el campo 'CODIGO_FUNCIONAL' el error '4-CASCA001'
    Y en el campo 'DESCRIPCION_ERROR' queda registrado 'fallo en la consulta de cuentas::: Internal Error'
