#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Ingresar a la experiencia Libranzas por Oauth.
  Yo como usuario quiero autenticarme por Oauth para ingresar a la experiencia de libranzas.

  #------------------------------------------------------------------------------------
  @AutenticacionFallida
  Escenario: El cliente inicia sesion con credenciales incorrectas
    Dado el cliente se autentica por Oauth con  el usuario 'PLIBRANZA47' que tiene credenciales incorrectas
    Entonces Aparece en autenticacion el error 'Usuario y/o clave'

  #--------------------------------------------------------------------------------------
  @AutenticacionFallidaPorClaveBloqueada
  Escenario: El cliente inicia sesion con clave bloqueada
    Dado el cliente se autentica por Oauth con  el usuario 'PLIBRANZA47' que tiene credenciales incorrectas
    Entonces Aparece el error 'Tu clave se encuentra bloqueada'
