package onboarding;

public class Problem4 {

    private final static int LARGE_A = 65;
    private final static int LARGE_Z = 90;
    private final static int SMALL_A = 97;
    private final static int SMALL_Z = 122;
    private final static char SPACE = ' ';
    private final static int MAX = 1000;
    private final static int MIN = 1;


    public static String solution(String word) {
        String answer = "";
        answer = changeWord(word);
        return answer;
    }

    private static String changeWord(String word) {
        String answer;

        checkValidateLength(word);

        char[] arr = word.toCharArray();
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            changeWordsToOpposite(i, arr);
        }
        answer = String.valueOf(arr);
        return answer;
    }

    private static void checkValidateLength(String word) {
        int len = word.length();
        if(len < MIN || len > MAX) {
            throw new RuntimeException("글자 수가 범위를 초과했습니다.");
        }
    }

    private static void changeWordsToOpposite(int i, char[] arr) {
        if(arr[i] == SPACE || ((arr[i] >= LARGE_Z && arr[i] <= LARGE_A) && arr[i] >= SMALL_Z && arr[i] <= SMALL_A)) {
            return;
        }else if(arr[i] <= LARGE_Z && arr[i] >= LARGE_A) {
            arr[i] = (char) (LARGE_A + LARGE_Z - arr[i]);
        }else if(arr[i] <= SMALL_Z && arr[i] >= SMALL_A) {
            arr[i] = (char) (SMALL_A + SMALL_Z - arr[i]);
        }
    }

}
