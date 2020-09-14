#--------------------------------------------------------------------------------
#            SERVICIO CONTRIBUCION DOCUMENTAL - LIBRANZAS Y LIBRE INVERSIÓN
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar errores del Servicio Contribución documental
  Yo como usuario quiero replicar los errores del servicio Contribución documental, para validar los errores en la experiencia de libranzas y libre inversion

  #------------------------------------------------------------------------------------
  @ElParametroTipoDeIdentificacionEsObligatorio_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro tipo de identificacion es obligatorio y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @ElParametroNumeroDeIdentificacionEsObligatorio_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro numero de identificacion es obligatorio y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @ElParametroCodigoSubtipoDocumentalEsObligatorio_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro codigo subtipo documental es obligatorio y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @ElParametroTipoDeIdentificacionSuperaLaLongitudMaximaPermitida_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro tipo de identificacion supera la longitud maxima permitida y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @ElParametroNumeroDeIdentificacionSuperaLaLongitudMaximaPermitida_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro numero de identificacion supera la longitud maxima permitida y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @ElParametroCodigoSubtipoDocumentalSuperaLaLongitudMaximaPermitida_Manual
  Escenario: El cliente ingresa a la experiencia, pero el parametro codigo subtipo documental supera la longitud maxima permitida y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @NoSeEncontroElParametroFirmaClienteDentroDeLaListaDeTrazabilidad_Manual
  Escenario: El cliente ingresa a la experiencia, pero no se encontro el parametro firmaCliente dentro de la lista de trazabilidad y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'

  #------------------------------------------------------------------------------------
  @NoSeEncontroNingunValorParaElParametroFirmaCliente_Manual
  Escenario: El cliente ingresa a la experiencia, pero no se encontro ningun valor para el parametro firmaCliente y le sale error en la pantalla de documentos
    Dado el cliente esta en la pantalla de documentos
    Cuando trata de firmar electronicamente los documentos
    Entonces en la pantalla de documentos se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'
