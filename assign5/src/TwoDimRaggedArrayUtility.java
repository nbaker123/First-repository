import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	public static double[][] readFile(File file){
		
		//Declaring necessary arrays for each store
		double[] currentStore;
		String[] strs;
		String str;
		int row = 0;
		double[][] arr  = new double[6][6];
	
		try {
			Scanner inFile = new Scanner(file);
			
			while(inFile.hasNext()) {
				str = inFile.nextLine();
				strs = str.split(" ");
				currentStore = new double[strs.length];
				for(int i = 0; i < strs.length; i++)
					currentStore[i] = Double.parseDouble(strs[i]);
				arr[row] = currentStore;
				row++;
			}
			inFile.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static void writeToFile(double[][] arr, File file) {
		try{
			PrintWriter outFile = new PrintWriter(file);
			
			for(int i = 0; i < arr.length; i++) {
				for(int k = 0; k < arr[i].length; k++)
					outFile.print(arr[i][k] + " ");
				outFile.println();
			}
			outFile.close();
		}catch(IOException e) {
			System.out.println("Error in writeToFile");
			e.printStackTrace();
		}
	}
	
	public static double getTotal(double[][] arr) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i].length; k++)
				sum += arr[i][k];
		}
		return sum;
	}
	
	public static double getAverage(double[][] arr) {
		double sum = 0;
		double num = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i].length; k++) {
				sum += arr[i][k];
				num++;
			}
		}
		return sum/num;
	}
	
	public static double getRowTotal(double[][] arr, int row) {
		double sum = 0;
		for(int i = 0; i < arr[row].length; i++) {
			sum += arr[row][i];
		}
		return sum;
	}
	
	public static double getColumnTotal(double[][] arr, int column) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++) 
			if(arr[i].length-1 >= column) sum += arr[i][column];
		return sum;
	}
	
	public static double getHighestInRow(double[][] arr, int row) {
		double max = arr[row][0];
		for(int i = 1; i < arr[row].length; i++) 
			if(max < arr[row][i]) max = arr[row][i];
		return max;
	}
	
	public static int  getHighestInRowIndex(double[][] arr, int row) {
		int  index = 0;
		for(int i = 1; i < arr[row].length; i++) 
			if(arr[row][index] < arr[row][i]) index = i;
		return index;
	}
	
	public static double getLowestInRow(double[][] arr, int row) {
		double min = arr[row][0];
		for(int i = 1; i < arr[row].length; i++) 
			if(min > arr[row][i]) min = arr[row][i];
		return min;
	}
	
	public static int  getLowestInRowIndex(double[][] arr, int row) {
		int  index = 0;
		for(int i = 1; i < arr[row].length; i++) 
			if(arr[row][index] > arr[row][i]) index = i;
		return index;
	}
	
	public static double getHighestInColumn(double[][] arr, int column) {
		double max = -999999;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column) 
				if(arr[i][column] > max) max = arr[i][column];
		}
		return max;
	}
	
	public static int getHighestInColumnIndex(double[][] arr, int column) {
		double max = -999999;
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column) { 
				if(arr[i][column] > max) {
					max = arr[i][column];
					index = i;
				}
			}
		}
		return index;
	}
	
	public static double getLowestInColumn(double[][] arr, int column) {
		double min = 0;
		int startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column) {
				min = arr[i][column];
				startingIndex = i;
				break;
			}
		}
		for(int i = startingIndex; i < arr.length; i++) {
			if(arr[i].length-1 >= column) 
				if(arr[i][column] < min) min = arr[i][column];
		}
		return min;
	}
	
	public static int getLowestInColumnIndex(double[][] arr, int column) {
		double min = 0;
		int index = 0;
		int startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column) {
				min = arr[i][column];
				startingIndex = i;
				index = i;
				break;
			}
		}
		for(int i = startingIndex; i < arr.length; i++) {
			if(arr[i].length-1 >= column) 
				if(arr[i][column] < min) {
					min = arr[i][column];
					index = i;
				}
		}
		return index;
	}
	
	public static double getHighestInArray(double[][] arr) {
		double max = -9999;
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i].length; k++)
				if(arr[i][k] > max) max = arr[i][k];
		}
		return max;
	}
	
	public static double getLowestInArray(double[][] arr) {
		double min = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i].length; k++)
				if(arr[i][k] < min) min = arr[i][k];
		}
		return min;
	}
	
	public static double getLowestInColumnPositive(double[][] arr, int column){
		double min = -1;
		int startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column && arr[i][column] > 0) {
				min = arr[i][column];
				startingIndex = i;
				break;
			}
		}
		for(int i = startingIndex; i < arr.length; i++) {
			if(arr[i].length-1 >= column) 
				if(arr[i][column] < min && arr[i][column] > 0) min = arr[i][column];
		}
		return min;
	}
	
	public static int getLowestInColumnPositiveIndex(double[][] arr, int column){
		double min = 0;
		int index = -1;
		int startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length-1 >= column && arr[i][column] > 0) {
				min = arr[i][column];
				startingIndex = i;
				index = i;
				break;
			}
		}
		for(int i = startingIndex; i < arr.length; i++) {
			if(arr[i].length-1 >= column) 
				if(arr[i][column] < min && arr[i][column] > 0) {
					min = arr[i][column];
					index = i;
				}
		}
		return index;
	}
}