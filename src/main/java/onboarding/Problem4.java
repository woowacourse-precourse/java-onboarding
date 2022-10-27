package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char chung_frog_lang(char c){
        char chung_lang = 0; // 0이 리턴되면 예외값
        if(c >= 'a' && c <= 'z'){
            chung_lang = (char)('z' - c + 'a');
        }
        else if(c >= 'A' && c <= 'Z'){
            chung_lang = (char)('Z' - c + 'A');
        }

        return chung_lang;
    }
}
