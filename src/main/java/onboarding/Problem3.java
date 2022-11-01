package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = checkNumber(number);
        return answer;
    }
    static int checkNumber(int number) {
        int clabtion_num = 0;
        for(int i=1; i <= number; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {clabtion_num += 1;}
                temp /= 10;
            }
        }
        return clabtion_num;
    }
}
