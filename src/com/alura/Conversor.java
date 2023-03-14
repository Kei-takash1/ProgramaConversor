package com.alura;

public class Conversor {
	
	private final double dolar = 0.054;
	private final double euro = 0.051;
	private final double libraEsterlina = 0.045;
	private final double yenJapones = 7.33;
	private final double wonCoreano = 0.014;
	
	
	
	public double convertidorMoneda(boolean cambioConversion, double valor1, double valor2, String operacion) {
		switch (operacion) {
		case "Convertir Pesos Mexicanos / Dolar": {
			if(cambioConversion) 
				return Math.round((valor1 * this.dolar) * 100) / 100d;
			return Math.round((valor2 / this.dolar)* 100) / 100d;
		}
		case "Convertir Pesos Mexicanos / Euro":{
			if(cambioConversion) 
				return Math.round((valor1 * this.euro)* 100) / 100d;
			return Math.round((valor2 / this.euro)* 100) / 100d;
		}
		case "Convertir Pesos Mexicanos / Libras Esterlinas":{
			if(cambioConversion) 
				return Math.round((valor1 * this.libraEsterlina)* 100) / 100d;
			return Math.round((valor2 / this.libraEsterlina)* 100) / 100d;	
		}
		
		case "Convertir Pesos Mexicanos / Yen Japones":{
			if(cambioConversion) 
				return Math.round((valor1 * this.yenJapones)* 100) / 100d;
			return Math.round((valor2 / this.yenJapones)* 100) / 100d;			
		}

		case "Convertir Pesos Mexicanos / Won sul-coreano":{
			if(cambioConversion) 
				return Math.round((valor1 * this.wonCoreano)* 100) / 100d;
			return Math.round((valor2 / this.wonCoreano)* 100) / 100d;
		}
			
		default:
			return 0.0;
		}	
	}
	
	public double convertidorTemperatura(boolean cambioConversion, double valor1, double valor2, String operacion) {
		switch (operacion) {
		case "Celsius / Fahrenheit": {
			if(cambioConversion)
				return Math.round(((valor1 * 1.8) + 32)* 100) / 100d;
			return Math.round(((valor2 - 32) / 1.8)* 100) / 100d;
		}
		case "Celcius / Kelvin": {
			if(cambioConversion)
				return Math.round(((valor1 + 273.15))* 100) / 100d;
			return Math.round(((valor2 - 273.15))* 100) / 100d;
		}
		case "Fahrenheit / Kelvin": {
			if(cambioConversion)
				return Math.round((((valor1 - 32) * 5/9) + 273.15) * 100) / 100d;
			return Math.round((((valor2 - 273.15) * 9/5) + 32) * 100) / 100d;
		}
		default:
			return 0.0;
		}
	}
	
}
