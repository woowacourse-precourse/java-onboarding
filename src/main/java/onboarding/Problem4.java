package onboarding;

public class Problem4 {
    public static char reverseCharacter(int asciiValue, int startNumber, int endNumber) {
        return (char) (asciiValue + (startNumber - asciiValue) + (endNumber - asciiValue));
    }

    public static String solution(String word) {
        String answer = "";

        int lowerStart = 'a';
        int lowerEnd = 'z';

        int upperStart = 'A';
        int upperEnd = 'Z';

        for (char character: word.toCharArray()) {
            int asciiValue = character;
            String reversedCharacter;
            if (asciiValue >= lowerStart && asciiValue <= lowerEnd) {
                reversedCharacter = Character.toString(reverseCharacter(asciiValue, lowerStart, lowerEnd));
            } else if (asciiValue >= upperStart && asciiValue <= upperEnd) {
                reversedCharacter = Character.toString(reverseCharacter(asciiValue, upperStart, upperEnd));
            } else {
                reversedCharacter = Character.toString(character);
            }

            answer = answer.concat(reversedCharacter);
        }

        return answer;
    }
}
