#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Ingresar a la experiencia Libranzas por la SVP.
  Yo como usuario quiero autenticarme por la SVP para ingresar a la experiencia de libranzas .

  #------------------------------------------------------------------------------------
  @AutenticacionFallidaSVP
  Escenario: El cliente inicia sesion con credenciales incorrectas
    Dado el cliente se autentica por SVP con  el usuario 'PLIBRANZA47' que tiene credenciales incorrectas
    Entonces Aparece el error 'Usuario y/o clave'

  #---------------------------------------------------------------------------------------
  @AutenticacionFallidaPorClaveBloqueadaSVP
  Escenario: El cliente inicia sesion con con clave bloqueada
    Dado el cliente se autentica por SVP con  el usuario 'PLIBRANZA47' que tiene credenciales incorrectas
    Entonces aparece el error de autenticacion 'Acceso bloqueado'
