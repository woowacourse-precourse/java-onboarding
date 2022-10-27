package onboarding;
/*
* 1. 반대로 문자를 변환하는 메소드 작성
* 2. 조건에 맞도록 변환
* */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    // 아스키코드 값을 이용하여 반대되는 문자를 구함
    static char uppercase(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            return (char)('Z' - ch + 'A');
        }
        else if (ch >= 'a' && ch <= 'z'){
            return (char)('z' - ch + 'a');
        }
        else{
            return ch;
        }
    }
}
