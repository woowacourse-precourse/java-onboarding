package onboarding;

import onboarding.common.ValidationUtil;

public class Problem3 {
    static final String[] NUM_FOR_CLAPS = {"3", "6", "9"};

    public static int solution(int number) {
        int answer = 0;

        // 입력받은 숫자에 대한 검증 작업을 진행한다.
        verifyNumber(number);

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
     * 입력받은 숫자에 대한 검증 작업을 진행한다.
     *
     * @param number 입력받은 숫자
     */
    private static void verifyNumber(int number) {
        ValidationUtil numValidation = new ValidationUtil();
        numValidation.addVarName("number");
        // 숫자의 범위는 1~10000 사이로 제한되어 있다.
        numValidation.checkNumRange(number, 1, 10000);
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
        for(String clapNum : NUM_FOR_CLAPS) {
            int newLen = checkClapNumAndGetLength(strNum, clapNum);

            // 제거된 길이만큼이 박수를 친 횟수가 된다.
            if (newLen != -1) {
                clapCount += (originLen - newLen);
            }
        }

        return clapCount;
    }

    /**
     * 기준 문자열에 3/6/9가 포함이 되어 있다면 제거 후 길이를 구한다.
     *
     * @param strNum 기준 문자열
     * @param clapNum 369 게임의 기준이 되는 번호 (3/6/9)
     * @return int - 제거 완료된 문자열의 길이를 리턴한다. 변경사항이 없을 경우 -1을 리턴한다.
     */
    private static int checkClapNumAndGetLength(String strNum, String clapNum) {
        if (strNum.contains(clapNum)) {
            String removedStr = removeClapNum(strNum, clapNum);
            return removedStr.length();
        }

        return -1;
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
