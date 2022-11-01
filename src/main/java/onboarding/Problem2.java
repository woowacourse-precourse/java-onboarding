package onboarding;

public class Problem2 {
    private static String getDecryption(String cryptogram) {
        String decryption = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (i < cryptogram.length() - 1) {
                char firstCharacter = cryptogram.charAt(i);
                char secondCharacter = cryptogram.charAt(i + 1);
                if (firstCharacter == secondCharacter) {
                    i++;
                    continue;
                }
                decryption += String.valueOf(firstCharacter);
            }
            if (i == cryptogram.length() - 1) {
                decryption += String.valueOf(cryptogram.charAt(cryptogram.length() - 1));
            }
        }
        return decryption;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
