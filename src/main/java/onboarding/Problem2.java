package onboarding;

public class Problem2 {
    private static StringBuilder sb=new StringBuilder();
    private static String decryption=new String();
    public static String solution(String cryptogram) {
        String answer = "answer";
        return completeDecrypt(cryptogram);
    }

    public static String completeDecrypt(String cryptogram){
        if(cryptogram.length()==1){
            return cryptogram;
        }
        decryption=(error(cryptogram)) ? "" : (Deduplicate(cryptogram).length() == 0) ? Deduplicate(cryptogram) : decrypt(cryptogram);

        return decryption;
    }
}
