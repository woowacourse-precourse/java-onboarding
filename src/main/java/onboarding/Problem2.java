package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer;
        StringBuffer result = new StringBuffer(cryptogram);

        int index = 0;
        int checkDuplicate = 0;
        int endIndex = result.length();
        int cut;

        while (true) {
            if (CheckDuplicate(index >= endIndex - 1, checkDuplicate, 0)) {
                index = 0;
                checkDuplicate = 1;
            }

            if (CheckDuplicate((index >= endIndex - 1 || endIndex == 1), checkDuplicate, 1)) {
                break;
            }

            if (ContinueSame(result, index)) {
                checkDuplicate = 0;
                for (int i = index + 1; i < endIndex; i++) {

                    if (findOtherDuplicate(result, index, i)) {
                        result.delete(index, i);
                        endIndex = result.length();
                        cut = i - index;
                        index = i - cut;
                        break;
                    }
                    if (FinalIndex(i, endIndex - 1)) {
                        result.delete(index, i + 1);
                        index = 0;
                        endIndex = result.length();
                    }
                }
            }
            else {
                index++;
            }
        }

        answer = String.valueOf(result);
        return answer;
    }


    private static boolean CheckDuplicate(boolean condition, int flag, int x) {
        return condition && flag == x;
    }
    private static boolean ContinueSame(StringBuffer result, int index) {
        return result.charAt(index) == result.charAt(index + 1);
    }
    private static boolean findOtherDuplicate(StringBuffer result, int index, int i) {
        return result.charAt(index) != result.charAt(i);
    }

    private static boolean FinalIndex(int i, int end_index) {
        return i == end_index;
    }
}