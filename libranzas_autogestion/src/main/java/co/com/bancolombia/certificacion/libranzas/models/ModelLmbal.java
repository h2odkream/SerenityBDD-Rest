package co.com.bancolombia.certificacion.libranzas.models;

public class ModelLmbal {

	private String strLMBALOficinaOrigen, strLMBALNumeroDePrestamo, strLMBALTipoPlan, strLMBALCodigoDistDesembolso,
			strLMBALCodigoAnioBase, strLMBALCodigoFrecDePago, strLMBALEstadoDePrestamo, strLMBALPeriodoDelPlazo, strLMBALTasa,
			strLMBALTasaSeguroDeVida, strLMBALFechaDeNota, strLMBALFechaDeVencimiento, strLMBALCuentaAbonos, strLMBALPagoNormal,
			strLMBALMontoTotalContrato, strLMBALDescripcionUsuario1, strLMBALNumSecLineaDeCre, strLMBALCodigoDelConvenio;
	
	private String strLMBALFechaObligacion;

	public ModelLmbal(String lMBALOficinaOrigen, String lMBALNumeroDePrestamo, String lMBALTipoPlan,
					  String lMBALCodigoDistDesembolso, String lMBALCodigoAnioBase, String lMBALCodigoFrecDePago,
					  String lMBALEstadoDePrestamo, String lMBALPeriodoDelPlazo, String lMBALTasa, String lMBALTasaSeguroDeVida,
					  String lMBALFechaDeNota, String lMBALFechaDeVencimiento, String lMBALCuentaAbonos, String lMBALPagoNormal,
					  String lMBALMontoTotalContrato, String lMBALDescripcionUsuario1, String lMBALNumSecLineaDeCre,
					  String lMBALCodigoDelConvenio) {

		this.strLMBALOficinaOrigen = lMBALOficinaOrigen;
		this.strLMBALNumeroDePrestamo = lMBALNumeroDePrestamo;
		this.strLMBALTipoPlan = lMBALTipoPlan;
		this.strLMBALCodigoDistDesembolso = lMBALCodigoDistDesembolso;
		this.strLMBALCodigoAnioBase = lMBALCodigoAnioBase;
		this.strLMBALCodigoFrecDePago = lMBALCodigoFrecDePago;
		this.strLMBALEstadoDePrestamo = lMBALEstadoDePrestamo;
		this.strLMBALPeriodoDelPlazo = lMBALPeriodoDelPlazo;
		this.strLMBALTasa = lMBALTasa;
		this.strLMBALTasaSeguroDeVida = lMBALTasaSeguroDeVida;
		this.strLMBALFechaDeNota = lMBALFechaDeNota;
		this.strLMBALFechaDeVencimiento = lMBALFechaDeVencimiento;
		this.strLMBALCuentaAbonos = lMBALCuentaAbonos;
		this.strLMBALPagoNormal = lMBALPagoNormal;
		this.strLMBALMontoTotalContrato = lMBALMontoTotalContrato;
		this.strLMBALDescripcionUsuario1 = lMBALDescripcionUsuario1;
		this.strLMBALNumSecLineaDeCre = lMBALNumSecLineaDeCre;
		this.strLMBALCodigoDelConvenio = lMBALCodigoDelConvenio;
	}

	public ModelLmbal(String strLMBALFechaObligacion, String vacio) {
		this.strLMBALFechaObligacion=strLMBALFechaObligacion;

	}

	public String getStrLMBALOficinaOrigen() {
		return strLMBALOficinaOrigen;
	}

	public void setStrLMBALOficinaOrigen(String lMBALOficinaOrigen) {
		strLMBALOficinaOrigen = lMBALOficinaOrigen;
	}

	public String getStrLMBALNumeroDePrestamo() {
		return strLMBALNumeroDePrestamo;
	}

	public void setStrLMBALNumeroDePrestamo(String lMBALNumeroDePrestamo) {
		strLMBALNumeroDePrestamo = lMBALNumeroDePrestamo;
	}

	public String getStrLMBALTipoPlan() {
		return strLMBALTipoPlan;
	}

	public void setStrLMBALTipoPlan(String lMBALTipoPlan) {
		strLMBALTipoPlan = lMBALTipoPlan;
	}

	public String getStrLMBALCodigoDistDesembolso() {
		return strLMBALCodigoDistDesembolso;
	}

