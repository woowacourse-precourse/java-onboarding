package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int total = 0;
        for(int i=1; i <= number; i++) {
            total += numberCount(i);
        }
        return total;
    }

    public static int numberCount(int number) {
        int count = 0;
        int tmp = 0;
        while(number!=0) {
            tmp = number%10;
            if ((tmp == 3) || (tmp == 6) || (tmp == 9)) count++;
            number /= 10;
        }
        return count;
    }
}
