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
    private static boolean isUnchanged(String beforeDecryption, String cryptogram) {
        return (beforeDecryption.equals(cryptogram));
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String beforeDecryption = "";

        while (true) {
            beforeDecryption = cryptogram;
            cryptogram = getDecryption(cryptogram);
            if (isUnchanged(beforeDecryption, cryptogram)) {
                answer = beforeDecryption;
                break;
            }
            System.out.println(beforeDecryption);
        }

        return answer;
    }
}
