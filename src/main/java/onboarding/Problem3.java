package onboarding;

/*
 * 좀만 더 생각해보기
 *
*/
public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int current_number = i;
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
