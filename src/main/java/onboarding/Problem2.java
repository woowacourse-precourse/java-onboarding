package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 입력으로 들어온 문자열을 char형 배열로 분해한다.
        char[] cryptogramArr = getCharArr(cryptogram);

        // 배열을 순회하며 해당 원소를 기준으로 중복 문자열을 체크한다.
        for(Character element : cryptogramArr) {
            // 해당 문자가 2번 이상 반복된다면 제거하여 원본 암호문을 변경한다.
            cryptogram = cryptogram.replaceAll(element + "{2,}", "");
        }

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
