import java.util.StringTokenizer;
import java.util.LinkedList;

public class Spreadsheet 
{
	public static void main(String args[])
	{
		String tempTest[] = getCords("B1:B3&B4:E10&F1:G1~C5:C8");
	}
	
	
	public static String[] getCords(String input)
	{
		StringTokenizer st = new StringTokenizer(input, "~");
		StringTokenizer middle;
		String selection = st.nextToken();
		String rmvSelection = st.nextToken();
		LinkedList<String> coords = new LinkedList<String>();
		st = new StringTokenizer(selection, "&");
		int iStart, iEnd, jStart, jEnd;
		String sel = " ";
		
		while(st.hasMoreTokens())
		{
			sel = st.nextToken();
			
			middle = new StringTokenizer(sel, ":");
			sel = middle.nextToken();
			
			iStart = (int)sel.charAt(0) - 65;
			jStart = Integer.parseInt(sel.substring(1, sel.length()));
			
			sel = middle.nextToken();
			
			iEnd = (int)sel.charAt(0) - 65;
			jEnd = Integer.parseInt(sel.substring(1, sel.length()));
			
			//System.out.println("iStart: " + iStart + "\njStart: " + jStart);
			//System.out.println("iEnd: " + iEnd + "\njEnd: " + jEnd);
			
			for(int i = iStart; i <= iEnd;i++)
			{
				for(int j = jStart; j <= jEnd;j++)
				{
					if(!coords.contains(i + ", " + j))
						coords.add(i + ", " + j);
				}
			}
				
			
		}
		
		
		
		System.out.println(coords.toArray());

		
		
		
		String s[] = {" "};
		return s;
	}

}
