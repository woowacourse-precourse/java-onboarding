package onboarding;
/*
 * 좀만 더 생각해보기
 *
*/
public class Problem3 {
    public static int solution(int number) {

        int count = 0;
        for (int num = 1; num <= number; num++) {
            int current_number = num;
            while (current_number != 0) {
                if (current_number % 10 == 3 || current_number % 10 == 6 || current_number % 10 == 9) {
                    count++;
                }
                current_number /= 10;
            }
        }
        return count;
    }
}

