package onboarding;

/**
 * 기능 사항
 * 1.알파벳이 가지는 아스키코드 번호를 반대로 변환해 리턴하는 함수
 */
public class Problem4 {
    /**
     * 1.알파벳이 가지는 아스키코드 번호를 반대로 변환해 리턴하는 함수
     * 대문자와 소문자를 아스키코드번호로 나눈다.
     * 알파벳 외의 문자는 변환하지 않고 그대로 리턴한다.
     */
    static int change(int s){
        int result = 0;
        int x = 0;
        if(s>=65 && s<=90){
            x = s - 65;
            result = ((25-x)+65);
        } else if (s>=97 && s<=122) {
            x = s - 97;
            result = ((25-x)+97);
        } else{
            result = s;
        }
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
