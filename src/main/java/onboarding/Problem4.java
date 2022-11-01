package onboarding;

/**
 * 기능명세
 * 1. 대문자 소문자 구분
 * 2. character 변환
 * 3. 새로운 character 입력.
 */
public class Problem4 {
    private static final int NUM_OF_ALPHABET=26;
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            char characterToConvert = word.charAt(i);
            answer.append(convert(characterToConvert));
        }

        return answer.toString();
    }

    public static char convert(char characterToConvert) {
        if (Character.isLowerCase(characterToConvert))
            return convertCharacter('a', characterToConvert);

        if(Character.isUpperCase(characterToConvert))
            return convertCharacter('A', characterToConvert);

        return characterToConvert;
    }
    public static char convertCharacter(char entryPoint, char alphabet){
        return (char)(entryPoint + NUM_OF_ALPHABET-1 - (alphabet-entryPoint));
    }
}
