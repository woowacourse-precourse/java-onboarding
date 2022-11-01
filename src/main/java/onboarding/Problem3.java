package onboarding;

public class Problem3 {
    public static int solution(int number) {
        StringBuilder check = transferNumber(number);
        int answer = numCount(check);

        return answer;
    }

    /**
     * 주어진 숫자를 String으로 만드는 메서드
     *
     * @param num
     * @return
     */
    public static StringBuilder transferNumber(int num) {
        StringBuilder check = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            check.append("" + i);
        }
        return check;
    }

    /**
     * 박수 횟수 체크 메서드
     *
     * @param checkNum
     * @return
     */
    public static int numCount(StringBuilder checkNum) {
        char numCheck = ' ';
        int count = 0;
        for (int i = 0; i < checkNum.length(); i++) {
            numCheck = checkNum.charAt(i);
            if (numCheck == '3' || numCheck == '6' || numCheck == '9') {
                count++;
            }
        }
        return count;
    }
}
