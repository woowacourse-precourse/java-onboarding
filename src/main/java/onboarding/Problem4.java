package onboarding;

public class Problem4 {

    static final int ASCII_LARGE_A = 65;
    static final int ASCII_SMALL_A = 97;

    // A~Z까지 알파뱃 개수
    static final int ALPHABET_COUNT = 26;

    // 암호화된 문자를 저장한 배열
    static final char[] ENCRYPT_ALPHABET = new char[52];

    public static String solution(String word) {
        initEncryptAlphabetArr();
        String answer = encode(word);
        return answer;
    }

    /**
     * ENCRYPT_ALPHABET 배열을 초기화시키는 함수
     * index 0~25 : Z~A
     * index 26~51 : z~a
     */
    private static void initEncryptAlphabetArr(){
        for(int i=0;i<ENCRYPT_ALPHABET.length;i++){
            if(i>=0 && i < ALPHABET_COUNT)
                ENCRYPT_ALPHABET[i] = (char)(ASCII_LARGE_A + ALPHABET_COUNT - (i+1));
            else if(i >= ALPHABET_COUNT && i < ALPHABET_COUNT*2)
                ENCRYPT_ALPHABET[i] = (char)(ASCII_SMALL_A + ALPHABET_COUNT*2 - (i+1));
        }
    }

    /**
     * 평서문을 입력받아 암호화된 문자열을 반환한다.
     * @param word
     * @return String: 암호문
     */
    private static String encode(String word) {
        StringBuilder sb = new StringBuilder(word);
        for(int i=0;i<word.length();i++) {
            int c = sb.charAt(i);

            if (!isAlphabet(c))
                continue;

            if(isLargeAlphabet(c))
                sb.setCharAt(i, ENCRYPT_ALPHABET[c - ASCII_LARGE_A]);
            else if(isSmallAlphabet(c))
                sb.setCharAt(i, ENCRYPT_ALPHABET[c - ASCII_SMALL_A + ALPHABET_COUNT]);
        }
        return sb.toString();
    }

    /**
     * 입력받은 수가 알파벳 아스키코드에 맞는지 확인한다.
     * @param c
     * @return true: 알파뱃일 때 / false: 알파뱃이 아닐 때
     */
    private static boolean isAlphabet(int c) {
        if(isLargeAlphabet(c) || isSmallAlphabet(c))
            return true;
        return false;
    }

    /**
     * 입력받은 수가 소문자 알파벳 아스키코드에 맞는지 확인한다.
     * @param c
     * @return true: 소문자 알파뱃일 때 / false: 소문자 알파뱃이 아닐 때
     */
    private static boolean isSmallAlphabet(int c) {
        if(c >= ASCII_SMALL_A && c < ASCII_SMALL_A + ALPHABET_COUNT)
            return true;
        return false;
    }

    /**
     * 입력받은 수가 대문자 알파벳 아스키코드에 맞는지 확인한다.
     * @param c
     * @return true: 대문자 알파뱃일 때 / false: 대문자 알파뱃이 아닐 때
     */
    private static boolean isLargeAlphabet(int c) {
        if(c >= ASCII_LARGE_A && c < ASCII_LARGE_A + ALPHABET_COUNT)
            return true;
        return false;
    }
}
