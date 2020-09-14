#--------------------------------------------------------------------------------------------
#                     LIBRANZAS P¡ÅGINA DE CONTINGENCIA Y MANTENIMIENTO
#--------------------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
CaracterÌstica: Validar la informaciÛn almacenada en la base de datos de IBM cuando se activa la p·gina de contingencia y/o mantenimiento.
  Yo como usuario quiero validar la informaciÛn almacenada en la base de datos de IBM cuando se activa la p·gina de contingencia y/o mantenimiento para ver el registro de los datos ingresados.

  @RegistroTipoContingenciaReporteIBM
  Escenario: En la base de datos de IBM, se visualiza los datos de la pantalla de contingencia
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver la trazabilidad de cada pantalla de la solicitud de credito de libranza realizada
    Y se vera en los pasos funcionales 'PANTALLA_MANTENIMIENTO'
