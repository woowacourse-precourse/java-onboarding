package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (!isValid(number)){
            return Integer.MAX_VALUE;
        }

        return answer;
    }

    /**
     * 주어진 범위를 체크하는 메소드
     * @param number
     * @return
     */
    public static boolean isValid(int number){
        return number >= 1 && number <= 10000;
    }


}
