package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        for(int i = 0; i < word.length(); i++) {
        	char alpa = word.charAt(i);
        	if(alpa >= 65 && alpa <= 90) {
        		answer +=(char)(90-(alpa-65));
        	}else if(alpa >= 97 && alpa <= 122) {
        		answer += (char)(122-(alpa-97));
        	}else {
        		answer +=" ";
        	}
        	
        }
        return answer;
    }
}
