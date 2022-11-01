package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 1. Initialized answer as StringBuilder
        StringBuilder answer = new StringBuilder();

        // 2. Reverse all digits with ascii
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            if (currLetter == ' ') {    // a. spaces
                answer.append(currLetter);
            } else if (currLetter >= 97 && currLetter <= 122){  // b. lowercase letters
                answer.append((char) (219 - currLetter));
            } else {    // c. uppercase letters
                answer.append((char) (155 - currLetter));
            }
        }
        // 3. Return answer in String
        return answer.toString();
    }
}
