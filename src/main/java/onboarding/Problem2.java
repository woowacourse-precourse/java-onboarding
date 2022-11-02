package onboarding;

public class Problem2 {
    public static boolean checkExistDuplicateChars(String string) {
        for (int index = 0; index < (string.length() - 1) ; index++) {
            if (string.charAt(index) == string.charAt(index + 1)) {
                return true;
            }
        }

        return false;
    }

    public static int getNextIndex(String string, int startIndex) {
        int nextIndex = startIndex;

        for(int index = startIndex + 1; index < string.length() ; index++) {
            if(string.charAt(startIndex) != string.charAt(index)) {
                return index;
            }
        }
        return nextIndex;
    }

    public static String removeDuplicateChars(String string) {
        StringBuilder result =new StringBuilder();
        int index = 0;

        while(index < string.length()) {
            if(0 == getNextIndex(string, index)) {
                result.append("");
                return result.toString();
            }
            if(index + 1 == getNextIndex(string, index)) {
                result.append(string.charAt(index));
                index = getNextIndex(string, index);
                continue;
            }
            if(string.length() - 1 == getNextIndex(string, index)) {
                index = getNextIndex(string, index);
                result.append(string.charAt(index));
                return result.toString();
            }
            if(index == getNextIndex(string, index)) {
                return result.toString();
            }
            index = getNextIndex(string, index);
        }

        return result.toString();
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        while (checkExistDuplicateChars(cryptogram)) {
            cryptogram = removeDuplicateChars(cryptogram);
        }
        answer = cryptogram;

        return answer;
    }
}
