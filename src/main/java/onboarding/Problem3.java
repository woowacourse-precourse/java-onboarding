package onboarding;

public class Problem3 {
    static final String THREE = "3", SIX = "6", NINE = "9";
    static final String[] numForClaps = {THREE, SIX, NINE};

    public static int solution(int number) {
        int answer = 0;

        // 1부터 입력으로 주어진 번호까지 순회를 진행한다.
        for (int num = 1; num <= number; num++) {
            // 각 번호를 문자열로 변경하고, 원본 길이를 구한다.
            String strNum = String.valueOf(num);
            int originLen = strNum.length();

            // 박수 횟수를 계속 더해준다.
            answer += getClapCount(strNum, originLen);
        }
        return answer;
    }

    /**
     * 박수 횟수를 구한다.
     *
     * @param strNum 기준 문자열
     * @param originLen 기준 문자열의 원본 길이
     * @return int - 3/6/9가 포함되었을 때 친 박수 횟수를 리턴한다.
     */
    private static int getClapCount(String strNum, int originLen) {
        int clapCount = 0;
        for(String clapNum : numForClaps) {
            // 기준 문자열에 3/6/9가 포함이 되어 있다면 제거 후 길이를 구한다.
            if (strNum.contains(clapNum)) {
                String removedStr = removeClapNum(strNum, clapNum);
                int newLen = removedStr.length();
                // 제거된 길이만큼이 박수를 친 횟수가 된다.
                clapCount += (originLen - newLen);
            }
        }
        return clapCount;
    }



    /**
     * 문자열에 존재하는 clapNum (3/6/9)를 제거한다.
     *
     * @param strNum 기준 문자열
     * @param clapNum 369 게임의 기준이 되는 번호 (3/6/9)
     * @return String - 제거가 완료된 문자열을 리턴한다.
     */
    private static String removeClapNum(String strNum, String clapNum) {
        return strNum.replaceAll(clapNum, "");
    }

}
