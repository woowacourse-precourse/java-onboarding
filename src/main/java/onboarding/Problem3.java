package onboarding;

public class Problem3 {
    private static int howManyNums = 0;
    public static int solution(int number) {
        // 1. 3 6 9 숫자가 몇개 존재하는지 담을 전역변수 생성
        // 2. 숫자를 하나씩 세면서 해당 숫자내에 3 6 9 가 몇개 있는지 확인하는 메서드 생성
        // 3. 정답 반환

        int answer = 0;
        return answer;
    }

    private void countHowManyNums(int number) {
        String strNumber = "";

        for (int i = 3; i <= number; i++) {
            strNumber = String.valueOf(number);
            for (int j = 0; j < strNumber.length(); j++) {
                if (strNumber.charAt(i) == '3' || strNumber.charAt(i) == '6' || strNumber.charAt(i) == '9') {
                    howManyNums++;
                }
            }
        }
    }
}
