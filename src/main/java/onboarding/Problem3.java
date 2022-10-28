package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        for (int oneFromNumber = 1; oneFromNumber <= number; oneFromNumber++) {
            int digit = 1;

            while (oneFromNumber / digit != 0) {
                switch (oneFromNumber / digit % 10) {
                    case 3:
                    case 6:
                    case 9:
                        count += 1;
                }
                digit *= 10;
            }
        }

        return count;
    }
}
