package com.alura;

public class Conversor {
	
	private final double dolar = 0.054;
	private final double euro = 0.051;
	private final double libraEsterlina = 0.045;
	private final double yenJapones = 7.33;
	private final double wonCoreano = 0.014;
	
	
	
	public double convertidorMoneda(boolean factor, double valor1, double valor2, int lista) {
		switch (lista) {
		case 0: {
			if(factor) //nos indica si el valor devuelto va ser inverso o no
				return Math.round((valor1 * this.dolar) * 100) / 100d;
			return Math.round((valor2 / this.dolar)* 100) / 100d;
		}
		case 1:{
			if(factor) //nos indica si el valor devuelto va ser inverso o no
				return Math.round((valor1 * this.euro)* 100) / 100d;
			return Math.round((valor2 / this.euro)* 100) / 100d;
		}
		case 2:{
			if(factor) //nos indica si el valor devuelto va ser inverso o no
				return Math.round((valor1 * this.libraEsterlina)* 100) / 100d;
			return Math.round((valor2 / this.libraEsterlina)* 100) / 100d;	
		}
		
		case 3:{
			if(factor) //nos indica si el valor devuelto va ser inverso o no
				return Math.round((valor1 * this.yenJapones)* 100) / 100d;
			return Math.round((valor2 / this.yenJapones)* 100) / 100d;			
		}

		case 4:{
			if(factor) //nos indica si el valor devuelto va ser inverso o no
				return Math.round((valor1 * this.wonCoreano)* 100) / 100d;
			return Math.round((valor2 / this.wonCoreano)* 100) / 100d;
		}
			
		default:
			return 0.0;
		}	
	}
	
	public double convertidorTemperatura(boolean factor, double valor1, double valor2, int lista) {
		switch (lista) {
		case 0: {
			if(factor)
				return Math.round(((valor1 * 1.8) + 32)* 100) / 100d;
			return Math.round(((valor2 - 32) / 1.8)* 100) / 100d;
		}
		case 1: {
			if(factor)
				return Math.round(((valor1 + 273.15))* 100) / 100d;
			return Math.round(((valor2 - 273.15))* 100) / 100d;
		}
		case 2: {
			if(factor)
				return Math.round((((valor1 - 32) * 5/9) + 273.15) * 100) / 100d;
			return Math.round((((valor2 - 273.15) * 9/5) + 32) * 100) / 100d;
		}
		default:
			return 0.0;
		}
	}
	
}
