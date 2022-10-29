package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();

        for (int i = 0; word.length() > i; i++) {
            answer+=translateCharacter(chars[i]);
        }
        return answer;
    }


    /**
     * @param character : 문자
     * @return  청개구리 사전으로 번역한 문자, 영어만 번역 되고 나머지는 번역되지 않는다.
     */
    private static char translateCharacter(char character) {
        int ascii = (int)character;
        int result = 0;
        if (ascii >= 65 && ascii <= 90) {
            ascii = (155 - ascii);
        }else if(ascii >= 97 && ascii <= 122){
            ascii = (219 - ascii);
        }
        return (char)ascii;
    }
}
