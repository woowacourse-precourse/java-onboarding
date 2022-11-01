package onboarding;

public class Problem4 {
	public static final int UPPER_MIN_VALUE = 'A';
	public static final int UPPER_MAX_VALUE = 'Z';
	public static final int LOWER_MIN_VALUE = 'a';
	public static final int LOWER_MAX_VALUE = 'z';
	
    public static String solution(String word) {
        String answer = "";
        
        int asciiCode;
		int reverseAsciiCode;
		
		char[] wordToChar = word.toCharArray();
		char[] changeWordArray = new char[wordToChar.length];
		
		for (int i = 0; i < wordToChar.length; i++) {
			asciiCode = wordToChar[i];
			
			if(Character.isUpperCase(wordToChar[i])) {
				reverseAsciiCode = UPPER_MAX_VALUE + UPPER_MIN_VALUE - asciiCode;
			} else if (Character.isLowerCase(wordToChar[i])) {
				reverseAsciiCode = LOWER_MAX_VALUE + LOWER_MIN_VALUE - asciiCode;
			} else {
				reverseAsciiCode = asciiCode;
			}
			
			char reverseWord = (char) reverseAsciiCode;
			changeWordArray[i] = reverseWord;
		}
		
		answer = new String(changeWordArray);
		
        return answer;
    }
}
