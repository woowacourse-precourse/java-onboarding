package onboarding;

public class Problem3 {
    public static int[] memoization;

    public static int solution(int number) {
        int answer = 0;

        //index 1부터 시작
        memoization = new int[10001];
        memoization[0] = 0;
        memoization[1] = 0;
        memoization[2] = 0;

        return answer;
    }
}
