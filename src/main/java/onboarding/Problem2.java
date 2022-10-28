package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /* 3 이상 연속된 target 문자열을 2개까지 줄이는 메서드 */
    private static String compressToSizeTwo(String cryptogram, char target) {
        String result = cryptogram;
        String tmp = Character.toString(target);
        String start = tmp.repeat(3);
        String end = tmp.repeat(2);

        while (result.contains(tmp)) {
            result = result.replace(start,end);
        }

        return result;
    }
}
