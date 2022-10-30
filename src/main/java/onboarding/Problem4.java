//1. 문자열 순서대로 문자 확인
//2. 청개구리 사전을 참고해 변환
//3. 변환한 값을 반환
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        sb.append(word);

        for (int index = 0 ; index < sb.length() ; index += 1) {
            int charToInt = sb.charAt(index);
            if (65 <= charToInt && charToInt <= 90) {
                charToInt = 90-charToInt+65;
                sb.setCharAt(index, (char)charToInt);
            } else if (97 <= charToInt && charToInt <= 122) {
                charToInt = 122-charToInt+97;
                sb.setCharAt(index, (char)charToInt);
            }
        }

    }
}
