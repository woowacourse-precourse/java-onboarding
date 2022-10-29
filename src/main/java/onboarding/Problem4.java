package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] origin = word.toCharArray();
        for (char c : origin){
            answer += check(c);
        }
        return answer;
    }

    // 문자 체크
    private static char check(char c) {
        if (96<c && c<123) return lowercase(c);
        if (64<c && c<91) return uppercase(c);
        return c;
    }

    // 대문자 변환
    static char uppercase(char a){
        char answer = (char)(155 - a);
        return answer;
    }
    // 소문자 변환
    static char lowercase(char a){
        char answer = (char)(219 - a);
        return answer;
    }
}
