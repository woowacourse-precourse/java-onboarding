package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 입력으로 들어온 문자열을 char형 배열로 분해한다.
        char[] cryptogramArr = getCharArr(cryptogram);

        return cryptogram;
    }

    /**
     * 파라미터로 받은 문자열을 char형 배열로 분해하여 리턴한다.
     *
     * @param str 문자열
     * @return char[] - 입력으로 받은 문자열에 대해 char형 배열로 쪼갠 결과를 리턴한다.
     */
    private static char[] getCharArr(String str) {
        return str.toCharArray();
    }
}
