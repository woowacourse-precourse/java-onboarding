package onboarding;

public class Problem3 {
    public static int solution(int number) {
        /*
        기능
        1. 1의 자리에서 3, 6, 9 나올 때마다 count
        2. 10의 자리 이상에서 3, 6, 9 나올 때마다 count
         */

        int count = 0;

        for (int i = 1; i <= number; i++) {
            int sum = i;
            do {
                if (((float)sum % 10 == 3) || ((float)sum % 10 == 6) || ((float)sum % 10 == 9)) {
                    count++;
                }
                sum = (int)(sum / 10.0);
            } while (sum != 0);
        }

        return count;
    }
}
