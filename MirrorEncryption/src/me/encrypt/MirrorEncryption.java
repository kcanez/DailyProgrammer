package me.encrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MirrorEncryption 
{
	public static char[][] matrix = new char[15][15];

	public static void main(String[] args) 
	{
		try 
		{
			getMatrix();
			
			
			
			
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
	
	public static void getMatrix() throws IOException
	{
		String top = "abcdefghijklm"; // top matrix[0][1]
		String left = "ABCDEFGHIJKLM"; // left matrix[1][0]
		String right = "NOPQRSTUVWXYZ";
		String bottom = "nopqrstuvwxyz";
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
	            for(int i = 1; i < line.length();i++)
	            {
	            	matrix[j][i] = line.charAt(i);
	            }
	            j++;
        }
		
        br.close();
        
		
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
