#--------------------------------------------------------------------------------
#            SERVICIO TASAS - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar errores del Servicio de tasas
  Yo como usuario quiero replicar los errores del servicio de tasas, para validar que los errores que generados por el servicio, estén controlados en la experiencia de libranzas.

  #------------------------------------------------------------------------------------
  @ElProcesoRequiereUnUsuarioParaEjecutarse
  Escenario: El cliente ingresa a la experiencia, pero no se envía el userName en bizagi para ejecutar el proceso de tasas y le sale error en la pantalla de oferta.
    Dado el cliente esta en la pantalla de bienvenida
    Cuando ingresa a la pantalla de oferta
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal física para realizar la solicitud. Si deseas recibir más información sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-GSCCSCC1'

  #------------------------------------------------------------------------------------
  @ElProcesoRequiereUnGrupoParaOperar
  Escenario: El cliente sin grupo en su preaprobado ingresa a la experiencia, pero no se puede operar sin este dato en el servicio de tasas y le sale error en la pantalla de oferta.
    Dado el cliente esta en la pantalla de bienvenida
    Cuando ingresa a la pantalla de oferta
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal física para realizar la solicitud. Si deseas recibir más información sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-GSCCSCC2'

	### pedirle a bizagi que no mande el plan, que lo mande vacio (P99) ó
	### Hacer un pedido a MDM para quitarle el segmento a un cliente

  #------------------------------------------------------------------------------------
  @ErrorEnLaEjecucionGetCalculateRate
  Escenario: El cliente ingresa a la experiencia, pero falla en la ejecucion de GET_CALCULATE_RATE del servicio de tasas y le sale error en la pantalla de oferta.
    Dado el cliente esta en la pantalla de bienvenida
    Cuando ingresa a la pantalla de oferta
    Entonces se visualiza el mensaje de error 'Debes acercarte a una sucursal física para realizar la solicitud. Si deseas recibir más información sobre el producto que deseas adquirir, es necesario que nos visites.' con el codigo '4-GSCCSCC3'

    #Hablar con la celula de integracion para que ponga a fallar GET_CALCULATE_RATE