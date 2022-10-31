package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return sumNumOfClaps(number);
    }

    private static int sumNumOfClaps(int number) {
        int sum = 0;
        for (int i = 1; i < number + 1; i++) {
            for (char c : Integer.toString(i).toCharArray()) {
                if(areThere369(c)) sum++;
            }
        }
        return sum;
    }

    private static boolean areThere369(char c) {
        int n = c - '0';
        return n == 3 || n == 6 || n == 9;
    }
}
