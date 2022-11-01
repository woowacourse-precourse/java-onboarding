package onboarding;


/**
 * 아스키코드를 사용한다.
 * 문자열의 길이만큼 for문을 돌린다.
 * 가장마지막 알파벳 아스키코드에서 해당 문자 아스키코드를 빼면 청개구리처럼 반대가 된다.
 * stringBuilder에 해당 글자들을 하나씩 쌓는다.
 * 
 * @author 2songyi
 *
 */
public class Problem4 {
    public static String solution(String word) {
        
        // 한글자씩 잘라 배열에 담는다.
        char[] cArray = word.toCharArray();
        StringBuilder result = new StringBuilder();
        
        for (int c : cArray) {
        	
        	int now = 0;
        	if (Character.isUpperCase(c)) {
        		// 대문자라면 -> 소문자로
        		now = 155 - c;
        		char nowToChar = (char) now;
            	result.append(nowToChar);
            	
        	} else if (Character.isLowerCase(c)) {
        		// 소문자 -> 대문자
        		now = 219 - c;
        		char nowToChar = (char) now;
            	result.append(nowToChar);
            	
        	} else if (c == 32) {
        		// 공백의 경우 한칸을 비워준다.
        		result.append(" ");
        	}
        	
        }
        
        return result.toString();
    }
    
//    public static void main(String[] args) {
//		System.out.println(solution("I love you"));
//	}
}
