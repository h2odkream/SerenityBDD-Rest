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

  #-----------------------------------------------------------------------------------------
  @PreaprobadoVencido
  Escenario: El cliente con el preaprobado vencido solicita un credito de libranza.
    Dado El cliente se autentica por la SVP con el usuario 'PLIBRANZA47'
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @PreaprobadoVendido
  Escenario: El cliente con el preaprobado vendido solicita un credito de libranza.
    Dado El cliente se autentica por la SVP con el usuario 'PLIBRANZA29'
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @RespuestaPrecalculadoNoValido
  Escenario: El cliente solicita un credito de libranza pero la respuesta de precalculado es N
    Dado El cliente se autentica por la SVP con el usuario 'PITLIBRANZA11'
    Entonces no se debe visualizar el banner

  #---------------------------------------------------------------------------------------
  @PrioridadUnoLibranza
  Escenario: El cliente con el producto de preaprobado libranza tiene prioridad uno
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA9'
    Entonces podra ver la experiencia de libranza

  #--------------------------------------------------------------------------------------
  @PrioridadUnoDosProductos
  Escenario: El cliente con dos productos prioridad uno ingresa a la experiencia
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA18	'
    Entonces podra ver la experiencia de libranza

  #-------------------------------------------------------------------------------------
  @PrioridadUnoLibreInversion
  Escenario: El cliente con libre inversion con prioridad uno
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PITLIBRANZA18'
    Entonces podra ver la experiencia de libre inversion
