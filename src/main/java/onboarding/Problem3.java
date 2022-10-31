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
            if (((float)i % 10 == 3) || ((float)i % 10 == 6) || ((float)i % 10 == 9)) {
                count++;
            }
            System.out.println((float)i % 10);
            System.out.println(count);
        }

        return count;
    }
}
