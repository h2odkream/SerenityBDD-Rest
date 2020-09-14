#--------------------------------------------------------------------------------
#            RESCATE DIGITAL - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar los diversos escenarios al momento de que se active la vetana de rescate digital.
  Yo como usuario quiero validar el funcionamiento del rescate digital para poder mantener al usuario en la experiencia.

  #------------------------------------------------------------------------------------
  @Trigger1_atributos
  Escenario: Trigger en la pantalla de atributos.
    Dado el cliente ingresa a la experiencia de libranzas
    Cuando el cliente se tarda mas de 30 segundos en la pantalla
    Entonces aparece el trigger con el mensaje '¡Hola! estamos aquí para ayudarte en el proceso.'

  #-------------------------------------------------------------------------------------
  @Trigger2_calcular_cuota
  Escenario: Trigger en la pantalla de oferta, antes de calcular cuota.
    Dado El cliente esta en la pantalla de oferta
    Cuando tarda mas de 10 segundos antes de calcular la cuota
    Entonces aparece el trigger con el mensaje 'No te enredes con la selección de tu cupo ¡Consúltame!'

  #--------------------------------------------------------------------------------------------
  @Trigger3_oferta
  Escenario: Trigger en la pantalla de oferta, despues de calcular cuota.
    Dado El cliente esta en la pantalla de oferta
    Cuando tarda mas de 20 segundos sin darle click en el botón continuar
    Entonces aparece el trigger con el mensaje '¿Dudas sobre el producto o validación de los datos? Podemos ayudarte.'

  #--------------------------------------------------------------------------------------------
  @Trigger4_documentos
  Escenario: Trigger en la pantalla de documentos.
    Dado El cliente esta en la pantalla de documentos
    Cuando tarda mas de 60 en esta pantalla
    Entonces aparece el trigger con el mensaje '¿Dudas sobre la documentación? Podemos ayudarte.'

  #--------------------------------------------------------------------------------------------
  @Trigger5_salir_bienvenida
  Escenario: Trigger que aparece al momento de darle Salir en la pantalla de bienvenida.
    Dado El cliente esta en la pantalla de bienvenida
    Cuando le da al botón salir.
    Entonces aparece el trigger con el mensaje 'Espera un momento, no canceles el proceso ¡Habla con nosotros!'

  #--------------------------------------------------------------------------------------------
  @Trigger5_salir_oferta
  Escenario: Trigger que aparece al momento de darle Salir en la pantalla de oferta.
    Dado El cliente esta en la pantalla de oferta
    Cuando le da al botón salir.
    Entonces aparece el trigger con el mensaje 'Espera un momento, no canceles el proceso ¡Habla con nosotros!'

  #--------------------------------------------------------------------------------------------
  @Trigger5_salir_documentos
  Escenario: Trigger que aparece al momento de darle Salir en la pantalla de documentos.
    Dado El cliente esta en la pantalla de documentos
    Cuando le da al botón salir.
    Entonces aparece el trigger con el mensaje 'Espera un momento, no canceles el proceso ¡Habla con nosotros!'

  #----------------------------------------------------------------------------------------------
  @GliaNoPuedeDarClickEnBotonesOModales
  Escenario: Cuando este activado la navegación conjunta, desde glia no se puede dar click en algun botón o en los modales.
    Dado que se activa la navegacion conjunta
    Cuando trata de dar click a algun boton o modal desde glia
    Entonces no hace ninguna opción

  #----------------------------------------------------------------------------------------------
  @GliaNoEscogerMonto
  Escenario: Cuando este activado la navegación conjunta, desde glia no se puede cambiar el valor del monto escogido por el cliente.
    Dado que se activa la navegacion conjunta
    Cuando trata de dar cambiar el monto del usuario
    Entonces no hace ninguna opción

  #----------------------------------------------------------------------------------------------
  @GliaNoHayAsesorDisponible
  Escenario: Cuando no haya un asesor en glia conectado no puede aparecer la ventana.
    Dado que el cliente esta en la experiencia
    Cuando no hay asesores disponibles
    Entonces no aparece la 
#-