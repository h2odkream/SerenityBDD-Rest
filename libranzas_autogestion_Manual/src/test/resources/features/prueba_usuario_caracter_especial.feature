#--------------------------------------------------------------------------------
#        PRUEBA USUARIO CARACTER ESPECIAL - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		gecarmon@bancolombia.com.co
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es


@tag
Característica: Ejecutar las pruebas para validar que un usuario con caracteres especiales en sus datos personales puedra ingresar a la experiencia de Libranza.
Yo como usuario quiero validar que un cliente con caracteres especiales pueda realizar una experiencia completa en el producto libranza.

@UsuarioConCaracterEspecial
  Escenario: Un usuario que cuenta con la Ñ como caracter especial en su nombre y apellido puede hacer la experiencia
    Dado El cliente realiza una experiencia de libranza
    Cuando empieza la solicitud de un credito de libranza con los datos
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
