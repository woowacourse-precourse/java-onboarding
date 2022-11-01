package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int i=0;
        while (findSameChar(cryptogram) > -1){
            cryptogram = deleteSameChar(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }

    private static String deleteSameChar(String cryptogram) {

        int size = cryptogram.length();
        for (int i = 0; i < size - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                return cryptogram;
            }
        }

        return cryptogram;
    }

    public static int findSameChar(String cryptogram) {

        int size = cryptogram.length();
        for (int i = 0; i < size - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
