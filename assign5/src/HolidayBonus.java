
public class HolidayBonus {
	public static double[] calculateHolidayBonus(double[][] sales, int highest, int lowest, int normal){
		
		int maxLength = 0;
		double[] totalBonuses = new double[sales.length];
		double[][] bonuses = new double[sales.length][];
		
		for(int i = 0; i < bonuses.length; i++) 
			bonuses[i] = new double[sales[i].length];
		
		for(int i = 0; i < bonuses.length; i++) {
			for(int k = 0; k < bonuses[i].length; k++) {
				if(sales[i][k] <= 0) bonuses[i][k] = 0;
				else bonuses[i][k] = normal;
			}
		}
		
		for(int i = 0; i < sales.length; i++)
			if(sales[i].length > maxLength) {
				maxLength = sales[i].length;
			}
		
		for(int i = 0; i < maxLength; i++) {
			if(TwoDimRaggedArrayUtility.getHighestInColumn(sales, i) > 0)
				bonuses[TwoDimRaggedArrayUtility.getHighestInColumnIndex(sales, i)][i] = highest;
			
			if(TwoDimRaggedArrayUtility.getLowestInColumnPositiveIndex(sales, i) 
					!= TwoDimRaggedArrayUtility.getHighestInColumnIndex(sales, i)
					&& TwoDimRaggedArrayUtility.getLowestInColumnPositive(sales, i) != -1)
				bonuses[TwoDimRaggedArrayUtility.getLowestInColumnPositiveIndex(sales, i)][i] = lowest;
		}
		
		for(int i = 0; i < totalBonuses.length; i++) {
			totalBonuses[i] = TwoDimRaggedArrayUtility.getRowTotal(bonuses, i);
			System.out.println("total: "+TwoDimRaggedArrayUtility.getRowTotal(bonuses, i));
		}		
		return totalBonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] sales, int highest, int lowest, int normal) {
		double[] bonuses = calculateHolidayBonus(sales, highest, lowest, normal);
		double sum = 0;
		for(int i = 0; i < bonuses.length; i++) 
			sum += bonuses[i];
		return sum;
	}
}
