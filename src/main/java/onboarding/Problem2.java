package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /* 3 이상 연속된 target 문자열을 2개까지 줄이는 메서드 */
    private static String compressToSizeTwo(String cryptogram, String target) {
        String result=cryptogram;
        String tmp=target+target+target;
        while (result.contains(tmp)) {
            result=result.replace(tmp,target+target);
        }

        return result;
    }
}
