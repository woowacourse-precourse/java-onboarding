package onboarding;

public class Problem2 {

    private static String deleteRepeat(String cryptogram) {
        int length = cryptogram.length();
        if(length <= 1)
            return cryptogram;

        char previousChar = cryptogram.charAt(0);

        for (int i = 1; i < length; i++) {
            if (previousChar == cryptogram.charAt((i))) {
                while (true) {
                    if(length < 2)
                        break;

                    if(previousChar == cryptogram.charAt(i)) {
                        cryptogram = cryptogram.substring(0, i).concat(cryptogram.substring(i + 1));
                        length--;
                    }
                    else{
                        break;
                    }
                }
                cryptogram = cryptogram.substring(0, i - 1).concat(cryptogram.substring(i));
                length--;
                i--;
            }
            if(cryptogram.length() < 2)
                break;
            else
                previousChar = cryptogram.charAt(i);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer;
        while (true) {
            answer = deleteRepeat(cryptogram);
            if (cryptogram.equals(answer)) {
                return answer;
            }
            cryptogram = answer;
        }
    }
}
