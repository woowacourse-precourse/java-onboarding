package onboarding;

public class Problem4 {

    /**
     * 기능 목록
     * 1. 문자 대문자, 소문자 판단
     * 2. 청개구리 사전
     */

    /**
     * 1. 문자 대문자, 소문자 판단
     * @param a : 비교 문자
     * @return : 대문자 = 1, 소문자 = 2, 그 외의 문자 = -1
     */

    static int checkCapital(char a){
        // 대문자
        if (a >= 65 && a <= 90) return 1;
        // 소문자
        if (a >= 97 && a <= 122) return 2;
        // 그 외의 문자
        return -1;
    }

    /**
     * 2. 청개구리 사전 - 아스키코드 이용
     * @param chk : 대문자, 소문자 구별할 체크 인자
     * @param a : 바꿀 문자
     * @return : 바뀐 문자
     */

    static char dictionary(int chk, char a){
        // 대문자
        if (chk == 1) {
            int asciiA = (int)a;
            return (char)(155-asciiA);
        }
        // 소문자
        if (chk == 2){
            int asciiA = (int)a;
            return (char)(219-asciiA);
        }
        // 그 외의 문자
        return a;
    }

    public static String solution(String word) {
        String answer = "";

        // 문자열 한 글자씩 청개구리 사전에 대입
        for (int i = 0; i < word.length(); i++){
            int check = checkCapital(word.charAt(i));
            answer += dictionary(check, word.charAt(i));
        }

        return answer;
    }
}
