package onboarding;

public class Problem4 {
    public static String solution(String word) {
        
        char[] wordArr = word.toCharArray();
		int charInt;
		
		for(int i=0; i < wordArr.length; i++) {
			charInt = wordArr[i];
			if(Character.isUpperCase(wordArr[i])) {
				wordArr[i] = (char)(155-charInt);
			} 
			else if(Character.isLowerCase(wordArr[i])) {
				wordArr[i] = (char)(219-charInt);
			}
			else { wordArr[i] = ' '; }
			
			word = new String(wordArr);
		}
			
		return word;
    }
}
