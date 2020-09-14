#-----------------------------------------------------------------------------------------
#            REPORTE EN LA BASE DE DATOS DE IBM - Ventana mantenimiento-contingencia
#-----------------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar la informacion almacenada en la base de datos de IBM.
  Yo como usuario quiero validar la informacion almacenada en la base de datos de IBM.

  #------------------------------------------------------------------------------------
  @ReporteFuncionalBaseDeDatosIBM_Contingencia_Manual
  Escenario: Visualiza en la base de datos de IBM, la trazabilidad de la pantalla de contingencia.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la ver los datos del cliente que ingresa en la pantalla de contingencia.

    #------------------------------------------------------------------------------------
  @ReporteFuncionalBaseDeDatosIBM_Mantenimiento_Manual
  Escenario: Visualiza en la base de datos de IBM, la trazabilidad de la pantalla de mantenimiento.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la ver los datos del cliente que ingresa en la pantalla de mantenimiento.

