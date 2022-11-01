package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        /*
         * 아스키코드 
         * 영어 대문자 65~90
         * 영어 소문자 97~122
         * 
         * */
        
        char result;
        
        for(int i=0; i<word.length(); i++) {
        	
        	//문자 하나를 아스키값으로 변환
        	int asciiNum = (int)word.charAt(i);
        	
        	//변환된 값이 알파벳 대문자
        	if(asciiNum >64 && asciiNum <91) {
        		//나머지연산을 통해 몇번째 알파벳인지 확인하고 Z에서 값을 뺀 것이 반대 알파벳이된다.
        		//A가 0번째 알파벳 (A % 65 = 0)
        		//Z(90)- 0 = Z가 되므로 A -> Z가 된다.
        		result = (char)(90-(asciiNum%65));        		
        		
        	}
        	//변환된 값이 알파벳 소문자
        	else if(asciiNum >96 && asciiNum <123) {
        		result = (char)(122-(asciiNum%97));  
        	}
        	else {
        		//알파벳이 아닌 경우 변환없음
				result = word.charAt(i);
			}
        	//변환된 값을 answer에 한개씩 추가
        	answer =answer.concat(String.valueOf(result));
        }
        return answer;
    }
}
