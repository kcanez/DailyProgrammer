package me.encrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LocalME 
{
	public static char[][] matrix = new char[15][15];
	public static String top = "abcdefghijklm"; // top matrix[0][1]
	public static String left = "ABCDEFGHIJKLM"; // left matrix[1][0]
	public static String bottom = "NOPQRSTUVWXYZ";
	public static String right = "nopqrstuvwxyz";
	public static String startingLocation = "";
	

	public static void main(String[] args) 
	{
		try 
		{
			getMatrix();
			String startText = "Pliny The Elder";
			String endText = "";
			int currX, currY, offX, offY;
			int[][] coordsAndOff = new int[1][4];
			
			for(int i = 0; i < startText.length();i++)
			{
				coordsAndOff = setStartingPoint(startText.charAt(i));
				currX = coordsAndOff[0][0];
				currY = coordsAndOff[0][1];
				offX = coordsAndOff[0][2];
				offY = coordsAndOff[0][3];
				endText += Move(currX, currY, offX, offY);
				//System.out.println(endText);
			}
			System.out.println(endText);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	public static void printMatrix(int cX, int cY)
	{
		
		char[][] tempMatrix = new char[15][15];
		
		for(int i=0; i<matrix.length; i++)
			  for(int j=0; j<matrix[i].length; j++)
			    tempMatrix[i][j]=matrix[i][j];
		
		tempMatrix[cX][cY] = '*';
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < tempMatrix.length; i++)
		{
			for(int y = 0; y < tempMatrix.length;y++)
			{
				System.out.print(tempMatrix[i][y]);		
			}
			System.out.println("");
		}
		
	}
	
	public static char getLetter(int row, int col)
	{
		return matrix[row][col];
	}
	
	public static int[][] setStartingPoint(char charToFind)
	{
		// you could instanciate the starting coords array here and just have the method return int[][]
		int[][] startingCoords = new int[1][4];
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
		
		return startingCoords;
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
	            	//System.out.println(i);
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
	
	
	
	public static char Move(int x, int y, int rOff, int cOff)
    {
		int currentRow = x;
		int currentCol = y;
		int colOffset = cOff;
		int rowOffset = rOff;
		int asciiOfCurr;
		
		
		
		do
		{
		printMatrix(currentRow,currentCol);
		asciiOfCurr = getLetter(currentRow,currentCol);	
		//System.out.println(asciiOfCurr);
		//System.out.println(currentRow + ", " + currentCol + ", " + rowOffset + ", " + colOffset);
    	if(asciiOfCurr == 47)  // check for '/'
    	{
    		//System.out.println("found /");
    		if(rowOffset == 1) // if moving down and you encounter / move left
    		{
    			//System.out.println("1");
    			rowOffset = 0;
    			colOffset = -1;
    			currentRow += rowOffset;
    			currentCol += colOffset;
    		}
    		else if(rowOffset == -1) // if moving down and encounter / move right
    		{
    			//System.out.println("2");
    			rowOffset = 0;
    			colOffset = 1;
    			currentRow += rowOffset;
    			currentCol += colOffset;
    		}
    		else if(colOffset == 1) // if moving right and encounter / move up
    		{
    			//System.out.println("3");
    			rowOffset = -1;
    			colOffset = 0;
    			currentRow += rowOffset;
    			currentCol += colOffset;
    		}
    		else if(colOffset == -1) // if moving left and encounter / move down
    		{
    			//System.out.println("4");
    			rowOffset = 1;
    			colOffset = 0;
    			currentRow += rowOffset;
    			currentCol += colOffset;
   			}
    	}
    	
    	else if(asciiOfCurr == 92) // check for '\'
    	{
			//System.out.println("found \\");
    		if(rowOffset == 1) // if moving down and encounter \ move right
    		{
    			rowOffset = 0;
    			colOffset = 1;
    			currentRow += rowOffset;
    			currentCol += colOffset;
    		}
    		else if(rowOffset == -1) // if moving up and encounter \ move left
   			{
    			rowOffset = 0;
    			colOffset = -1;
    			currentRow += rowOffset;
    			currentCol += colOffset;
   			}
   			else if(colOffset == 1)  // if right and encounter \ move down
   			{
   				rowOffset = 1;
   				colOffset = 0;
    			currentRow += rowOffset;
    			currentCol += colOffset;
   			}
   			else if(colOffset == -1) // if moving left and encounter \ move up
    		{
   				rowOffset = -1;
   				colOffset = 0;
    			currentRow += rowOffset;
    			currentCol += colOffset;
   			}
   		}
    	else
    	{
    		//System.out.println("entered Else");
			currentRow += rowOffset;
			currentCol += colOffset;
   		}
    	//System.out.println(currentRow + ", " + currentCol + ", " + rowOffset + ", " + colOffset);
		}
    	while(!(currentRow == 14 || currentCol == 14 || currentRow == 0 || currentCol == 0));
   			
   			
   			
    	return getLetter(currentRow, currentCol);
			
    }
    
    public static void readFile(String input) throws IOException 
    {
    	BufferedReader br = new BufferedReader(new FileReader(input));
    	try
    	{
    		StringBuilder sb = new StringBuilder();
    		String line = br.readLine();
    		
    		while (line != null){
    			sb.append(line);
    			sb.append("\n");
    			line = br.readLine();
    		}
    		sb.toString();
    		System.out.println(sb);
    	} finally {
    		br.close();
    	}
    }

}
