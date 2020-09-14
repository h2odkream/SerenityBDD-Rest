#--------------------------------------------------------------------------------
#            INCIDENTE BANNER LIBRANZAS Y LIBRE INVERSION
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#		csgirald@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar la solución del incidente del banner en producción.
	Yo como usuario quiero realizar el desembolso de un credito de libranza y libre inversion para tener el dinero en mi cuenta.

  #-----------------------------------------------------------------------------------------
  @PreaprobadoVencido
  Escenario: El cliente con el preaprobado vencido solicita un credito de libranza y libre inversion.
    Dado El cliente se autentica por la SVP
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @PreaprobadoVendido
  Escenario: El cliente con el preaprobado vendido solicita un credito de libranza y libre inversion.
    Dado El cliente se autentica por la SVP
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @RespuestaPrecalculadoNoValido_N
  Escenario: El cliente solicita un credito de libranza y libre inversion, pero la respuesta de precalculado es N
    Dado El cliente se autentica por la SVP
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @RespuestaPrecalculadoNoValido_S
  Escenario: El cliente solicita un credito de libranza y libre inversion, pero la respuesta de precalculado es S
    Dado El cliente se autentica por la SVP
    Entonces no se debe visualizar el banner

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaExitosamente
  Escenario: El cliente que esta en la tabla WWWLIBRAMD/WWWFFPREAP de ISeries, solicita un credito de libranza, y se realiza correctammente el desembolso.
    Dado El clienta ingresa por la Sucursal Virtual Personas
    Cuando solicita un credito de libranza
    Y firma electronicamente los documentos
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibreInversionExitosamente
  Escenario: El cliente que esta en la tabla WWWLIBRAMD/WWWFFPREAP de ISeries, solicita un credito de libre inversion, y se realiza correctammente el desembolso.
    Dado El clienta ingresa por la Sucursal Virtual Personas
    Cuando solicita un credito de libre inversion
    Y firma electronicamente los documentos
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibranzaExitosamente
  Escenario: El cliente que no esta en la tabla WWWLIBRAMD/WWWFFPREAP de ISeries, solicita un credito de libranza, y se realiza correctammente el desembolso.
    Dado El clienta ingresa por la Sucursal Virtual Personas
    Cuando solicita un credito de libranza
    Y firma electronicamente los documentos
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta

  #------------------------------------------------------------------------------------
  @SolicitarCreditoDeLibreInversionExitosamente
  Escenario: El cliente que no esta en la tabla WWWLIBRAMD/WWWFFPREAP de ISeries, solicita un credito de libre inversion, y se realiza correctammente el desembolso.
    Dado El clienta ingresa por la Sucursal Virtual Personas
    Cuando solicita un credito de libre inversion
    Y firma electronicamente los documentos
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta

  #------------------------------------------------------------------------------------
  @InsertarRegistroYaExistenteEnWWWLIBRAMD/WWWFFPREAP
  Escenario: Se va a insertar un usuario que ya esta en la tabla WWWLIBRAMD/WWWFFPREAP de ISeries, pero no lo deja insertar y aparece el mensaje en Iseries "Se ha especificado valor de clave duplicada.".
    Dado Me encuentro en la linea de comandos de ISeries
    Cuando inserto un usuario que ya se encuentra en la tabla WWWLIBRAMD/WWWFFPREAP
    Entonces aparece el mensaje "Se ha especificado valor de clave duplicada."
