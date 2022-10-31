package onboarding;

public class Problem2 {
    private static String removeDuplicate(String cryptogram){
        String decryption = "";
        for(int i = 0; i < cryptogram.length() - 1; i++){
            char firstCharacter = cryptogram.charAt(i);
            char secondCharacter = cryptogram.charAt(i + 1);
            if(firstCharacter == secondCharacter) {
                i++;
                continue;
            }
            decryption += String.valueOf(firstCharacter);
            if(i == cryptogram.length() - 2) {
                decryption += String.valueOf(secondCharacter);
            }
        }
        return decryption;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        removeDuplicate(cryptogram);

        return answer;
    }
}
