package onboarding;

public class Problem3 {
    public static final int MEMOIZATION_START_INDEX = 3;
    public static final int LETTER_START_INDEX = 0;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 10000;
    public static final char THREE = '3';
    public static final char SIX = '6';
    public static final char NINE = '9';

    public static int solution(int number) {
        int answer = countClap(initMemoizationArr(), number);

        return answer;
    }

    public static int[] initMemoizationArr() {
        int[] memoization = new int[10001];
        memoization[0] = 0;
        memoization[1] = 0;
        memoization[2] = 0;

        return memoization;
    }

    public static int countClap(int[] memoization, int number) {
        String indexToString = "";

        for (int index = MEMOIZATION_START_INDEX; index < number + 1; index++) {
            indexToString = String.valueOf(index);
            memoization[index] = memoization[index - 1];

            checkThreeSixNine(memoization, indexToString, index);
        }
        return memoization[number];
    }

    public static void checkThreeSixNine(int[] memoization, String indexToString, int index) {
        for (int letterIndex = LETTER_START_INDEX; letterIndex < indexToString.length(); letterIndex++) {
            if (isThreeSixNine(indexToString, letterIndex)) {
                clap(memoization,index);
            }
        }
    }

    public static void clap(int[] memoization,int index){
        memoization[index]++;
    }

    public static boolean isThreeSixNine(String indexToString, int letterIndex) {
        return (indexToString.charAt(letterIndex) == THREE || indexToString.charAt(letterIndex) == SIX || indexToString.charAt(letterIndex) == NINE);
    }
}
