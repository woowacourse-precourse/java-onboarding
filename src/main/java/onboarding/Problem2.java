package onboarding;

public class Problem2 {
    private static int isContinuousSame(char[] checkString, int startIndex) {
        int sameCount = 0;
        int tempIndex = startIndex + 1;

        while (checkString[tempIndex] == checkString[startIndex]) {
            sameCount++;
            tempIndex++;
        }
        return sameCount;
    }

    private static char[] deleteOnce(char[] inputString) {
        char[] outputString;
        int len = inputString.length;
        int deleteLen = 0;

        for (int i = 0; i + 1 < len;) {
            deleteLen = isContinuousSame(inputString, i);
            if (deleteLen == 0) {
                outputString[i] = inputString[i];
                i++;
                continue;
            }
            i += deleteLen;
        }
        return outputString;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        char[] cryptogramArray = cryptogram.toCharArray();

        cryptogramArray = deleteOnce(cryptogramArray);
        answer = cryptogramArray.toString();

        return answer;
    }
}
