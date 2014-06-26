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
		int sNode = Character.getNumericValue(start) - 10;
		int eNode = Character.getNumericValue(end) - 10;
		char[][] prev = new char[n][n];
		double[][] dist = new double[n][n];
		String shortPath = "";
		String alphabet = "ABCDEFHIJKLMNOPQRSTUVWXYZ";
		String tempList = alphabet.substring(0, n);
		char[] nodeList = tempList.toCharArray();
		char[] nodesPassed = new char[n];
		boolean stillLooking = true;
		
		//Dijkstra initialization
		
		// Wow, this code is garbage... scrap & restart time!
		for(int i = 0; i < n; i++)
		{
			if(distMatrix[sNode][i] == -1)
				dist[sNode][i] = Double.POSITIVE_INFINITY;
			else
			{
				dist[sNode][i] = distMatrix[sNode][i];
				prev[sNode][i] = start;
			}
		}
		
		
		nodeList[sNode] = ' ';
		nodesPassed[0] = start;
		
		int count = 0;
		int minIndex = 0;
		while(!stillLooking)
		{
			
			for(int i = 0; i < n; i ++)
			{
				if(dist[count][minIndex] > dist[count][i])
					minIndex = i;
			}
			count++;
			
			nodesPassed[count] = nodeList[minIndex];
			nodeList[minIndex] = ' ';
			
			for(int i = 0; i < n; i++)
			{
				if((dist[count-1][i] > (dist[count-1][minIndex] + distMatrix[minIndex][i])) && distMatrix[minIndex][i] >= 0)
				{
					dist[count][i] = dist[count-1][minIndex] + distMatrix[minIndex][i];
					prev[count][]
				}
				else
				{
					dist[count][i] = dist[count-1][i];
				}
			}
			
		}
		
		return Integer.toString(sNode);
	}
	
}


