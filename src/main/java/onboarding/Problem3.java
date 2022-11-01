package onboarding;

public class Problem3 {

    // public static void main(String[] args) {
    // int k = 33;
    // System.out.println(solution(k));
    // }

    static int func(int a) {
        int answer = 0;
        int k = a;
        while (k > 0) {
            int tmp = k;
            while (tmp > 0) {
                if (tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9)
                    answer++;
                tmp /= 10;
            }
            k--;
        }
        return answer;
    }

    public static int solution(int number) {
        int answer = 0;
        answer = func(number);
        return answer;
    }
}
