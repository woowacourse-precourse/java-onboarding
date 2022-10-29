package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	
    	char[] wordArr = word.toCharArray();
    	convertCharArrReverse(wordArr);
    	String answer = charArrToString(wordArr);
        return answer;
    }
    public static void convertCharArrReverse(char[] wordArr) {
    	for(int i=0; i<wordArr.length; i++) {
    		if(wordArr[i] == ' ') continue;
    		wordArr[i] = convertCharReverse(wordArr[i]);
    	}
    }
    public static char convertCharReverse(char target) {
    	char convertedChar;
    	if(Character.isUpperCase(target)) {
    		convertedChar = (char)(90-target+65);
    	} else {
    		convertedChar = (char)(122-target+97);
    	}
    	return convertedChar;
    }
    public static String charArrToString(char[] wordArr) {
    	String result;
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<wordArr.length; i++) {
    		sb.append(wordArr[i]);
    	}
    	result = sb.toString();
    	return result;
    }
}
