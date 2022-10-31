package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	String answer = "";
    	String temp = word.toLowerCase(); // 우선 모두 소문자로 변경
    	String alpha = "abcdefghijklmnopqrstuvwxyz"; // 우영우는 거꾸로 해도 우영우
    	for (int i=0;i<temp.length();i++) {
    		boolean upper = false;
    		char c = temp.charAt(i);
    		if (Character.isUpperCase(word.charAt(i))) { // 대문자인지 확인
    			upper = true;
    		}
    		int idx = alpha.indexOf(c); // 표에서의 인덱스
    		
    		if ((int)c >= 97 && (int)c <= 122) { // 알파벳인 경우에만 변환
    			c = alpha.charAt((alpha.length() - 1) - idx);
    			if (upper) {
    				answer = answer + Character.toUpperCase(c);
    			}
    			else {
    				answer = answer + c; // 해당 알파벳의 인덱스를 이용해 변환					
				}
    		}
    		else {
				answer = answer + c;
			}
    		
    		
    	}
    	
        return answer;
    }
}
