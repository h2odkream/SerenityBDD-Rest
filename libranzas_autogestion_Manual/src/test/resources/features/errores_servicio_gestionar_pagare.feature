#--------------------------------------------------------------------------------
#            SERVICIO GESTIONAR PAGARE - LIBRANZAS Y LIBRE INVERSION
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar errores del Servicio Gestionar Pagare
  Yo como usuario quiero replicar los errores del servicio gestionar pagare para validar los errores en la experiencia de libranzas y libre inversion

  #---------------------------CREAR GIRADOR--------------------------------------------
  @NoExisteElEmisorEnviado_Manual
  Escenario: El cliente ingresa a la experiencia, pero no existe el emisor enviado y le sale error en la pantalla de oferta
    Dado el cliente esta en la pantalla de bienvenida
    Cuando trata de continuar a la pantalla de oferta
    Entonces en la pantalla de oferta se visualiza el mensaje 'Completa el proceso. Continua con la solicitud en nuestra Sucursal Telefonica 01-800-0912345. ¡Estamos trabajando para ti!'