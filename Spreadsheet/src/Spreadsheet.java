import java.util.StringTokenizer;
import java.util.LinkedList;

public class Spreadsheet 
{
	public static void main(String args[])
	{
		LinkedList<String> tempTest = getCords("B1:B3&B4:E10&F1:G1&F4~C5:C8&B2");
		
		System.out.println(tempTest.size());
		
		for(int i = 0; i < tempTest.size(); i++)
			System.out.println(tempTest.get(i));
	}
	
	
	public static LinkedList<String> getCords(String input)
	{
		StringTokenizer st = new StringTokenizer(input, "~");
		StringTokenizer middle;
		String selection = st.nextToken();
		String rmvSelection = st.nextToken();
		LinkedList<String> coords = new LinkedList<String>();
		st = new StringTokenizer(selection, "&");
		int iStart, iEnd, jStart, jEnd;
		String sel = " ";
		
		// ADD CELLS //
		
		while(st.hasMoreTokens())
		{
			sel = st.nextToken();
			
			middle = new StringTokenizer(sel, ":");
			
			
			if(middle.countTokens() > 1)
			{
				sel = middle.nextToken();
				iStart = (int)sel.charAt(0) - 65;
				jStart = Integer.parseInt(sel.substring(1, sel.length())) - 1;
			
				sel = middle.nextToken();
				iEnd = (int)sel.charAt(0) - 65;
				jEnd = Integer.parseInt(sel.substring(1, sel.length())) - 1;

				for(int i = iStart; i <= iEnd;i++)
				{
					for(int j = jStart; j <= jEnd;j++)
					{
						if(!coords.contains(i + ", " + j))
						{
							coords.add(i + ", " + j);
							//System.out.println(i + ", " + j);
						}
					}
				}	
			}
			else
			{
				sel = middle.nextToken();
				iStart = (int)sel.charAt(0) - 65;
				jStart = Integer.parseInt(sel.substring(1, sel.length())) - 1;
				
				if(!coords.contains(iStart + ", " + jStart))
				{
					coords.add(iStart + ", " + jStart);
					//System.out.println(iStart + ", " + jStart);
				}
			}
		}
			
		// REMOVE CELLS //
		
		st = new StringTokenizer(rmvSelection, "&");
		
		while(st.hasMoreTokens())
		{
			sel = st.nextToken();
			
			middle = new StringTokenizer(sel, ":");
			
			
			if(middle.countTokens() > 1)
			{
				sel = middle.nextToken();
				iStart = (int)sel.charAt(0) - 65;
				jStart = Integer.parseInt(sel.substring(1, sel.length())) - 1;
			
				sel = middle.nextToken();
				iEnd = (int)sel.charAt(0) - 65;
				jEnd = Integer.parseInt(sel.substring(1, sel.length())) - 1;

				for(int i = iStart; i <= iEnd;i++)
				{
					for(int j = jStart; j <= jEnd;j++)
					{
						if(coords.contains(i + ", " + j))
						{
							coords.remove(i + ", " + j);
						}
					}
				}	
			}
			else
			{
				sel = middle.nextToken();
				iStart = (int)sel.charAt(0) - 65;
				jStart = Integer.parseInt(sel.substring(1, sel.length())) - 1;
				
				if(coords.contains(iStart + ", " + jStart))
				{
					coords.remove(iStart + ", " + jStart);
				}
			}
		}
				
		return coords;
	}

}
