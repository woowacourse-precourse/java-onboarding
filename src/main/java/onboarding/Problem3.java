package onboarding;

public class Problem3 {
    static final String[] numForClaps = {"3", "6", "9"};

    public static int solution(int number) {
        int answer = 0;

        // 1부터 입력으로 주어진 번호까지 순회를 진행한다.
        for (int num = 1; num <= number; num++) {
            // 각 번호를 문자열로 변경하고, 원본 길이를 구한다.
            String strNum = String.valueOf(num);
            int originLen = strNum.length();
        }
        return answer;
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
