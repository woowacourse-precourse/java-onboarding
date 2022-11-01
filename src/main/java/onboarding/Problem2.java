package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int index = 0, startIndex = -1, lastIndex = -1;
        while(index < cryptogram.length() - 1) {
            if(cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
                startIndex = index;
                lastIndex = getLastIndex(cryptogram, startIndex);
                answer = removeRedundant(cryptogram, startIndex, lastIndex);
                index = startIndex - 1;
            }
            else {
                index++;
            }
        }

        return answer;
    }

    public static int getLastIndex(String str, int sIndex) {

        return -1;
    }

    public static String removeRedundant(String str, int sIndex, int lIndex) {

        return "";
    }
}
