package onboarding;

public class Problem3 {
    public static void main(String[] args) {
        int number = 13;
        System.out.println(solution(number));
    }
    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            int pow = 0;
            while (i >= Math.pow(10, pow)) {
                int n = i % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
                if (n == 3 || n == 6 || n == 9) {
                    result += 1;
                }
                pow += 1;
            }
        }

        return result;
    }
}
