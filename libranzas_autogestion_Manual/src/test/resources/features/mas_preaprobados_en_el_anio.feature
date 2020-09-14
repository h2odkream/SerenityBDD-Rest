#--------------------------------------------------------------------------------
#            VARIOS PREAPROBADOS EN UN AÑO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Validar los diversos escenarios al momento de que pueda solicitarse dos preaprobados durante un determinado plazo de tiempo.
  Yo como usuario quiero validar que se pueda realizar varios creditos de libranza en un determinado tiempo para poder realizar varias experiencias durante el año.

  #pedir que incerten un nuevo cupo al cliente
  #------------------------------------------------------------------------------------
  @RealizarNuevamenteLaExperiencia
  Escenario: Un usuario que ya realizó una experiencia de libranza, luego de un dia pueda volver a hacer la experiencia.
    Dado El cliente realiza una experiencia de libranza
    Cuando pasa un periodo de tiempo
    Entonces podra volver a realizar la experiencia de libranza

  #------------------------------------------------------------------------------------------
  @VerificarValorNuevoPreaprobado
  Escenario: Un usuario con el nuevo cupo preaprobado pueda realizar correctamente la experiencia
    Dado El con un nuevo cupo preaprobado empieza la experiencia
    Cuando llega a finalizacion
    Entonces su desembolso queda correctamente con el nuevo cupo preaprobado
