/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Hangman extends ConsoleProgram {

	/***********************************************************
	 *              CONSTANTS                                  *
	 ***********************************************************/
	
	/* The number of guesses in one game of Hangman */
	private static final int N_GUESSES = 7;
	/* The width and the height to make the karel image */
	private static final int KAREL_SIZE = 150;
	/* The y-location to display karel */
	private static final int KAREL_Y = 230;
	/* The width and the height to make the parachute������ɡ�� image */
	private static final int PARACHUTE_WIDTH = 300;
	private static final int PARACHUTE_HEIGHT = 130;
	/* The y-location to display the parachute */
	private static final int PARACHUTE_Y = 50;
	/* The y-location to display the partially guessed string */
	private static final int PARTIALLY_GUESSED_Y = 430;
	/* The y-location to display the incorrectly guessed letters */
	private static final int INCORRECT_GUESSES_Y = 460;
	/* The fonts of both labels */
	private static final String PARTIALLY_GUESSED_FONT = "Courier-36";
	private static final String INCORRECT_GUESSES_FONT = "Courier-26";
	
	/***********************************************************
	 *              Instance Variables                         *
	 ***********************************************************/
	
	/* An object that can produce pseudo (�ٵ�)  random numbers */
	private RandomGenerator rg = new RandomGenerator();
	
	private GCanvas canvas = new GCanvas();
	
	/***********************************************************
	 *                    Methods                              *
	 ***********************************************************/
	private static final Image image2 = MediaTools.loadImage("Karel.png");
	private static final Image image3 = MediaTools.loadImage("KarelFlipped.png");
	private static final GImage Karel = new GImage(image2);
	private static final GImage KarelFlipped = new GImage(image3);
	private static final GLine line1 = new GLine(100, 180, 200, 230);
	private static final GLine line2 = new GLine(200, 180, 200, 230);
	private static final GLine line3 = new GLine(300, 180, 200, 230);
	public void init() {
		add(canvas);
		Image image1 = MediaTools.loadImage("background.jpg");
		Image image4 = MediaTools.loadImage("parachute.png");
		GImage background = new GImage(image1);
		GImage parachute = new GImage(image4);
		Karel.setSize(KAREL_SIZE, KAREL_SIZE);
		KarelFlipped.setSize(KAREL_SIZE, KAREL_SIZE);
		parachute.setSize(PARACHUTE_WIDTH, PARACHUTE_HEIGHT);
		canvas.add(background);
		canvas.add(parachute, canvas.getWidth() / 2, PARACHUTE_Y);
		canvas.add(Karel, 130, KAREL_Y);
		canvas.add(line1);
		canvas.add(line2);
		canvas.add(line3);
	}
	
	public void run() {
		setSize(800, 500);
		playGame();
	}
	
	/**
	 * Method: Get Random Word
	 * -------------------------
	 * This method returns a word to use in the hangman game. It randomly 
	 * selects from among 10 choices.
	 */
	private String getRandomWord() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			File myFile = new File("ShorterLexicon.txt");
			FileInputStream fileReader = new FileInputStream(myFile);
			InputStreamReader isr = new InputStreamReader(fileReader, "utf-8");
			
			BufferedReader reader = new BufferedReader(isr);
			
			String line = null;
			while((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int index = rg.nextInt(10);
		return words.get(index);
//		if(index == 0) return "BUOY";
//		if(index == 1) return "COMPUTER";
//		if(index == 2) return "CONNOISSEUR";
//		if(index == 3) return "DEHYDRATE";
//		if(index == 4) return "FUZZY";
//		if(index == 5) return "HUBBUB";
//		if(index == 6) return "KEYHOLE";
//		if(index == 7) return "QUAGMIRE";
//		if(index == 8) return "SLITHER";
//		if(index == 9) return "ZIRCON";
//		throw new ErrorException("getWord: Illegal index");
	}
	
	private void playGame() {
		println("Welcome to Hangman");
		String word = getRandomWord();
		play(word);
	}
	
	private void play(String word) {
		int allGuesses = countGuesses(word);
		String guessWord = "";
		for(int i = 0; i < allGuesses; i++) {
			guessWord += "_"; 
		}
		String enterChars = "";
		GLabel partiallyGuessed = new GLabel(guessWord);
		GLabel incorrectlyGuessed = new GLabel(enterChars);
		partiallyGuessed.setFont(PARTIALLY_GUESSED_FONT);
		incorrectlyGuessed.setFont(INCORRECT_GUESSES_FONT);
		// �����205�Ǽ�������ģ�������ɡ��karel�����ߵĺ�����
		canvas.add(partiallyGuessed, 205 - partiallyGuessed.getWidth() / 2, PARTIALLY_GUESSED_Y);
		canvas.add(incorrectlyGuessed, 205 - incorrectlyGuessed.getWidth() / 2, INCORRECT_GUESSES_Y);
		while(allGuesses != 0) {
			print("Your word now looks like this:");
			// ��ӡ�Ѿ��²��������ĸ��û�в³���������Ȼ�� _ ���档
			printWordLike(guessWord);
			// ����²�ʣ��Ĵ���
			coutGuessesLeft(allGuesses);
			print("You guess: ");
			char enterChar = playerEnter();
			// �����������ַ��ӵ�������ʾ���ַ�����
			enterChars = enterChars + enterChar;
			incorrectlyGuessed.setLabel(enterChars);
			// ����GLabel��λ��
			canvas.add(incorrectlyGuessed, 205 - incorrectlyGuessed.getWidth()/2, INCORRECT_GUESSES_Y);
			//�ж��Ƿ����
			Boolean isGet = judgeChar(enterChar, word);
			if(isGet) {
				println("The guess is correct.");
				guessWord = changeGuessWord(enterChar, word, guessWord);
				// ���о͸���Karel�����label
				partiallyGuessed.setLabel(guessWord);
			}else {
				println("There are no " + enterChar + "' in the word.");
				allGuesses--;
			}
			// �ж��Ƿ�²�ɹ����ɹ�������ѭ��
			if(judgeWin(guessWord, word)) {
				println("You win");
				println("The word is " + word);
				break;
			}
			
		}
		// ֻ����������ѭ����˵��û�в��У���ӡ��ʾʧ�ܡ�
		if(allGuesses <= 0) {
			println("You are completely hung");
			println("The word is " + word);
			canvas.remove(Karel);
			canvas.remove(line1);
			canvas.remove(line2);
			canvas.remove(line3);
			canvas.add(KarelFlipped, 130, KAREL_Y);
		}
		
	}
	// ���ڼ��㵥�ʳ���
	private int countGuesses(String word) {
		return word.length();
	}
	// ��ӡ���ʣ��ÿո����ÿһ����ĸ��ͬʱ����ͨ�����Ĵ˴���������������ʵ���ʽ
	private void printWordLike(String str) {
		int length = str.length();
		for(int i = 0; i < length; i++) {
			print(str.charAt(i) + " ");
		}
		print("\n");
	}
	// ����ʣ��Ĳ²����
	private void coutGuessesLeft(int a) {
		println("You have " + a + " guesses left.");
	}
	// ��ȡ����������ĸ����������д��ʽ
	private char playerEnter() {
		String guessChar = readLine();
		char charGuessed = guessChar.charAt(0);
		// ת����Сд
		if(charGuessed >= 'a' && charGuessed <= 'z') {
			charGuessed -= 32;
		}
		return charGuessed;
	}
	// �ж�����������ĸ�Ƿ�����ٱ��²ⵥ����
	private Boolean judgeChar(char enterChar, String word) {
		int length = word.length();
		Boolean isHave = false;
		for(int i = 0; i < length; i++) {
			if(word.charAt(i) == enterChar) {
				isHave = true;
			}
		}
		
		return isHave;
	}
    // ���²²���
	private String changeGuessWord(char enterChar, String word, String guessWord) {
		int length = word.length();
		String str = "";
		for(int i = 0; i < length; i++) {
			if(word.charAt(i) == enterChar) {
				str = str + enterChar;
			}else {
				str = str + guessWord.charAt(i);
			}
		}
		
		return str;
	}
	// �ж��Ƿ�´ʳɹ�
	private Boolean judgeWin(String guessWord, String word) {
		if(guessWord.equalsIgnoreCase(word)) {
			return true;
		}else {
			return false;
		}
	}

}
