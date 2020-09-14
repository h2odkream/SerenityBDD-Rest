#            PROYECTO EXPERIENCIA INTEGRAL DE CONSUMO - LIBRANZAS
#--------------------------------------------------------------------------------
#       			Authors:
#		miagutie@bancolombia.com.co
#		gecarmon@bancolombia.com.co
#encoding: iso-8859-1
# language: es
@tag
Característica: Realizar experiencia con clientes sin clave dinamica aun cuando se tiene la contingencia de clave dinamica activada
  Yo como usuario quiero solicitar un credito de libranza por la SVP para tener un desembolso automatico en mi cuenta.

  @ApareceBannerConUsuarioSinClaveDinamica
  Escenario: Un cliente sin clave dinamica le aparece el banner cuando la contingencia de clave dinamica esta activada
    Dado se activa la contingencia de clave dinamica
    Cuando El cliente se autentica por la SVP con el usuario 'PLIBRANZA46'
    Entonces podra ver el banner

  @NoApareceBannerConUsuarioConClaveDinamica
  Escenario: Un cliente con clave dinamica intenta realizar la experiencia de libranza pero al tener la contingencia de clave dinamica activada no le aparece el banner
    Dado se activa la contingencia de clave dinamica
    Cuando El cliente ingresa por la Sucursal Virtual Personas con el usuario 'LIBRANZAPP2'
    Entonces no se debe visualizar el banner

  @SolicitudExitosaSinClaveDinamicaConContingencia
  Esquema del escenario: El cliente (sin estar enrolado en autenticacion fuerte) desembolsa un credito de libranzas sin clave dinamica.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA47'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma los documentos con el token y cedula '18062995123'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |
    Y aparece el dashboard

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre | cta         |
      | 1000000 |    72 | *******3050 | G4     | S2       | 18062995475 | Angel  | 40675123050 |

  #-------------------------------------------------------------------------------------------------------------------
  #CONGINGENCIA CLAVE DINAMICA SCD CD
  #------------------------------------------------------------------------------------------------------------------
  @FlujoSinClaveDinamicaSinAfectacion
  Esquema del escenario: El cliente (sin estar enrolado en autenticacion fuerte) desembolsa un credito de libranzas sin clave dinamica con la contingencia activada.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'PLIBRANZA47'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma los documentos con el token y cedula '18062995123'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |
    Y aparece el dashboard

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre | cta         |
      | 1000000 |    72 | *******3050 | G4     | S2       | 18062995475 | Angel  | 40675123050 |

  #----------------------------------------------------------------------------------------------------------
  #CONTINGENCIA PARTE 2
  @ApareceBannerAClientesConClaveDinamica
  Escenario: El cliente con clave dinámica podra ver el baner cuando la contingencia de clave dinamica este activada
    Dado se activa la contingencia de clave dinamica
    Cuando El cliente se autentica por la SVP con el usuario 'LIBRANZAPP2'
    Entonces podra ver el banner

  @UsuarioClaveDinamicaEntraALaExperienciaSinCD
  Escenario: Un cliente con clave dinámica entra a hacer la experiencia de libranza con la contingencia de clave dinamica activada, observa que en la pantalla de documentos firmara el pagare con token
    Dado se activa la contingencia de clave dinamica
    Cuando El cliente se autentica por la SVP con el usuario 'LIBRANZAPP2'
    Entonces En la pantalla de documentos podra observar la palabra 'código' al momento de firmar electronicamente el pagare

  @ExperienciaDeLibranzaCorrectaClaveDinamicaConContingencia
  Esquema del escenario: El cliente solicita un credito de libranza, y se realiza correctamente el desembolso con contingencia de clave dinamica activada.
    Dado El cliente ingresa por la Sucursal Virtual Personas con el usuario 'LIBRANZAPP2'
    Cuando solicita un credito de libranza con los datos
      | monto   | plazo   | cuenta   | riesgo   | segmento   | cedula   | cta   |
      | <monto> | <plazo> | <cuenta> | <riesgo> | <segmento> | <cedula> | <cta> |
    Y firma electronicamente los documentos con la OTP y cedula '18062995475'
    Entonces podra ver la pantalla de confirmacion del credito desembolsado en su cuenta
      | nombre   | cuenta   | cedula   | cta   |
      | <nombre> | <cuenta> | <cedula> | <cta> |
    Y aparece el dashboard

    Ejemplos: 
      | monto   | plazo | cuenta      | riesgo | segmento | cedula      | nombre  | cta         |
      | 1000000 |    72 | *******5008 | G4     | S2       | 18062995475 | Lourdes | 40675475008 |
