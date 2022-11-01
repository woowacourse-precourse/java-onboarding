package onboarding.problem4;

public class Letter {

    public static final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String smallLetters = "abcdefghijklmnopqrstuvwxyz";

    /*
     * 해당 문자가 대문자인지 판별 함수
     */
    public static boolean isCapitalLetter(String character){
        return capitalLetters.contains(character);
    }

    /*
     * 해당 문자가 소문자인지 판별 함수
     */
    public static boolean isSmallLetter(String character){
        return smallLetters.contains(character);
    }

    /*
     * [대문자] 해당 문자의 정반대의 문자 인덱스 반환 함수
     */
    public static int findTheOppositeIndexInCapitalLetters(Character currentCharacter) {
        return capitalLetters.length() - 1 - capitalLetters.indexOf(currentCharacter);
    }

    /*
     * [소문자] 해당 문자의 정반대의 문자 인덱스 반환 함수
     */
    public static int findTheOppositeIndexInSmallLetters(Character currentCharacter) {
        return smallLetters.length() - 1 - smallLetters.indexOf(currentCharacter);
    }

    /*
     * 해당 인덱스의 대문자 반환 함수
     */
    public static char getCapitalLetterByIndex(int index) {
        return capitalLetters.charAt(index);
    }

    /*
     * 해당 인덱스의 소문자 반환 함수
     */
    public static char getSmallLetterByIndex(int index) {
        return smallLetters.charAt(index);
    }
}
