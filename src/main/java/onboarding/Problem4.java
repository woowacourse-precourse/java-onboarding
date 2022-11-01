package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char frogConvertNumber = 25;
        char startAlphabetChar = 65;
        char[] letters = word.toCharArray();

        for(char letter:letters) {
            char targetLetter = letter;
            if (Character.isLowerCase(letter)) {
                targetLetter = Character.toUpperCase(letter);
            }


            if (letter >= 65 && letter <= 77) {
                targetLetter = (char) (targetLetter + frogConvertNumber - (targetLetter - startAlphabetChar) * 2);
            } else if (letter >= 78 && letter <= 90) {
                targetLetter = (char) (targetLetter - (frogConvertNumber - (targetLetter - startAlphabetChar) * 2));
            }

            if (Character.isLowerCase(letter)) {
                targetLetter = Character.toLowerCase(targetLetter);
            }
            answer = answer + Character.toString(targetLetter);
        }

        return answer;
    }

}
