package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder("");
        char[] wordArr = getCharArr(word);

        for(Character wordVal : wordArr) {
            if(isNotAlphabetic(wordVal)) {
                answer.append(' ');
                continue;
            }
        }
        return answer.toString();
    }

    /**
     * 요소가 알파벳이 아닌지 판단한다.
     *
     * @param value 판단할 요소
     * @return 알파벳이 아니라면 true, 맞다면 false
     */
    private static boolean isNotAlphabetic(Character value) {
        return !Character.isAlphabetic(value);
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
