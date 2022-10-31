package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	String answer = "";
    	String temp = word.toLowerCase(); // 우선 모두 소문자로 변경
    	String alpha = "abcdefghijklmnopqrstuvwxyz"; // 우영우는 거꾸로 해도 우영우
    	for (int i=0;i<temp.length();i++) {
    		char c = temp.charAt(i);
    		int idx = temp.indexOf(c);
    		
    		if ((int)c >= 97 && (int)c <= 122) { // 알파벳인 경우에만 변환
    			answer = answer + alpha.charAt((alpha.length() - 1) - idx); // 해당 알파벳의 인덱스를 이용해 변환
    		}
    		else {
				answer = answer + c;
			}
    		
    		
    	}
    	
        return answer;
    }
}
