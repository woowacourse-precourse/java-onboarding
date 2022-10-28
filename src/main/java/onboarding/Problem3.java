package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static int countThreeSixNine(int i) {
        int cnt = 0;
        while (i > 0) {
            int num = i % 10;
            if (num == 3 || num == 6 || num == 9) cnt++;
            i /= 10;
        }
        return cnt;
    }
}
