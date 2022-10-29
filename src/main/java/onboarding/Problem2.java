package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 입력으로 들어온 문자열을 char형 배열로 분해한다.
        char[] cryptogramArr = getCharArr(cryptogram);

        // 배열을 순회하며 해당 원소를 기준으로 중복 문자열을 체크한다.
        for(Character element : cryptogramArr) {
            // 해당 문자가 2번 이상 반복된다면 제거하여 원본 암호문을 변경한다.
            cryptogram = removeDuplicateElement(cryptogram, element);
        }

        return cryptogram;
    }

    /**
     * 2번 이상 중복된 문자열을 제거한다.
     *
     * @param cryptogram 제거 진행할 문자열
     * @param element 제거의 기준이 되는 요소
     * @return String - 제거 작업이 완료된 문자열을 리턴한다.
     */
    private static String removeDuplicateElement(String cryptogram, Character element) {
        return cryptogram.replaceAll(element + "{2,}", "");
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
