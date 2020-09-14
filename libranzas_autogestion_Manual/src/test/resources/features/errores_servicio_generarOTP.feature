@tag
Feature: Validar errores del Servicio GenerarOTP
  Yo como usuario quiero replicar los errores del servicio GenerarOTP, para validar que los errores generados por el servicio, estÃ©n controlados en la experiencia de libranzas.

	#---------------------------CLAVE DINAMICA INCORRECTA-------------------------------------------
	@ClaveDinamicaIncorrecta
	Scenario: El cliente ingresa a la experiencia, ingresa la clave dinamica incorrecta y le sale error en la pagina de documentos
		Given el cliente esta en la pantalla de documentos
		When acepta el seguro de vida
		Then En la pantalla de documentos se visualiza el mensaje de error 'Clave Dinámica incorrecta.', con codigo de error '4-ACOACOO902' 
###correcto


	#---------------------------AVISO PROXIMO INTENTO SE BLOQUEARA LA CLAVE DINAMICA--------------------------------------------
  @Ingresar4IntentosFallidosOTP
  Scenario Outline: El cliente ingresa a la experiencia, pero en la pantalla de documentos ingresa el numero maximo de intentos fallidos (4) y le aparece una alerta que le indica que en el proximo intento fallido sera bloqueada la clave dinamica, en la pantalla de documentos.
    Given El cliente ingresa la clave dinamica incorrecta 3 veces
    When El cliente ingresa la clave dinamica incorrecta por 4 vez
    Then en la pantalla de documentos se visualiza el mensaje de alerta 'Clave Dinámica incorrecta. Si fallas el proximo intento sera bloqueada.' y con codigo de error '4-ACOACOO9021'

###correcto    
  #---------------------------BLOQUEO DE SEGURIDAD OTP--------------------------------------------
  @BloqueadoDeSeguridadOTP
  Scenario: El cliente (con su clave dinamica bloqueada por seguridad), ingresa a la experiencia y le sale error en la pantalla de documentos
    Given el cliente esta en la pantalla de documentos
    When acepta el seguro de vida
    Then en la pantalla de documentos se visualiza el mensaje de error 'Por tu seguridad, la Clave Dinámica fue bloqueada. Debes cambiar la clave de tu tarjeta en Cajeros Automáticos, PAC o Sucursales Físicas.' y codigo de error '4-ACOACOO1021'
  
  #---------------------------BLOQUEO DE OTP POR INTENTOS FALLIDOS--------------------------------------------
  @BloqueadoDeOTPIntentosFallidos
  Scenario: El cliente ingresa a la experiencia, pero en la pantalla de documentos ingresa el numero maximo de intentos fallidos (4) y le aparece un error que le indica que ha superado el numero de intentos permitidos y la clave dinamica le sera bloqueada, en la pantalla de documentos.
    Given el cliente esta en la pantalla de documentos
    When acepta el seguro de vida
    Then en la pantalla de documentos se visualiza el mensaje de error 'Superaste el número de intentos permitidos y la Clave dinámica esta bloqueada.  Debes cambiar la clave de tu tarjeta en Cajeros Automáticos, PAC o Sucursales Físicas.' y codigo de error '4-ACOACOO1022'
 
###correcto  
  #---------------------------OTP EXPIRADA--------------------------------------------
  @OTPExpirado
  Scenario: El cliente ingresa una clave dinamica expirada, y le sale una alerta en la pantalla de documentos.
    Given El cliente ingresa por oauth con el usuario 'PITLIBRANZA9'
    When esta en la pantalla de documentos
    And ingresa la OTP expirada de la cedula '18062995629'
    Then se visualiza una alerta con el mensaje 'Tu clave dinámica ha expirado.' y codigo de error '4-ACOACOO803'
    
###correcto 
  #---------------------------BLOQUEADO VOLUNTARIO OTP--------------------------------------------
  @BloqueadoVoluntarioOTP
  Scenario: El cliente (con su clave dinamica bloqueada voluntariamente) ingresa a la experiencia y le sale error en la pantalla de documentos
    Given el cliente esta en la pantalla de documentos
    When acepta el seguro de vida
    Then en la pantalla de documentos se visualiza el mensaje de error 'Cla: Cliente Posee Clave Con Bloqueo Voluntario', con codigo de error '4-OGO560'


  #---------------------------OTP PENDIENTE DE ACTIVACION FISICA--------------------------------------------
  @OTPPendienteDeActivacionFisica
  Scenario: El cliente (con su clave dinamica pendiente de activacion fisica), ingresa a la experiencia y le sale error en la pantalla de documentos
    Given el cliente esta en la pantalla de documentos
    When acepta el seguro de vida
    Then en la pantalla de documentos se visualiza el mensaje de error 'Cla:Cliente Posee Clave Pendiente De Activar' y codigo de error '4-OGO556'
