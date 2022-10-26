package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 3; i <= number; i++) {
            int j = i;
            do {
                switch (j % 10) {
                    case 3:
                    case 6:
                    case 9:
                        answer++;
                }
                j /= 10;
            } while (j != 0);
        }
        return answer;
    }
}
