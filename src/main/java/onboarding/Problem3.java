package onboarding;
import java.util.LinkedList;
public class Problem3 {
    public static int solution(int number) {
        int[] answerOfNumbers = new int[number + 1];
        for (int num = 1 ; num <= number ; num++){
            answerOfNumbers[num] += answerOfNumbers[num-1] + countContains369(num);
        }
        return answerOfNumbers[number];
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
