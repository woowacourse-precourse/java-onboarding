package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer result = new StringBuffer(
            cryptogram); //delete를 사용하여 중복 문자열을 제거하기 위하여 StringBuffer 사용

        int index = 0;
        int check_duplicate = 0;
        int end_index = result.length();
        int cutSize = 0;

        while (true) {
            if (isCheckDuplicate(index >= end_index - 1, check_duplicate, 0)) {
                index = 0;
                check_duplicate = 1;
            }

            if (isCheckDuplicate((index >= end_index - 1 || end_index == 1), check_duplicate, 1)) {
                break;
            }

            if (isContinuosSame(result, index)) {
                check_duplicate = 0;
                for (int i = index + 1; i < end_index; i++) {

                    if (findOtherValue(result, index, i)) {
                        result.delete(index, i);
                        end_index = result.length();
                        cutSize = i - index;
                        index = i - cutSize;
                        break;
                    } else if (isSameFinalIndex(i, end_index - 1)) {
                        result.delete(index, i + 1);
                        index = 0;
                        end_index = result.length();
                    }
                }
            } else {

                index++;

            }

        }

        answer = String.valueOf(result);
        return answer;
    }

    private static boolean isSameFinalIndex(int i, int end_index) {
        return i == end_index;
    }

    private static boolean findOtherValue(StringBuffer result, int index, int i) {
        return result.charAt(index) != result.charAt(i);
    }

    private static boolean isContinuosSame(StringBuffer result, int index) {
        return result.charAt(index) == result.charAt(index + 1);
    }

    private static boolean isCheckDuplicate(boolean condition, int flag, int x) {
        return condition && flag == x;
    }


}
