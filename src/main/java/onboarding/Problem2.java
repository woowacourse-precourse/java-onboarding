package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        char charAtFirst = '0';
        char charAtSecond = '0';
        String subString = "";
        int second = 0;
        int endIndex = answer.length();
        for (int i = 0; i < endIndex; i++) {
            for (int first = 0; first < answer.length() - 1; first++) {
                StringBuffer sb = new StringBuffer();
                second = first + 1;
                charAtFirst = answer.charAt(first);
                charAtSecond = answer.charAt(second);

                if (charAtFirst == charAtSecond) {
                    subString = answer.substring(0, first);
                    sb.append(subString);
                    subString = answer.substring(second + 1, answer.length());
                    sb.append(subString);
                    answer = sb.toString();
                }
            }
        }
        return answer;
    }
}