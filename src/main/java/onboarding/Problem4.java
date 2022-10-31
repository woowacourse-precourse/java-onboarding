package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	
    	char[] wordArr = word.toCharArray();
    	convertCharArrReverse(wordArr);
    	String answer = charArrToString(wordArr);
        return answer;
    }
    private static void convertCharArrReverse(char[] wordArr) {
    	for(int i=0; i<wordArr.length; i++) {
    		if(wordArr[i] == ' ') continue;
    		wordArr[i] = convertCharReverse(wordArr[i]);
    	}
    }
    private static char convertCharReverse(char target) {
    	char convertedChar = target;
    	if(isUpperCase(target)) {
    		convertedChar = (char) ('Z'-target+'A');
    	} else if(isLowerCase(target)){
    		convertedChar = (char) ('z'-target+'a');
    	}
    	return convertedChar;
    }
    private static boolean isUpperCase(char target) {
    	if(65<=target && target<=90) {
    		return true;
    	}
    	return false;
    }
    private static boolean isLowerCase(char target) {
    	if(97<=target && target<=122) {
    		return true;
    	}
    	return false;
    }
    private static String charArrToString(char[] wordArr) {
    	String result;
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<wordArr.length; i++) {
    		sb.append(wordArr[i]);
    	}
    	result = sb.toString();
    	return result;
    }
}
