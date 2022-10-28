package onboarding;

/**
 *
 * 각 알파벳을 모두 순회한다.
 * 이때 고려할 것은 알파벳인지, 알파벳이라면 대문자인지 소문자인지 구분해야 되는 것.
 * 1. 대문자 소문자 구분
 * 2. character 변환
 * 3. 새로운 character 입력.
 */
public class Problem4 {
    private static final int NUM_OF_ALPHABET=26;
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char convertCharacter(char entryPoint, char alphabet){
        return (char)(entryPoint + NUM_OF_ALPHABET-1 - (alphabet-entryPoint));
    }
}
