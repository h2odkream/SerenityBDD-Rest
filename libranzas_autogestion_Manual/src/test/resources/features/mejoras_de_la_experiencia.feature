#--------------------------------------------------------------------------------
#            DESPUES DEL DESEMBOLSO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
Caracter�stica: Validar la implementacion de las mejoras a la experiencia de Libranzas.
  Yo como usuario quiero validar la implementacion de las mejoras a la experiencia de Libranzas.

  #------------------------------------------------------------------------------------
  @Letra_L_Banner_Manual
  Escenario: El cliente visualiza en el banner de la APP y SVP, la letra 'L' de Libranzas en mayuscula.
    Dado El cliente ingresa a la SVP y APP
    Entonces podra ver en el banner la letra 'L' de Libranzas en mayuscula

  #------------------------------------------------------------------------------------
  @ToolTip_Tasa_Manual
  Escenario: El cliente visualiza el tooltip de la tasa con el texto "Es la tasa que te indica el valor del interes del credito en un año.".
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando se encuentra en la pantalla de la Oferta
    Entonces podra ver el tooltip de la tasa con el texto "Es la tasa que te indica el valor del interes del credito en un año."

  #------------------------------------------------------------------------------------
  @Header_Manual
  Escenario: El cliente visualiza que en el Header de todas las pantallas de la experiencia de Libranzas, no hay tanto espacio en blanco.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando pasa por todas las pantallas
    Entonces podra ver que en cada pantalla no hay tanto espacio en blanco en el header

  #------------------------------------------------------------------------------------
  @ResponsiveClaveDinamica_Manual
  Escenario: El cliente visualiza el contenido de la clave dinamica por ODA (Texto e iconos del celular y correo) alineados en una misma linea.
    Dado El cliente ingresa a la experiencia de Libranzas por la APP
    Cuando se encuentra en la pantalla de documentos de la experiencia de Libranzas
    Entonces podra ver el contenido de la clave dinamica por ODA (Texto e iconos del celular y correo) alineados en una misma linea

  #------------------------------------------------------------------------------------
  @BarraLoading_Manual
  Escenario: El cliente visualiza correctamente la barra de carga en la pantalla de documentos.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando se encuentra en la pantalla de documentos
    Y da click en el boton finalizar
    Entonces podra ver correctamente la barra de carga

  #------------------------------------------------------------------------------------
  @GeneracionUnicaOTP_Manual
  Escenario: El cliente intenta generar una nueva OTP al darle click en el boton Si acepto, pero no le permite hacerlo.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando se encuentra en la pantalla de documentos
    Y intenta generar una nueva OTP dando click al boton Si acepto
    Entonces el sistema no le permite hacerlo

  #------------------------------------------------------------------------------------
  @TextoCargaPantallaDocumentos_Manual
  Escenario: El cliente visualiza correctamente el texto de la barra de carga en la pantalla de documentos.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando se encuentra en la pantalla de documentos
    Y da click en el boton finalizar
    Entonces podra ver correctamente el texto 'Por favor no actualice la pagina, esto puede tardar unos minutos. En este momento estamos firmando los documentos' en la barra de carga

  #----------------------------------------------------------------------------------------------
  #PAQUETE 2
  #----------------------------------------------------------------------------------------------
  @TextoAlPrincipioDeLaPantallaDeDocumentos_LibranzasSinClaveDinamica
  Escenario: El cliente visualiza que el texto superior de la pantalla de documentos cuando se realiza la experiencia sin clave dinamica, cambia correctamente por 'Estos son los documentos diligenciados de tu credito. No necesitas escanearlos ni enviarlos por correo electronico, solo firmarlos digitalmente mediante un c�digo que enviaremos a tu celular.'
    Dado Un cliente sin clave dinamica ingresa a la experiencia de libranza
    Cuando Esta en la parte superior de la pantalla de documentos
    Entonces Observa el siguiente texto 'Estos son los documentos diligenciados de tu credito. No necesitas escanearlos ni enviarlos por correo electronico, solo firmarlos digitalmente mediante un c�digo que enviaremos a tu celular.'

  #------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  @Texto1DespuesDeAceptarElSeguroDeVidaPantallaDocumentosIngresaCodigo_LibranzasSinClaveDinamica
  Escenario: El cliente visualiza que el texto despues de aceptar el seguro de vida de la pantalla de documentos cuando se realiza la experiencia sin clave dinamica, cambia correctamente por 'Ingresa el codigo para firmar los documentos'
    Dado Un cliente sin clave dinamica inicia la experiencia de libranza
    Cuando Acepta el seguro de vida
    Entonces Observa el texto 'Ingresa el codigo para firmar los documentos'

  #-----------------------------------------------------------------------------------------------------------------------------------
  @Texto2DespuesDeAceptarElSeguroDeVidaPantallaDocumentosIngresaCodigo_LibranzasSinClaveDinamica
  Escenario: El cliente visualiza que el texto despues de aceptar el seguro de vida de la pantalla de documentos cuando se realiza la experiencia sin clave dinamica, cambia correctamente por 'Te enviaremos el codigo a traves de:'
    Dado Un cliente sin clave dinamica ingresa a la experiencia de libranza
    Cuando Acepta el seguro de vida
    Entonces Observa el texto 'Te enviaremos el codigo a traves de:' y el icono del celular a su lado

  #---------------------------------------------------------------------------------------------------------------------------------------
  @Texto3DespuesDeAceptarElSeguroDeVidaPantallaDocumentosIngresaCodigo_LibranzasSinClaveDinamica
  Escenario: El cliente visualiza que el texto despues de aceptar el seguro de vida de la pantalla de documentos cuando se realiza la experiencia sin clave dinamica, cambia correctamente por 'Generar un nuevo codigo'
    Dado Un cliente sin clave dinamica ingresa a la experiencia de libranza
    Cuando Acepta el seguro de vida
    Entonces Observa el texto 'Generar un nuevo codigo'

  #-------------------------------------------------------------------------------------------
  @ValidacionRenderizadoPDF
  Escenario: El cliente realiza ingresa a la experiencia de libranzas y observa que, al momento de llegar a la pantalla de documentos no se muestra el check de Declaración de haber leido de los documentos hasta que no cargue el PDF.
    Dado el cliente ingresa a la experiencia de libranzas
    Cuando Esta en la pantalla de documentos
    Entonces observa que no aparece el check de declaracion de haber leido el documento sin antes haberse cargado el pdf

  #-------------------------------------------------------------------------------------------------
  @SeparadorMilesYNoPierdeFoco
  Escenario: El cliente ingresa a la experiencia de libranzas y observa que en la pantalla de oferta al momento de ingresar el monto deseado se ponen los separadores al instante
    Dado El cliente ingresa a la experiencia de libranzas
    Cuando Escribe el monto deseado
    Entonces Observa que en paralelo se le agrega los separadores cifras

  #-------------------------------------------------------------------------------------------------------
  @CodigoDeProductoAlTenerErrorDespuesDelBannerSVP
  Escenario: Cuando un cliente trata de iniciar la experiencia de libranza por la SVP pero luego de acceder desde el banner aparece error.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver el campo 'CODIGO_ERROR' el numero '4' dentro del codigo del error

  #--------------------------------------------------------------------------------------------------------
  @CodigoDeProductoAlTenerErrorDespuesDelBannerAPP
  Escenario: Cuando un cliente trata de iniciar la experiencia de libranza por la APP pero luego de acceder desde el banner aparece error.
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver el campo 'CODIGO_ERROR' el numero '4' dentro del codigo del error

  #---------------------------------------------------------------------------------------------------
  @CodigoDeProductoAlTenerErrorDespuesDelIniciarSesionOauth
  Escenario: Cuando un cliente trata de iniciar la experiencia de libranza por ouauth pero luego de iniciar sesion aparece error
    Dado El usuario se conecta a la VPN de IBM por medio de SOFTLAYER
    Y se conecta a la base de datos de IBM con la aplicacion DBVIS
    Cuando realiza la consulta de la solicitud realizada en un rango de tiempo
    Entonces podra ver el campo 'CODIGO_ERROR' el numero '4' dentro del codigo del error
  
  #---------------------------------------------------------------------------------------------------  
  	#TIEMPO INACTIVIDAD PARAMETRIZADO
  #------------------------------------------------------------------------------------
  @Inactividad_Experiencia_Primera_Advertencia
  Escenario: El cliente visualiza que cuando se queda determinado tiempo en la experiencia en cualquier pantalla le aparece una advertencia que dice que se ha detectado un tiempo de inactividad y la sesion se finalizara en unos minutos.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando lleva '5' minutos de inactividad en la experiencia
    Entonces podra visualizar una advertencia que dice que en '2' minutos se finalizara su sesion por inactividad
    Y al darle clic en salir, podra continuar con la experiencia
    
  #---------------------------------------------------------------------------------------------------  
  @Inactividad_Experiencia_Segunda_Advertencia
  Escenario: El cliente visualiza que cuando se queda determinado tiempo en la experiencia en cualquier pantalla le aparece una advertencia que dice que se ha detectado un tiempo de inactividad y la sesion se finalizara en unos segundos.
    Dado El cliente ingresa a la experiencia de Libranzas
    Cuando lleva '7' minutos de inactividad en la experiencia
    Entonces podra visualizar una advertencia que dice que en '10' segundos se finalizara su sesion por inactividad
    Y al darle clic en salir, podra continuar con la experiencia
    
    
   #------------------------------------------------------------------------------------
     #NOMBRE EMPRESA PANTALLA BIENVENIDA
   #------------------------------------------------------------------------------------
  @NombreEmpresaPantallaBienvenidaPresente
  Escenario: El cliente visualiza en la pantalla de bienvenida, el nombre de su empresa.
    Dado El cliente ingresa a la experiencia 
    Entonces podra ver el nombre de su empresa en la pantalla de bienvenida

  #------------------------------------------------------------------------------------
   @NombreEmpresaPantallaBienvenidaNoPresente
  Escenario: El cliente no visualiza en la pantalla de bienvenida, el nombre de su empresa y puede continuar con la experiencia.
    Dado El cliente ingresa a la experiencia 
    Cuando El cliente no visualiza el nombre de su empresa en la pantalla bienvenida
    Entonces podra continuar con la experiencia normalmente.
    
       #------------------------------------------------------------------------------------
     #DESCARGA DE DOCUMENTOS
   #------------------------------------------------------------------------------------
   @TodosLosDocumentosDescargados
   Escenario: El cliente luego de llegar a finalizacion y descargar el documento puede ver que estan los cuatro documentos.
   Dado El cliente ingresa a la experiencia
   Cuando descarga los documentos en la pantalla de finalizacion
   Entonces podra ver que se le descargo los cuatro documentos (autorizacion descuento pago credito libranza, reglamento creditos libranza persona natural, anexo de operacion activa, pagare)