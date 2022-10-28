package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    static final int ASCII_a = 97;
    static final int ASCII_z = 122;

    static final int ASCII_A = 65;
    static final int ASCII_Z = 90;

    static Map<Character, Character> upperMap = new HashMap<>();
    static Map<Character, Character> lowerMap = new HashMap<>();

    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();

        createMap();

        for (int i = 0; i < word.length(); i++) {

            Character currentChar = word.charAt(i);

            if (ASCII_a <= word.charAt(i) && word.charAt(i) <= ASCII_z) {
                answer.append(oppositeLower(currentChar));
            } else if (ASCII_A <= word.charAt(i) && word.charAt(i) <= ASCII_Z) {
                answer.append(oppositeUpper(currentChar));
            } else {
                answer.append(currentChar);
            }
        }

        return answer.toString();
    }

    /**
     * 각 문자의 반대 문자를 빠른 속도로 찾기위한 HashMap 생성하는 메서드
     *
     */
    public static void createMap() {
        //대문자 map
        int upperEnd = ASCII_Z;
        for (int i = ASCII_A; i <= ASCII_Z; i++) {
            upperMap.put((char)i, (char)upperEnd--);
        }

        //소문자 map
        int lowerEnd = ASCII_z;
        for (int i = ASCII_a; i <= ASCII_z; i++) {
            lowerMap.put((char)i, (char)lowerEnd--);
        }
    }

    /**
     * 주어진 문자가 대문자일 경우 생성한 맵에서 반대되는 대문자를 찾아서 리턴하는 메서드
     *
     * @param upperCharacter 현재 대문자
     * @return 반대되는 대문자
     */
    public static Character oppositeUpper(Character upperCharacter) {
        return upperMap.get(upperCharacter);
    }

    /**
     * 주어진 문자가 소문자일 경우 생성한 맵에서 반대되는 소문자를 찾아서 리턴하는 메서드
     *
     * @param lowerCharacter 현재 소문자
     * @return 반대되는 소문자
     */
    public static Character oppositeLower(Character lowerCharacter) {
        return lowerMap.get(lowerCharacter);
    }

}
