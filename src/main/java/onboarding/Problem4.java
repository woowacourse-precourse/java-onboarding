package onboarding;

public class Problem4 {
	public static String solution(String word) {
    	if(word.length() < 1 || word.length() >1000) return null;
    	int intChar=0;
    	char charWord=' ';
    	String answer = "";
    	// 아스키코드로 변환하여 기능 구현
        for(int num : word.toCharArray()) {
        	if(num >= 97 && num <= 122) {
        		intChar=122-(num-97);
        		charWord=(char)intChar;
        		answer+=charWord;
        	}else if(num >= 65 && num <= 90) {
        		intChar=90-(num-65);
        		charWord=(char)intChar;
        		answer+=charWord;
        	}else if(num == 32){
        		answer+=' ';
        	}else {
        		return null;
        	}
        }
        return answer;
    }
}
