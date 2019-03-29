import java.io.*;
import java.util.Scanner;
/*
	HangmanMain
	
	The main program for the hangman game.	
	First the program initializes the wordlist and hangman object.
	Then it proceeds to the main loop of the program. The loop only
	ends if hangman.theEnd returns true.
	
	In the loop the user is asked to input a guess. The guess is
	then compared at the hangman.guess method, and the return value
	then is used to print the applicable message.
	
	After the while loop ends, there is one more check, win, to see
	if the user won the game or not.
*/

public class HangmanMain{
	
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String [] args){
		
		String filename = "words.txt";
		int guessCount = 5;
		char guessedChar;
		
		WordList list = new WordList(filename);
		Hangman hangman = new Hangman(list.giveWords(), guessCount);
		
		System.out.print("\nTime to play Hangman!\n");
		
		while(!hangman.theEnd()){
			
			System.out.print("\nGuesses so far: " + hangman.guesses() + "\n");
			System.out.print("Guesses left: " + hangman.getGuessCount() + "\n");
			System.out.print("Guess a character: ");
			guessedChar = input.next().charAt(0);
			if(hangman.guess(guessedChar)){
				System.out.print("\nCorrect!\n");
			}else{
				System.out.print("\nWrong! \n");
			}	
		}
		
		if(hangman.win()){
			System.out.print("\n*****You won!*****\n");
		}else{
			System.out.print("\n*****You lost*****\n");
		}
		
		System.out.print("The correct word was: " + hangman.getChosenWord() + "\n");
		
	}

}