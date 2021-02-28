package org.prueba.utils;

public class TipoDocumento {
	public static final Integer TIPO_CEDULA= 05;
	public static final Integer TIPO_RUC_NATURAL= 04;
	public static final Integer RUC_PRIVADA = 6;
	public static final Integer RUC_PUBLICA=7;
	public static final Integer TIPO_CEDULA_VALOR= 36;
	public static final Integer TIPO_RUC_VALOR= 35;
	
	public static Integer getTipoCedula() {
		return TIPO_CEDULA;
	}
	public static Integer getTipoRucNatural() {
		return TIPO_RUC_NATURAL;
	}
	public static Integer getRucPrivada() {
		return RUC_PRIVADA;
	}
	public static Integer getRucPublica() {
		return RUC_PUBLICA;
	}

}
