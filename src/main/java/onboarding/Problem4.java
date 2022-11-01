package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // word의 길이가 1보다 작거나 1000보다 클 때 예외 처리
        if (word.length() == 0 || word.length() > 1000)
            return answer;

        // word를 char 배열로 나누고 한 char마다 아스키코드표로 변환
        // 그리고 다시 char 배열을 String 타입으로 변환
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 27 - (chars[i] - 64) * 2;
            }
            else if (chars[i] >= 97 && chars[i] <= 122) {
                chars[i] += 27 - (chars[i] - 96) * 2;
            }
            // 알파벳 이외의 문자는 예외 처리
            else
                return answer;
        }
        answer = new String(chars);

        return answer;
    }
}
