package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // Character 클래스 isUpperCase(), isLowerCase() 메소드 사용 위해
        // word를 String 타입에서 Char 타입 배열로 변환
        char[] arr = word.toCharArray();
        for(int i = 0 ; i < word.length() ; i++){
            //대문자 변환 규칙은 서로 관계된 문자들의 아스키코드 값의 합이 155가 되는 것임
            if(Character.isUpperCase(arr[i])) answer += Character.toString(155-arr[i]);
            //소문자 변환 규칙은 서로 관계된 문자들의 아스키코드 값의 합이 219가 되는 것임
            else if(Character.isLowerCase(arr[i])) answer += Character.toString(219 - arr[i]);
            //영문자 이외 경우
            else answer += Character.toString(arr[i]);
        }
        return answer;
    }
}
