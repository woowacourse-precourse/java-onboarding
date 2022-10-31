package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String decry = cryptogram;
        do{
            cryptogram = decry;
            decry = decryption(cryptogram);
        }while (decry.length() != cryptogram.length());


        return cryptogram;
    }

    private static String decryption(String str) {
        String regex = "(([a-zA-Z0-9])\\2{1,})";
        return str.replaceAll(regex, "");
    }
}
