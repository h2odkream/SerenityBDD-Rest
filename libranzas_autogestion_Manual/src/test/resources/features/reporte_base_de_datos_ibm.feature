#--------------------------------------------------------------------------------
#            REPORTE EN LA BASE DE DATOS DE IBM - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#		miagutie@bancolombia.com.co
#		yeacorre@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar la informacion almacenada en la base de datos de IBM.
  Yo como usuario quiero validar la informacion almacenada en la base de datos de IBM.

  #------------------------------------------------------------------------------------
  @ReporteFuncionalBaseDeDatosIBM_Manual
  Escenario: Visualiza en la base de datos de IBM, la trazabilidad de las pantallas de la solicitud de credito de libranza realizada.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada

  #------------------------------------------------------------------------------------
  @CampoAceptarPagare_Manual
  Escenario: En la base de datos de IBM, se visualiza el campo ACEPTAR_PAGARE con el valor SI para el paso funcional FINALIZACION-LIBRANZA.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo ACEPTAR_PAGARE queda registrado el valor "SI"

  #------------------------------------------------------------------------------------
  @CampoIncreDuplicado_Manual
  Escenario: En la base de datos de IBM, se visualiza el campo ACEPTAR_PAGARE con el valor SI para el paso funcional FINALIZACION-LIBRANZA.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM el campo INCRE no se duplica

  #------------------------------------------------------------------------------------
  @PasoFuncionalOauth_Manual
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre la pagina3A cuando se ingresa por Oauth.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece la pagina3A

  #------------------------------------------------------------------------------------
  @PasoFuncionalSVP_Manual
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre la pagina pagina3sA cuando se ingresa por SVP.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece la pagina3sA

  #------------------------------------------------------------------------------------
  @PasosFuncionalesRepetidos_Manual
  Escenario: En la base de datos de IBM, se visualiza que los pasos funcionales no estan repetidos.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y los pasos funcionales no estan repetidos

  #------------------------------------------------------------------------------------
  @PasoFuncionalAdquiereloYaLibranza
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre el paso ADQUIERELO-YA-LIBRANZA, el cual queda registrado en el reporte de IBM al darle click a la pantalla de bienvenida.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece el paso ADQUIERELO-YA-LIBRANZA

  #------------------------------------------------------------------------------------
  @PasoFuncionalFirmaDocumentosLibranza
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre el paso FIRMA-CLAVE-DINAMICA-LIBRANZA, el cual queda registrado en el reporte de IBM al darle click al boton finalizar de la pantalla de documentos.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, no aparece el paso DOCUMENTOS-LIBRANZA
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece el paso FIRMA-DOCUMENTOS-LIBRANZA
		
 
  #------------------------------------------------------------------------------------
  @PasoFuncionalDesembolsoLibranza
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre el paso DESEMBOLSO-LIBRANZA, el cual queda registrado en el reporte de IBM al darle click al boton finalizar de la pantalla de documentos.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, no aparece el paso DOCUMENTOS-LIBRANZA
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece el paso DESEMBOLSO-LIBRANZA

  #------------------------------------------------------------------------------------
  @PasoFuncionalMailLibranza
  Escenario: En la base de datos de IBM, se visualiza que en el campo PASO_FUNCIONAL se encuentre el paso MAIL-LIBRANZA, el cual queda registrado en el reporte de IBM al igual que el paso funcional de DESEMBOLSO-LIBRANZA.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, no aparece el paso DOCUMENTOS-LIBRANZA
    Y en el reporte de IBM en el campo PASO_FUNCIONAL, aparece el paso MAIL-LIBRANZA

  #------------------------------------------------------------------------------------
  @PasoFuncionalErrorFirmaClaveDinamicaLibranza
  Escenario: En la base de datos de IBM, se visualiza que los campos CODIGO_ERROR y DESCRIPCION_ERROR correspondientes al PASO_FUNCIONAL FIRMA-CLAVE-DINAMICA-LIBRANZA, quedan diligenciados.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM los campos CODIGO_ERROR y DESCRIPCION_ERROR correspondientes al PASO_FUNCIONAL FIRMA-DOCUMENTOS-LIBRANZA, quedan diligenciados.

  #------------------------------------------------------------------------------------
  @ErroresEnElReporteFuncionalBaseDeDatosIBM_Manual
	Escenario: En la base de datos de IBM, se visualiza que los campos CODIGO_ERROR y CODIGO_FUNCIONAL quedan diligenciados cuando aparece algun error en la aplicacion de Libranzas, y que adicional a esto, el codigo de error empieza con '4-'.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y en el reporte de IBM los campos CODIGO_ERROR y CODIGO_FUNCIONAL quedan diligenciados con un '4-' y el codigo de error respectivo.
  