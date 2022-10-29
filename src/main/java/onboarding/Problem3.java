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

}
