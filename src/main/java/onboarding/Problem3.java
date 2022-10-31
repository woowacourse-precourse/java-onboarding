package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++){
            answer += clapnumber(i);
        }
        return answer;
    }

    private static int clapnumber(int n) {
        int m;
        int countmultiple = 0;
        do {
            m = n % 10;
            if (m == 3 || m == 6 || m == 9) {
                countmultiple++;
            }
            n /= 10;
        } while (n != 0);
        return countmultiple;
    }
}
