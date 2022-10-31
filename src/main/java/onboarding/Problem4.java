package onboarding;

public class Problem4 {
    private static final int CAPITAL = 1;
    private static final int SMALL = 2;
    private static final int SPACE = 3;
    private static final int CAPITAL_A = 65;
    private static final int CAPITAL_Z = 90;
    private static final int SAMLL_A = 97;
    private static final int SAMLL_Z = 122;
    private static final int SPACE_ASCII = 32;

    public static String solution(String word) {
        String answer = frog_dictionary(word.toCharArray());
        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 대소문자 구별하기
     * */

    private static int find_caplital_small_space(char now) {
        if (CAPITAL_A <= now && now <= CAPITAL_Z) return CAPITAL; // 대문자는 1 반환
        if (SAMLL_A <= now && now <= SAMLL_Z) return SMALL; // 소문자는 2 반환
        if (now == SPACE_ASCII) return SPACE; // 공백은 3 반환
        return -1; // 그 이외는 -1 반환
    }

    /*
     * 기능 요구 사항
     * 2. 청개구리 사전을 참고해서 문자를 변환
     * */

    private static String frog_dictionary(char[] char_array) {
        for (int index = 0; index < char_array.length; index++) {
            if (find_caplital_small_space(char_array[index]) == CAPITAL) {
                char_array[index] = (char) (CAPITAL_Z - (char_array[index] - CAPITAL_A));
            }
            if (find_caplital_small_space(char_array[index]) == SMALL) {
                char_array[index] = (char) (SAMLL_Z - (char_array[index] - SAMLL_A));
            }
            if (find_caplital_small_space(char_array[index]) == SPACE) continue;
        }
        return new String(char_array);
    }
}
