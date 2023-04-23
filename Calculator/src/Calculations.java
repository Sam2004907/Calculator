public class Calculations {
	public static double Calculate(double num1, double num2, double pi, char operator) {
		double result = num1;
		
		// Addition Calculation
		if (operator == '+') {
			result = num1+num2;
		} 
		
		// Subtraction Calculation
		else if (operator == '-') {
			result = num1-num2;
		} 
		
		// Multiplication Calculation
		else if (operator == '×') {
			result = num1*num2;
		} 
		
		// Division Calculation
		else if (operator == '÷') {
			result = num1/num2;
		} 
		
		// Power of Calculation
		else if (operator == '^') {
			result = Math.pow(num1, num2);
		}
		
		// Percentage Calculation
		else if (operator == '%') {
			result = (num1 / 100) * num2;
		}
		
		// Square Root Calculation
		else if (operator == '√') { 
			result = Math.sqrt(num1);
		}
		
		// Negative Calculation
		else if (operator == 'n'){
			result = (num1 * -1);
		}
		
		// Calculation result
		return result;
	}
}

