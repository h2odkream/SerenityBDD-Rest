#--------------------------------------------------------------------------------
#                 PRUEBAS DIRECCION DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es


@tag
Característica: Ejecutar las pruebas para validar que un usuario con direccion secundaria puede ingresar a la experiencia de libranza.
  Yo como usuario quiero ejecutar las pruebas para validar el campo de direccion secundaria, Realizando una experiencia completa en el producto libranza


@UsuarioConDireccionSecundaria
 Escenario: El cliente podra ingresar a la experienza de libranza teniendo el campo de direccion secundaria lleno.
    Dado El cliente se autentifica por oauth
    Entonces podra ingresar a la experiencia de libranza





 
