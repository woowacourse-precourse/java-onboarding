package ExceptionValidation;

//- 입력된 문자가 1 ~ 1000 이하의 길이 인지 판단
//- 입력된 문자가 알파벳인지 판단
//- 입력된 문자가 소문자로 이뤄져 있는지 판단

public class P2ExceptionValidation {

    public static boolean p2ExceptionValidation(String cryptogram){

        return inputBetween1and1000(cryptogram) && inputLowerAlphabet(cryptogram);

    }

    private static boolean inputBetween1and1000(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        }
        return true;
    }

    private static boolean inputLowerAlphabet(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char current = cryptogram.charAt(i);
            if (!('a' <= current && current <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
