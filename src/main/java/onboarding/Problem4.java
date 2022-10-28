package onboarding;

public class Problem4 {
    /*
    기능 목록
    1. 청개구리 사전에서 A+Z = B+Y…의 방식으로 진행된다. 대문자 A+Z를 상수로 잡고, 여기에서 바꿔야 할 대문자를 뺀 값을 Character타입으로 리턴시킨다.
    2. 소문자도 a+z = b+y…의 방식으로 값이 같다. 소문자도 a+z를 상수로 잡고, 여기에서 바꿔야할 소문자를 뺀 값을 Character타입으로 리턴시킨다.
    3. 대문자일 경우 true를 리턴시키는 메소드를 만든다.
    4. 소문자일 경우 true를 리턴시키는 메소드를 만든다.
    5. 3에서 true일 경우 1의 값을 리턴시키고, 4에서 true일 경우 2의 값을 리턴시킨다. 그 외에는 띄어쓰기만 존재 하므로 그대로 리턴시킨다.
    */

    static final int UPPERCASE_DICTIONARY_SUM = 'A' + 'Z';
    static final int LOWERCASE_DICTIONARY_SUM = 'a' + 'z';
    static final int ALPHABET_LAST_INDEX = 25;
    static final int ALPHABET_START_INDEX = 0;


    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean isUppercase(char nextCharacter){
        if(nextCharacter - 'A' >= ALPHABET_START_INDEX && nextCharacter - 'A' <= ALPHABET_LAST_INDEX)
            return true;
        return false;
    }

    private static char flipUpperCase(char alphabet){
        return (char) (UPPERCASE_DICTIONARY_SUM - alphabet);
    }

    private static char flipLowerCase(char alphabet){
        return (char) (LOWERCASE_DICTIONARY_SUM - alphabet);
    }
}
