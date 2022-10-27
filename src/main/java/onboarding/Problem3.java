package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // number 을 배열에 1 ~ number 까지 나열하는 함수
    private static int[] intToArray(int number) {
        int[] output = new int[number];

        for(int i = 0; i<number; i++) {
            output[i] = i+1;
        }

        return output;
    }
}
