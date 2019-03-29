import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.util.Scanner;
/*
	Class WordList
	
	The WordList class is very simple, but at the same
	time there is some complexity to it. 
	
	Everything important happens in the constructor. 
	The constructor gets the filename to be opened as a 
	parameter, and opens the file. Then it proceeds to 
	read the file line by line, adding every line/word
	to the list-ArrayList.
	
	Method giveWords returns the list in full.

*/

class WordList{
	
	private ArrayList <String> list = new ArrayList <String> ();
	
	public WordList(String filename){
		
		File file = new File(filename);
		try{
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()){
				this.list.add(readFile.nextLine());
			}
			readFile.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList <String> giveWords(){
		return list;
	}
}