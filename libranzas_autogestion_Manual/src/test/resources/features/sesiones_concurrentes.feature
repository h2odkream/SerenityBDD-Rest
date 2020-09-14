#--------------------------------------------------------------------------------
#            SESIONES CONCURRENTES - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar la implementación de las sesiones concurrentes en la experiencia de Libranzas.
  Yo como usuario quiero validar la implementación de las sesiones concurrentes en la experiencia de Libranzas.

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeBienvenidaNavegadores_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos navegadores distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde Google Chrome
    Y El cliente ingresa a la experiencia de Libranzas desde Firefox
    Cuando le da clic en la imagen de bienvenida desde Google Chrome
    Y le da clic en la imagen de bienvenida desde Firefox
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde Google Chrome
    Y avanza a la pantalla de Oferta en la experiencia de Libranzas desde Firefox

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeBienvenidaDispositivos_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos dispositivos distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde un pc
    Y El cliente ingresa a la experiencia de Libranzas desde un dispositivo movil
    Cuando le da clic en la imagen de bienvenida desde el pc
    Y le da clic en la imagen de bienvenida desde el dispositivo movil
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde el pc
    Y avanza a la pantalla de Oferta en la experiencia de Libranzas desde el dispositivo movil

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeOfertaNavegadores_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos navegadores distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde Google Chrome
    Y El cliente ingresa a la experiencia de Libranzas desde Firefox
    Cuando le da clic en el boton Continuar de la pantalla de Oferta desde Google Chrome
    Y le da clic en el boton Continuar de la pantalla de Oferta desde Firefox
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde Google Chrome
    Y avanza a la pantalla de Documentos en la experiencia de Libranzas desde Firefox

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeOfertaDispositivos_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos dispositivos distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde un pc
    Y El cliente ingresa a la experiencia de Libranzas desde un dispositivo movil
    Cuando le da clic en el boton Continuar de la pantalla de Oferta desde el pc
    Y le da clic en el boton Continuar de la pantalla de Oferta desde el dispositivo movil
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde el pc
    Y avanza a la pantalla de Documentos en la experiencia de Libranzas desde el dispositivo movil

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeDocumentosNavegadores_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos navegadores distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde Google Chrome
    Y El cliente ingresa a la experiencia de Libranzas desde Firefox
    Cuando le da clic en el boton Finalizar de la pantalla de Documentos desde Google Chrome
    Y le da clic en el boton Finalizar de la pantalla de Documentos desde Firefox
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde Google Chrome
    Y avanza a la pantalla de Finalizacion en la experiencia de Libranzas desde Firefox

  #------------------------------------------------------------------------------------
  @SesionesConcurrentesPantallaDeDocumentosDispositivos_Manual
  Escenario: El cliente ingresa a la experiencia de Libranzas con el mismo usuario desde dos dispositivos distintos, pero sólo permite continuar la última sesión abierta.
    Dado El cliente ingresa a la experiencia de Libranzas desde un pc
    Y El cliente ingresa a la experiencia de Libranzas desde un dispositivo movil
    Cuando le da clic en el boton Finalizar de la pantalla de Documentos desde el pc
    Y le da clic en el boton Finalizar de la pantalla de Documentos desde el dispositivo movil
    Entonces se presenta el mensaje 'Has abierto otra sesión. Esta sesión se cerrará y podrás continuar con la otra [AUT028]' en la experiencia de Libranzas desde el pc
    Y avanza a la pantalla de Finalizacion en la experiencia de Libranzas desde el dispositivo movil
