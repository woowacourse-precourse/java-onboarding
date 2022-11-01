package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);

        return answer;
    }

    public static String decrypt(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        boolean toBeDeleted = false;
        int numToBeDeleted = 0;
        int i;
        for (i = 0; i < stringBuilder.length() - 1; i++) {
            if (toBeDeleted) {
                if (stringBuilder.charAt(i) == stringBuilder.charAt(i+1)) {
                    numToBeDeleted++;
                } else {
                    stringBuilder.delete(i - numToBeDeleted + 1, i + 1);
                    i -= numToBeDeleted;
                    numToBeDeleted = 0;
                    toBeDeleted = false;
                }
            } else {
                if (stringBuilder.charAt(i) == stringBuilder.charAt(i+1)) {
                    numToBeDeleted = 2;
                    toBeDeleted = true;
                } else {
                    continue;
                }
            }
        }

        if (toBeDeleted) {
            stringBuilder.delete(i - numToBeDeleted + 1, i + 1);
        }

        String newStr = stringBuilder.toString();
        if (!(newStr.equals(str))) {
            return decrypt(newStr);
        } else {
            return newStr;
        }
    }
}
