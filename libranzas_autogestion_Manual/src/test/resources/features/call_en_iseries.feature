#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es

@tag
Característica: Validar la ejecución exitosa de un call en ISeries.
  Yo como usuario quiero validar la ejecución exitosa de un call en ISeries para realizar una determinada acción.

  #------------------------------------------------------------------------------------
  @ActivarLibranzasSinClaveDinamica
  Escenario: Se ejecuta un call en ISeries, el cual cambia el campo OTP en 'N' para permitir los desembolsos de Libranzas sin clave dinÃ¡mica.
    Dado El usuario esta en ISeries
    Cuando ejecuta el call 'call WWWLIBRP.WWWRESPFIL'
    Entonces se visualiza que en el programa 'WWWRPRFILT' de la libreria 'WWWLIBRP', Libranzas tiene el campo 'OTP' en 'N'
    
