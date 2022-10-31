package onboarding;
 
public class Problem4 {
    public static String solution(String word) {
    	
    	// 아스키 코드 이용해서 대문자 소문자 구분
    	// 아스키코드 시작값과 현재 값을 비교
    	
    	String answer = "";
    	char [] wordtemp = word.toCharArray();
    	
    	int ascii,abstemp,index = 0;
    	for(int i = 0; i<wordtemp.length; i++) {
    		
    		if(Character.isUpperCase(wordtemp[i])) { // 대문자
    			ascii = 65;
    		} else if(Character.isLowerCase(wordtemp[i])) { //소문자
    			ascii = 97;
    		} else {
    			answer = answer + " ";
    			continue;
    		}
    		abstemp = Math.abs(ascii-wordtemp[i]);
    		index = (ascii+25) - abstemp;
    		answer = answer + String.valueOf((char)index);
    	}
        return answer;
    }
}
