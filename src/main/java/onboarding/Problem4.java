package onboarding;

public class Problem4 {
    /**
     * 입력 문자열을 주어진 조건대로 변환
     * 조건 1) A - Z, B - Y, C - X , ... , Z - A 로 변경
     * 조건 2) 대문자는 대문자, 소문자는 소문자로 변경
     * 조건 3) 알파벳 이외의 문자는 변환 X
     * @param word
     * @return converted word
     */
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        for (char v: chars) {
            int ascii = (int)v;
            char ch = v;
            // A - Z에 속하는 경우
            // 변환 전 아스키 코드 + 변환 후 아스키 코드 = 155
            if (ascii >= 65 && ascii <= 90) {
                ch = (char)(155 - ascii);
            }
            // a - z에 속하는 경우
            // 변환 전 아스키 코드 + 변환 후 아스키 코드 = 219
            else if (ascii >= 97 && ascii <= 122) {
                ch = (char)(219 - ascii);
            }

            answer = answer + ch;
        }
        return answer;
    }
}

