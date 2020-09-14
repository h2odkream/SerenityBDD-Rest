#--------------------------------------------------------------------------------
#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Solicitar un credito de Libranzas por la SVP.
  Yo como usuario quiero solicitar un credito de libranza por la SVP para tener un desembolso automatico en mi cuenta.

  #------------------------------------------------------------------------------------
  @ConvenioQueNoExiste
  Escenario: El cliente solicita un credito de libranza con un convenio que no existe en ISeries.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA6'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces aparece el error '4-CSPGODBNS001' en pantalla por tener un convenio que no existe en iSeries

  #------------------------------------------------------------------------------------
  @ConvenioQueNoEsValido
  Escenario: El cliente solicita un credito de libranza con un convenio que no es valido.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA6'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces aparece el error '4-CSPGODBNS001' en pantalla por tener un convenio que no existe en iSeries

  #------------------------------------------------------------------------------------
  @ConvenioQueNoEsDeLibranza
  Escenario: El cliente solicita un credito de libranza con un convenio que no es de Libranza.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA6'
    Cuando trata de iniciar con la experiencia desde la SVP
    Entonces aparece el error '4-CSPGODBNS001' en pantalla por tener un convenio que no es de libranza
