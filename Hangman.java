import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
/*
	Class Hangman
	
	This class is where the base game-mechanics happen.
	The constructor gets the list of words and the guess
	count as parameters.
	
	Chosenword is then randomly selected from the list.
	The size of this word is also stored in the wordSize string.

	There is also a list for the correctly guessed characters,
	guessList. It is filled with the character "_" ín the
	constructor.
	
	The guess method gets the users guessed character as a parameter,
	and combs through the word to see if it is found. If found, it
	adds the character to the guesslist, and returns true. If not
	found, the return if false and one guess is removed from the guess-
	counter.
	
	The guesses method return the word with "_" in place of the characters
	not yet found.
	
	Method theEnd checks if the user is out of guesses, or if the user
	has won the game. This is done in the win method. If the guessList
	doesnt contain any "_" characters, it returns true.
*/

class Hangman{
	
	private int guessCount;
	private String chosenWord;
	private int wordSize;
	private List <Character> guessList = new ArrayList <Character>();

	public Hangman(ArrayList <String> list, int guessCount){
		
		this.guessCount = guessCount;
		Random rand = new Random();
		int randomNumber = rand.nextInt(list.size());
		chosenWord = list.get(randomNumber);
		wordSize = chosenWord.length();
		for(int i = 0; i < wordSize; i++){
			guessList.add('_');
		}
	}
	
	public void setChosenWord(String chosenWord){
		this.chosenWord = chosenWord;
	}
	public String getChosenWord(){
		return chosenWord;
	}
	
	public void setguessCount(int guessCount){
		this.guessCount = guessCount;
	}
	public int getGuessCount(){
		return guessCount;
	}
	
	public void setWordSize(int wordSize){
		this.wordSize = wordSize;
	}
	public int getWordSize(){
		return wordSize;
	}
	
	public boolean guess(char guessedChar){
		
		boolean charFound = false;
		int i = 0;
		
		while(i < wordSize){
			if(chosenWord.charAt(i) == guessedChar){
				charFound = true;
				guessList.set(i, guessedChar);
			}
			i++;
		}
		
		if(charFound){
			return true;
		}else{
			guessCount--;
			return false;
		}
	}
	
	public List <Character> guesses(){
		return guessList;
	}

	public boolean theEnd(){
		if(win() || guessCount == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean win(){
		if(!(guessList.toString().contains("_"))){
			return true;
		}else{
			return false;
		}
	}
}