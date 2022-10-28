package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (!isValid(number)){
            return Integer.MAX_VALUE;
        }
        for (int i = 1; i <= number; i++){
            answer += check(i);
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

    /**
     * 주어진 매개변수가 박수를 쳐야하는 횟수를 계산하는 메소드
     * @param num
     * @return
     */
    public static int check(int num){
        int sum = 0;
        while (num != 0){
            int rest = num % 10;
            num /= 10;
            if (rest == 3 || rest == 6 || rest == 9){
                sum++;
            }
        }

        return sum;
    }

}
