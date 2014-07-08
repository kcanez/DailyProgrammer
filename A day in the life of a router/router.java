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
		int currNode = Character.getNumericValue(start)-10;
		int eNode = Character.getNumericValue(end)-10; 
		char[] prev = new char[n];
		double[] dist = new double[n];
		String shortPath = "";
		String alphabet = "ABCDEFHIJKLMNOPQRSTUVWXYZ";
		String tempList = alphabet.substring(0, n);
		char[] nodeList = tempList.toCharArray();
		Stack nodeStack = new Stack();
		Stack distStack = new Stack();
		Stack prevStack = new Stack();
		boolean stillLooking = true;
		
		dist[currNode] = 0;
		
		//Dijkstra initialization
		
		
		for(int i = 0; i < n; i++)
		{
			if(distMatrix[currNode][i] == -1)
			{
				if(currNode == i)
				{
					dist[i] = 0;
					prev[i] = '.';
				}
				else
					dist[i] = Double.POSITIVE_INFINITY;
			}
			else
			{
				dist[i] = distMatrix[currNode][i];
				prev[i] = start;
			}
		}
		
		//System.out.println("Init \ndist: " + Arrays.toString(dist) + "\nprev "  + Arrays.toString(prev) + "EndInit\n\n");	
		
		nodeStack.push(nodeList[currNode]);
		distStack.push(dist[currNode]);
		prevStack.push(prev[currNode]);
		
		int minIndex = 0;
		
		// Loop to set Stacks
		
		while(nodeStack.size() < n)
		{
			//get min index
			for(int i = 0; i < n; i++)
			{
				if((dist[minIndex] > dist[i]) || dist[minIndex] <= 0)
					minIndex = i;
			}
			System.out.println("Min Index: " + minIndex);
			System.out.println("dist: " + Arrays.toString(dist) + "\nprev "  + Arrays.toString(prev));
			
			
			currNode = minIndex; 
			//System.out.println("\n" + nodeList[currNode] + "\n");
			
			nodeStack.push(nodeList[currNode]);
			distStack.push(dist[currNode]);
			prevStack.push(prev[currNode]);
			
			//System.out.println("nodeStack: " + nodeList[currNode] + "\n" +
			//					"distStack: " + dist[currNode] + "\n" +
			//					"prevStack: " + prev[currNode] + "\n\n");
			
			// update arrays
			dist[currNode] = 0;
			prev[currNode] = '.';
			
			// update 
			
			for(int i = 0; i < n; i++)
			{
				if(distMatrix[currNode][i] > 0 && distMatrix[currNode][i] < dist[i])
				{
						dist[i] = (Double) distStack.peek() + distMatrix[currNode][i];
						prev[i] = nodeList[i];
				}

			}
		}
		
		String pathOutput = "";
		char currentCharacter = end;
		
		while(nodeStack.peek().toString().charAt(0) != start)
		{
			
			if(nodeStack.peek().toString().charAt(0) == currentCharacter)
			{
				pathOutput = pathOutput + nodeStack.pop() + " ";
				currentCharacter = prevStack.pop().toString().charAt(0);
			}
			else
			{
				nodeStack.pop();
				prevStack.pop();
			}
	
		}
		
		pathOutput = pathOutput + start + "";
		
			
		
		//System.out.println(nodeStack.size());
		
		return pathOutput;
	}
	
}





/*
 
 
5
-1,5,10,-1,-1
5,-1,-1,1,-1
10,-1,-1,3,1
-1,1,3,-1,10
-1,-1,1,10,-1
A C
 
 
 * */

