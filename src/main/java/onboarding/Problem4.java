package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
    	StringBuilder answerBuilder = new StringBuilder();
		HashMap<Character, Character> frogUpperCase = new HashMap<>(26);
		frogUpperCase.put('A','Z'); frogUpperCase.put('B','Y');
		frogUpperCase.put('C','X'); frogUpperCase.put('D','W');
		frogUpperCase.put('E','V'); frogUpperCase.put('F','U');
		frogUpperCase.put('G','T'); frogUpperCase.put('H','S');
		frogUpperCase.put('I','R'); frogUpperCase.put('J','Q');
		frogUpperCase.put('K','P'); frogUpperCase.put('L','O');
		frogUpperCase.put('M','N'); frogUpperCase.put('N','M');
		frogUpperCase.put('O','L'); frogUpperCase.put('P','K');
		frogUpperCase.put('Q','J'); frogUpperCase.put('R','I');
		frogUpperCase.put('S','H'); frogUpperCase.put('T','G');
		frogUpperCase.put('U','F'); frogUpperCase.put('V','E');
		frogUpperCase.put('W','D'); frogUpperCase.put('X','C');
		frogUpperCase.put('Y','B'); frogUpperCase.put('Z','A');
		char[] wordArray = word.toCharArray();
		for(int i=0; i<word.length(); i++) {
			if(wordArray[i]==' ') {
				answerBuilder.append(" ");
			} else if(frogUpperCase.containsKey(wordArray[i])) {
				answerBuilder.append(frogUpperCase.get(wordArray[i]));
			} else {
				char upperword=Character.toUpperCase(wordArray[i]);
				char frogLowerCase = frogUpperCase.get(upperword);
				frogLowerCase = Character.toLowerCase(frogLowerCase);
				answerBuilder.append(frogLowerCase);
				}
			}
		String answer = answerBuilder.toString();
		return answer;		
	}
}
