package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }


    /**
     * DESCRIPTION
     *   전달받은 알파벳 1개를 청개구리 알파벳으로 변환
     *
     * Params
     *   alphabet - 변환 전 알파벳(엄마 알파벳)
     *
     * RETURN
     *   청개구리 알파벳
     */
    public static char convertAlphabet(char alphabet){
        if(65 <= alphabet && alphabet <= 90){ // 대문자 변환
            if(alphabet < 'A' + 13) // 26개 알파벳 중 1~13번째
                return (char)('A' + (('Z' - 'A') - (alphabet - 'A')));
            else
                return (char)('Z' - (('Z' - 'A') - ('Z' - alphabet)));
        }
        else if(97 <= alphabet && alphabet <= 122){ // 소문자 변환
            if(alphabet < 'a' + 13) // 26개 알파벳 중 1~13번째
                return (char)('a' + (('z' - 'a') - (alphabet - 'a')));
            else
                return (char)('z' - (('z' - 'a') - ('z' - alphabet)));
        }
        else
            return ' ';
    }
}
