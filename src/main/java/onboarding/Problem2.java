package onboarding;

public class Problem2 {

    private static String removeRepeatedChar(String cryptogram) {
        boolean flag = false;
        int lidx = 0;
        int ridx = 0;
        for (int i=1; i<cryptogram.length(); i++) {
            if ((flag) && (cryptogram.charAt(i) != cryptogram.charAt(i-1))) {
                ridx = i;
                break;
            }
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                char repeatedChar = cryptogram.charAt(i);
                lidx = i-1;
                flag = true;
            }
        }
        if (flag) {
            return cryptogram.replace(cryptogram.substring(lidx, ridx), "");
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String cryptogramAddedSpace = cryptogram += " ";
        boolean flag = true;

        while (flag) {
            int beforeLength = cryptogramAddedSpace.length();
            cryptogramAddedSpace = removeRepeatedChar(cryptogramAddedSpace);
            int afterLength = cryptogramAddedSpace.length();

            if (beforeLength == afterLength) {
                flag = false;
            }

            if (cryptogramAddedSpace.length() <= 1) {
                break;
            }
        }
        return cryptogramAddedSpace.replace(" ", "");
    }
}
