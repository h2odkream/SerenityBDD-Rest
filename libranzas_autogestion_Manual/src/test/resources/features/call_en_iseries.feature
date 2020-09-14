#--------------------------------------------------------------------------------
#                     LIBRANZAS SIN CLAVE DINAMICA
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es

@tag
Caracter�stica: Validar la ejecuci�n exitosa de un call en ISeries.
  Yo como usuario quiero validar la ejecuci�n exitosa de un call en ISeries para realizar una determinada acci�n.

  #------------------------------------------------------------------------------------
  @ActivarLibranzasSinClaveDinamica
  Escenario: Se ejecuta un call en ISeries, el cual cambia el campo OTP en 'N' para permitir los desembolsos de Libranzas sin clave dinámica.
    Dado El usuario esta en ISeries
    Cuando ejecuta el call 'call WWWLIBRP.WWWRESPFIL'
    Entonces se visualiza que en el programa 'WWWRPRFILT' de la libreria 'WWWLIBRP', Libranzas tiene el campo 'OTP' en 'N'
    
