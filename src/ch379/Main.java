package ch379;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double income = 1234567;
		
		System.out.print("Income: ");
		System.out.println(income);
		System.out.print("Tax: ");
		System.out.println(TaxCalc(income));
		System.out.print("Take home: ");
		System.out.println(income-TaxCalc(income));
		
	}
	
	static double TaxCalc(double income)
	{
		double[][] Brackets = getBrackets();
		double[] Taxable = new double[Brackets[1].length-1];
		double TaxAmmt = 0;
		for(int i = 1; i < Brackets[1].length; i++)
		{
			if (income > Brackets[0][i])
				{
					Taxable[i-1] =  (Brackets[0][i] - Brackets[0][i-1]) * Brackets[1][i];
					income = income-Brackets[0][i];
				}
			else
			{
				Taxable[i-1] = income * Brackets[1][i];
				break;
			}
		}
		for (int i = 0; i < Taxable.length; i++)
		{
			TaxAmmt += Taxable[i];
		}
		
		return TaxAmmt;
	}
	
	static double[][] getBrackets()
	{
		double[][] TaxBrackets = {
			{0,10000,30000,100000,0},
			{0,0,0.1,0.25,0.4}
		};
		return TaxBrackets;
	}
}
