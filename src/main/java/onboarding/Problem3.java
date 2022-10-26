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

        calculateClapCount(number);

        return answer;
    }

    private static int calculateClapCount(int number) {
        for (int index = 3; index < number + 1; index++) {
            String indexToString = String.valueOf(index);
            memoization[index] = memoization[index - 1];

            for (int letterIndex = 0; letterIndex < indexToString.length(); letterIndex++) {
                if (indexToString.charAt(letterIndex) == '3' || indexToString.charAt(letterIndex) == '6' || indexToString.charAt(letterIndex) == '9') {
                    memoization[index]++;
                }
            }
        }
        return memoization[number];
    }
}
