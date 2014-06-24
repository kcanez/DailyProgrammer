import java.util.*;

public class router
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int numNodes;
		numNodes = scan.nextInt();
		scan.nextLine();
		int[][] distanceMatrix = new int[numNodes][numNodes];
		String tempInput;
		String inputArray[];
		
		for(int i = 0; i < numNodes; i++)
		{
			tempInput = scan.nextLine();
			inputArray = tempInput.split(",");
					
			for(int j = 0; j < numNodes; j++)
			{
				distanceMatrix[i][j] = Integer.parseInt(inputArray[j]);
			}
		}
		
		tempInput = scan.nextLine();
		inputArray = tempInput.split(" ");		
		
		System.out.println(shortestPath(numNodes, distanceMatrix, inputArray[0].charAt(0), inputArray[1].charAt(0)));
	}
	
	public static String shortestPath(int n, int[][] distMatrix, char start, char end)
	{
		int sNode = Character.getNumericValue(start) - 9;
		int eNode = Character.getNumericValue(end) - 9;
		char[][] prev = new char[n][n];
		int[][] dist = new int[n][n];
		String shortPath = "";
		
		/*
		 * Bed Time
		 * To Do:
		 * 
		 * Impliment Dijkstra here
		 * 
		 */
		
		return Integer.toString(sNode);
	}
	
}


