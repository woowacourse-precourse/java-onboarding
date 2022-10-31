package onboarding;
import java.util.LinkedList;
public class Problem3 {
    public static int solution(int number) {
        return 0;
    }
    public static int countContains369(int number){
        int count369 = 0;
        while (number != 0){
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9)
                count369++;
            number /= 10;
        }
        return count369;
    }
}
