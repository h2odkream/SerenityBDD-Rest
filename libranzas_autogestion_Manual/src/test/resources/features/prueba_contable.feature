#--------------------------------------------------------------------------------
#            PRUEBAS CONTABLES - CARTERA - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		daanlope@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Ejecutar las pruebas contables en ISeries, después de realizar un desembolso de Libranzas.
  Yo como usuario quiero ejecutar las pruebas contables en ISeries, después de realizar un desembolso de Libranzas.

  #------------------------------------------------------------------------------------
  @PruebaContable_Manual
  Escenario: Se visualiza el cierre contable en ISeries, para un prestamo de una solicitud de credito de libranza desembolsada.
    Dado Se cuenta con el numero de prestamo generado al realizar la solicitud de credito de libranzas
    Cuando se consulta el numero de prestamo en ISeries
    Y se realiza el cierre contable de ese prestamo
    Entonces podra comparar la cuota de la experiencia, con la cuota generada por el cierre contable
