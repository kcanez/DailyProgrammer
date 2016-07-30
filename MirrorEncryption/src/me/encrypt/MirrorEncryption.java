package me.encrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MirrorEncryption 
{
	public static char[][] matrix = new char[15][15];
	public static String top = "abcdefghijklm"; // top matrix[0][1]
	public static String left = "ABCDEFGHIJKLM"; // left matrix[1][0]
	public static String bottom = "NOPQRSTUVWXYZ";
	public static String right = "nopqrstuvwxyz";
	public static String startingLocation = "";
	public static int[][] startingCoords = new int[1][4];

	public static void main(String[] args) 
	{
		try 
		{
			getMatrix();
			setStartingPoint('a');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			setStartingPoint('b');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			setStartingPoint('c');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			setStartingPoint('n');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			setStartingPoint('Z');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			setStartingPoint(' ');
			System.out.println(startingCoords[0][0] + ", " + startingCoords[0][1] + " " + startingCoords[0][2] + ", " + startingCoords[0][3]);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	public static char getLetter(char startingLetter)
	{
		

		return 'a';
	}
	
	public static char getLetter(int row, int col)
	{
		return matrix[row][col];
	}
	
	public static void setStartingPoint(char charToFind)
	{
		int temp = charToFind;
		
		if(right.indexOf(charToFind) >= 0)
		{
			startingCoords[0][0] =  right.indexOf(charToFind)+1;
			startingCoords[0][1] =  14;
			startingCoords[0][2] = 0;
			startingCoords[0][3] = -1;
		}	
		else if(top.indexOf(charToFind) >= 0)
		{
			startingCoords[0][0] =  0;
			startingCoords[0][1] =  top.indexOf(charToFind)+1;
			startingCoords[0][2] = 1;
			startingCoords[0][3] = 0;
		}
		else if(bottom.indexOf(charToFind) >= 0)
		{
			startingCoords[0][0] =  14;
			startingCoords[0][1] =  bottom.indexOf(charToFind)+1;
			startingCoords[0][2] = -1;
			startingCoords[0][3] = 0;
		}
		else if(left.indexOf(charToFind) >= 0)
		{
			startingCoords[0][0] =  left.indexOf(charToFind)+1;
			startingCoords[0][1] =  0;
			startingCoords[0][2] = 0;
			startingCoords[0][3] = 1;
		}
		else if(temp == 32) // space
		{
			startingCoords[0][0] =  0;
			startingCoords[0][1] =  0;
			startingCoords[0][2] = 0;
			startingCoords[0][3] = 0;
		}
		else
		{
			startingCoords[0][0] =  -1;
			startingCoords[0][1] =  -1;
			startingCoords[0][2] = 0;
			startingCoords[0][3] = 0;
		}
	}
	
	
	public static void getMatrix() throws IOException
	{

		int count = 1;
		
		while(count < 14)
		{
			matrix[0][count] = top.charAt(count-1);
			matrix[14][count] = bottom.charAt(count-1);
			count++;
		}
		
		count = 1;
		while(count < 14)
		{
			matrix[count][0] = left.charAt(count-1);
			matrix[count][14] = right.charAt(count-1);
			count++;
		}
		
		String line;
		int j = 1;
		
        BufferedReader br = new BufferedReader(new FileReader("/Users/ineed/Documents/CodeProjects/Udemy_OOP/src/kcanez/DailyProgrammer/EncryptionMatrix.txt"));
        
        while ((line = br.readLine()) != null) 
        {
	            for(int i = 1; i <= line.length();i++)
	            {
	            	matrix[j][i] = line.charAt(i-1);
	            	System.out.println(i);
	            }
	            j++;
        }
		
        br.close();
        
        matrix[0][0] = ' ';
        
		for(int i = 0; i < matrix.length; i++)
		{
			for(int y = 0; y < matrix.length;y++)
			{
				System.out.print(matrix[i][y]);		
			}
			System.out.println("");
		}

		
	}

}
