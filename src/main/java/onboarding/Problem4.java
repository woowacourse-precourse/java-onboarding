package onboarding;

public class Problem4 {

    public static String solution(String sentence) {
        try {
            validate(sentence);
            String answer = getReverseSentence(sentence);
            return answer;
        } catch (Exception e) {
            System.out.println(e);
            return "Wrong input";
        }
    }

    static String getReverseSentence(String sentence) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);
            char reversedCharacter = Dictionary.getReverseCharacter(character);
            builder.append(reversedCharacter);
        }
        String reverseSentence = builder.toString();
        return reverseSentence;
    }

    static void validate(String sentence) throws Exception {
        int length = sentence.length();
        if (length < 1 || length > 1000) {
            throw new Exception("길이가 1 이상 1000 이하인 문자열만 입력할 수 있습니다");
        }
    }
}

class Dictionary {

    static char getReverseCharacter(char character) {
        int ascii = character;
        int reverseAscii = getReverseByAscii(ascii);
        char reverseCharacter = (char) reverseAscii;
        return reverseCharacter;
    }

    static int getReverseByAscii(int ascii) {
        int reverseAscii = ascii;
        if (ascii >= 65 && ascii <= 90) {
            reverseAscii = 90 - (ascii - 65);
        }
        if (ascii >= 97 && ascii <= 122) {
            reverseAscii = 122 - (ascii - 97);
        }
        return reverseAscii;
    }
}
