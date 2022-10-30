package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String check = "";
        char numCheck = ' ';

        /**
         * 제시 된 숫자 (number)를 String 타입으로 check라는 변수에 담고,
         * check의 값을 char타입으로 하나하나씩 쪼개어서 비교하는 과정이다.
         */
        for (int i = 1; i <= number; i++) {
            check = ""+i;
            for (int j = 0; j < check.length(); j++) {
                numCheck = check.charAt(j);
                System.out.println("numCheck = " + numCheck);
                if (numCheck == '3' || numCheck == '6' || numCheck == '9') {
                    answer++;
                }
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
