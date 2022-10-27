package onboarding;

public class Problem3 {
    public static int[] memoization;
    public static final int MEMOIZATION_START_INDEX = 3;
    public static final int LETTER_START_INDEX = 0;
    public static final char THREE = '3';
    public static final char SIX = '6';
    public static final char NINE = '9';

    public static int solution(int number) {
        int answer = 0;

        //index 1부터 시작
        memoization = new int[10001];
        memoization[0] = 0;
        memoization[1] = 0;
        memoization[2] = 0;

        answer = calculateClapCount(number);

        return answer;
    }

    private static int calculateClapCount(int number) {
        String indexToString = "";

        for (int index = MEMOIZATION_START_INDEX; index < number + 1; index++) {
            indexToString = String.valueOf(index);
            memoization[index] = memoization[index - 1];

            for (int letterIndex = LETTER_START_INDEX; letterIndex < indexToString.length(); letterIndex++) {
                if (indexToString.charAt(letterIndex) == THREE || indexToString.charAt(letterIndex) == SIX || indexToString.charAt(letterIndex) == NINE) {
                    memoization[index]++;
                }
            }
        }
        return memoization[number];
    }
}
