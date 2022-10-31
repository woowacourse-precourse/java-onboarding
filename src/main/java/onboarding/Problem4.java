package onboarding;
// 1. 아스키코드를 사용해여 해결하면 쉽게 해결될듯..?
// >> 한 단어씩 찾으며 알파벳을 찾기
// >> 찾은 단어의 아스키코드 값에서 a(A) 의 아스키코드 값을 빼주고 다시 그 값을 z(Z)에 뺴주기
// A 65 , Z 90 , a 97 z 122
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
        for(int i=0 ; i<arr.length ;i++) {
        	if(Character.isAlphabetic(arr[i])) {
        		answer+=conver_char(arr[i]);
        	}else {
        		answer +=arr[i];
        	}
        	
        }
        return answer;
    }
    public static char conver_char(char c) {
    	if(Character.isUpperCase(c)) {
    		int tmp = c-65;
    		return (char)(90-tmp);
    	}else {
    		int tmp = c-97;
    		return (char)(122-tmp);
    	}
    }
}
