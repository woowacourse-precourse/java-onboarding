package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 1. 입력된 문자가 알파벳인지 판별
        // 2. 알파벳이라면 대문자 소문자인지 판별
        // 3. 변환(아스키코드) => 대문자 : 155 - 문자 , 소문자 : 219 - 문자
        // 4. 변환한 문자 합치기
        // 5. 합친 결과 값 반환
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isAlphabetic(word.charAt(i))) {
                if (Character.isUpperCase(word.charAt(i))) {

                } else {

                }
            } else sb.append(word.charAt(i));
        }
        String answer = "";
        return answer;
    }
}
