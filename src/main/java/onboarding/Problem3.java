package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 숫자를 입력받아 문자열로 변환 후 3,6,9의 갯수를 반환한다.
     * 
     * @param nowNumber
     * @return {@code} int} 3,6,9 갯수의 합
     */
    private static int getClaps(int nowNumber) {
        String strNumber = String.valueOf(nowNumber);
        String removed = removeClaps(strNumber);

        return strNumber.length() - removed.length();
    }

    /**
     * 문자열을 입력받아 3,6,9 문자를 지운다.
     * 
     * @param strNum
     * @return {@code String} 3,6,9를 없앤 문자열
     */
    private static String removeClaps(String strNum) {
        strNum = strNum.replace("3", "");
        strNum = strNum.replace("6", "");
        strNum = strNum.replace("9", "");

        return strNum;
    }
}
