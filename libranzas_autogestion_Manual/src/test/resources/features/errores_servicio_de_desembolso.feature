#--------------------------------------------------------------------------------
#            SERVICIO DE DESEMBOLSO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
# language: es
@tag
Característica: Validar errores del Servicio de Desembolso
  Yo como usuario quiero replicar los errores del servicio de Desembolso, para validar que los errores generados por el servicio, están controlados en la experiencia de libranzas.

  #------------------------------------------------------------------------------------
  @NoExisteOpePreaprobadaQueCubraElMontoADesembolsar
  Escenario: El cliente ingresa a la experiencia, pero al momento del desembolso, el sistema se da cuenta que no existe OPE preaprobada que cubra el monto a desembolsar por el cliente, y le sale error en la pantalla de documentos después de darle click al botón "Finalizar".
    Dado el cliente esta en la pantalla de documentos
    Cuando da click al boton 'Finalizar'
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal física para realizar la solicitud. Si deseas recibir más información sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-CUP0445'

  #------------------------------------------------------------------------------------
  @NoExisteOpePreaprobadaQueCubraElMontoADesembolsarREPORTE
  Escenario: Cuando al cliente le falla por que la OPE no cubre el monto a desembolsar y en el reporte queda la trazabilidad del error.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces ve en el campo 'CODIGO_FUNCIONAL' el error '4-CUP0445'
    Y en el campo 'DESCRIPCION_ERROR' queda registrado 'No existe OPE preaprobada que cubra monto a desembolsar de este origen'

  #--------------------------------------------------------------------------------------------------
  @FallaEnServidorDeDepositosFront
  Escenario: El cliente ingresa a la experiencia, pero al momento de realizar el desembolso falla el servidor de depositos.
    Dado el cliente esta en la pantalla de documentos
    Cuando da click al boton 'Finalizar'
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal física para realizar la solicitud. Si deseas recibir más información sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-LCS0234'

  #----------------------------------------------------------------------------------------------------------------------------
  @FallaEnServidorDeDepositosREPORTE
  Escenario: Cuando al cliente le falla por que la OPE no cubre el monto a desembolsar y en el reporte queda la trazabilidad del error.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces ve en el campo 'CODIGO_FUNCIONAL' el error '4-LCS0234'
    Y en el campo 'DESCRIPCION_ERROR' queda registrado 'Error con el servidor de depósitos'
