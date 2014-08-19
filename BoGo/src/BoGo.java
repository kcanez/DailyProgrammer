import java.util.LinkedList;
import java.util.Random;

public class BoGo 
{
	public static void main(String args[])
	{
		String randChar = args[0];
		String sortedChars = args[1];

		System.out.println(BoGoSort(randChar, sortedChars));
	}
	
	public static int BoGoSort(String start, String end)
	{
		String rChar = start;
		int iter = 0;
		int wordLength = rChar.length();
		
		while(!end.equals(rChar))
		{
			rChar = wordShuffle(rChar,wordLength);
			iter++;
			System.out.println(iter + ": " + rChar);
		}
		
		return iter;
	}
	
	public static String wordShuffle(String word, int wLen)
	{
		String newWord = "";
		LinkedList<Character> lettersLeft = new LinkedList<Character>();
		int i = 0;
		Random rn = new Random();
		
		while(i < wLen)
		{
			lettersLeft.add(word.charAt(i));
			i++;
		}
		
		while(!lettersLeft.isEmpty())
		{
			newWord = newWord.concat(lettersLeft.remove(rn.nextInt(lettersLeft.size())).toString());
		}
		
		return newWord;
	}
}
