import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collection;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Wordle {
	static String newWord="";
	static String [] gameWord;
	static Scanner scan = new Scanner(System.in);
	static String guess= "";
	static String [] guessArray;
	static String guessTracking="";
	static String wordReturn="";
	static ArrayList<String> posWords = new ArrayList<String>();
	static int length;
	static boolean won= false;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
			System.out.println("Welcome to Wordle! Please type how long you want your word to be!");
			length = scan.nextInt();
			gameWord = new String[length];
			guessArray= new String[length];
			wordAdder();
			int rand =(int)(Math.random()*posWords.size());
			
			newWord = posWords.get(rand);
			
		createArray();
		
		gamePlay();
		
		if(!won) {
			System.out.println("You lost! the word was "+newWord);
		}
		
		
	}
	   
	

	
	
	
	public static void createArray()//create the array for the word
	{
		
		for(int i=0; i< newWord.length(); i++)
		{
			gameWord[i]= newWord.substring(i, i+1);
		}
	
	   System.out.println("Your game is ready!");
	   System.out.println("");
	}
	
	public  static void gamePlay()
	{
		System.out.println("You will have 2 times the length of the word you selected in tries to guess the word!");
		System.out.println("The game will return an x if it is not in the word, - if it is the wrong spot, and return the letter if it is a corect guess");
		 String waste= scan.nextLine();
		
	
		for(int x=0; x<newWord.length()*2; x++)//the game play
		{
			guess =scan.nextLine();
			
		   for(int y=0;y<guess.length();y++)// making the array to check
		   {
			   guessArray[y]= guess.substring(y, y+1);
		   }
		   
		   for(int z= 0; z< guess.length(); z++)
		   {
			   if(guessArray[z].equals(gameWord[z]))//if its correct
			   {
				  guessArray[z]= guessArray[z]; 
			   }
			   else// wrong spot
			   {
				   guessTracking= guessArray[z];
				   for(int s= 0; s<guess.length(); s++)
				   {
					   if(gameWord[s].equals(guessTracking))
						   {guessArray[z]="-";
						   	break;}
					   
					   else
						   guessArray[z]="X";//not in the word
				   }
			   }
		   }
		   wordReturn="";
		   for(int d=0; d<guess.length(); d++)
			{
				wordReturn+=guessArray[d];
			}
			System.out.println(wordReturn);
			if(wordReturn.equals(newWord)) {
				System.out.println("You win!! the word was "+newWord);
				won=true;
				break;		
			}
		}
	}
	
	public static void wordAdder()
	{
		try {
		File site= new File("/Users/bellabravo/Desktop/words.txt");
	    Scanner wordScan= new Scanner(site);
	    

			while(wordScan.hasNextLine()) 
			{
				String temp = wordScan.nextLine();
				if(temp.length()== length) 	
				{
					posWords.add(temp);
				}

					
			}
		}

			catch(Exception ex) {
				ex.printStackTrace();
			}
	    
	}
	
		
			
			
			
			

		}
			
			
			
		
		
		
		
		
		
		
		
	
	
	
	
	


