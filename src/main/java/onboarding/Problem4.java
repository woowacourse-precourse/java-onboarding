package onboarding;

/**
 * 기능목록
 * 1. 청개구리 사전대로 변환
 * 2. 한 글자씩 붙임
 * */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static char changeFrog(int c){
        if(c>='a' && c<='z'){
            c='a'+'z'-c;
        } else if (c>='A' && c<='Z') {
            c='A'+'Z'-c;
        }
        return (char)c;
    }
}