	public void setStrLMBALCodigoDistDesembolso(String lMBALCodigoDistDesembolso) {
		strLMBALCodigoDistDesembolso = lMBALCodigoDistDesembolso;
	}

	public String getStrLMBALCodigoAnioBase() {
		return strLMBALCodigoAnioBase;
	}

	public void setStrLMBALCodigoAnioBase(String lMBALCodigoAnioBase) {
		strLMBALCodigoAnioBase = lMBALCodigoAnioBase;
	}

	public String getStrLMBALCodigoFrecDePago() {
		return strLMBALCodigoFrecDePago;
	}

	public void setStrLMBALCodigoFrecDePago(String lMBALCodigoFrecDePago) {
		strLMBALCodigoFrecDePago = lMBALCodigoFrecDePago;
	}

	public String getStrLMBALEstadoDePrestamo() {
		return strLMBALEstadoDePrestamo;
	}

	public void setStrLMBALEstadoDePrestamo(String lMBALEstadoDePrestamo) {
		strLMBALEstadoDePrestamo = lMBALEstadoDePrestamo;
	}

	public String getStrLMBALPeriodoDelPlazo() {
		return strLMBALPeriodoDelPlazo;
	}

	public void setStrLMBALPeriodoDelPlazo(String lMBALPeriodoDelPlazo) {
		strLMBALPeriodoDelPlazo = lMBALPeriodoDelPlazo;
	}

	public String getStrLMBALTasa() {
		return strLMBALTasa;
	}

	public void setStrLMBALTasa(String lMBALTasa) {
		strLMBALTasa = lMBALTasa;
	}

	public String getStrLMBALTasaSeguroDeVida() {
		return strLMBALTasaSeguroDeVida;
	}

	public void setStrLMBALTasaSeguroDeVida(String lMBALTasaSeguroDeVida) {
		strLMBALTasaSeguroDeVida = lMBALTasaSeguroDeVida;
	}

	public String getStrLMBALFechaDeNota() {
		return strLMBALFechaDeNota;
	}

	public void setStrLMBALFechaDeNota(String lMBALFechaDeNota) {
		strLMBALFechaDeNota = lMBALFechaDeNota;
	}

	public String getStrLMBALFechaDeVencimiento() {
		return strLMBALFechaDeVencimiento;
	}

	public void setStrLMBALFechaDeVencimiento(String lMBALFechaDeVencimiento) {
		strLMBALFechaDeVencimiento = lMBALFechaDeVencimiento;
	}

	public String getStrLMBALCuentaAbonos() {
		return strLMBALCuentaAbonos;
	}

	public void setStrLMBALCuentaAbonos(String lMBALCuentaAbonos) {
		strLMBALCuentaAbonos = lMBALCuentaAbonos;
	}

	public String getStrLMBALPagoNormal() {
		return strLMBALPagoNormal;
	}

	public void setStrLMBALPagoNormal(String lMBALPagoNormal) {
		strLMBALPagoNormal = lMBALPagoNormal;
	}

	public String getStrLMBALMontoTotalContrato() {
		return strLMBALMontoTotalContrato;
	}

	public void setStrLMBALMontoTotalContrato(String lMBALMontoTotalContrato) {
		strLMBALMontoTotalContrato = lMBALMontoTotalContrato;
	}

	public String getStrLMBALDescripcionUsuario1() {
		return strLMBALDescripcionUsuario1;
	}

	public void setStrLMBALDescripcionUsuario1(String lMBALDescripcionUsuario1) {
		strLMBALDescripcionUsuario1 = lMBALDescripcionUsuario1;
	}

	public String getStrLMBALNumSecLineaDeCre() {
		return strLMBALNumSecLineaDeCre;
	}

	public void setStrLMBALNumSecLineaDeCre(String lMBALNumSecLineaDeCre) {
		strLMBALNumSecLineaDeCre = lMBALNumSecLineaDeCre;
	}

	public String getStrLMBALCodigoDelConvenio() {
		return strLMBALCodigoDelConvenio;
	}

	public void setStrLMBALCodigoDelConvenio(String lMBALCodigoDelConvenio) {
		strLMBALCodigoDelConvenio = lMBALCodigoDelConvenio;
	}
	
	public String getStrLMBALFechaObligacion() {
		return strLMBALFechaObligacion;
	}



}
