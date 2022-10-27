package onboarding;

public class Problem4 {
    // A: 65, a: 97
    static final char[] ENCRYPT_ALPHABET = new char[26];
    public static String solution(String word) {
        init();
        String answer = encode(word);
        return answer;
    }

    private static void init(){
        for(int i=0;i<ENCRYPT_ALPHABET.length;i++){
            ENCRYPT_ALPHABET[i] = (char)(90 - i);
            System.out.println(ENCRYPT_ALPHABET[i]);
        }
    }

    private static String encode(String word) {
        return null;
    }


}
