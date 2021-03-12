package ch379;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.print("Please enter Income: ");
		String incomeString = in.nextLine();
		in.close();
		
		double income = Integer.parseInt(incomeString);
		double TaxAmmount = Math.round(TaxCalc(income) * 100.00) / 100.00;
		
		System.out.print("Income: ");
		System.out.println(income);
		System.out.print("Tax: ");
		System.out.println(TaxAmmount);
		System.out.print("Take home: ");
		System.out.println(income-TaxAmmount);
		
	}
	
	static double TaxCalc(double income)
	{
		double[][] Brackets = getBrackets();
		double[] Taxable = new double[Brackets[1].length-1];
		double TaxAmmt = 0;
		for(int i = 1; i < Brackets[1].length; i++)
		{
			if (income > Brackets[0][i] && Brackets[0][i] != 0)
				{
					Taxable[i-1] =  (Brackets[0][i] - Brackets[0][i-1]) * Brackets[1][i];
				}
			else
			{
				Taxable[i-1] = (income-Brackets[0][i-1]) * Brackets[1][i];
				break;
			}
		}
		for (int i = 0; i < Taxable.length; i++)
		{
			TaxAmmt += Taxable[i];
		}
		
		return TaxAmmt;
	}
	//Returns a 2d array
	// TaxBrackets[0] = Bracket maximum
	// TaxBrackets[1] = Bracket rate
	static double[][] getBrackets()
	{
		double[][] TaxBrackets = {
			{0,10000,30000,100000,0},
			{0,0.0,0.1,0.25,0.4}
		};
		return TaxBrackets;
	}
}
