package onboarding;

public class Problem4 {
    public static String solution(String word) {
    	
    	String result = "";

		for(int i = 0; i < word.length(); i++) {
			result += ChangeWord(word.charAt(i));
		}
		
		return result;
    }
    
    //문자열의 문자를 차례로 입력받아 변환하여 반환
    private static String ChangeWord(char c) {
		
    	//대문자 알파벳의 순서를 뒤집어준다.
		if(c >= 'A'&& c <= 'Z')
			return Character.toString('Z' - c + 'A');
		
		//소문자 알파벳의 순서를 뒤집어준다.
		else if(c >= 'a'&& c <= 'z')
			return Character.toString('z' - c + 'a');
		
		//알파벳이 아닌 경우 그대로 출력해준다.
		return Character.toString(c);
	}
}
