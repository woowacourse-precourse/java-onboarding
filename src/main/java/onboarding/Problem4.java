package onboarding;

public class Problem4 {
    public static String getWord(String word) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < word.length(); index++) {
            result.append(getCharacter(word.charAt(index)));
        }

        return result.toString();
    }

    public static Character getCharacter(Character alphabet) {
        int gap = 25;
        for (int ascii = (int)'a'; ascii <= (int)'m'; ascii++) {
            if ((char)ascii == alphabet) {
                return (char)((int)alphabet + gap);
            }
            gap -= 2;
        }
        gap = 25;
        for (int ascii = (int)'A'; ascii <= (int)'Z'; ascii++) {
            if ((char)ascii == alphabet) {
                return (char)((int)alphabet + gap);
            }
            gap -= 2;
        }
        gap = 1;
        for (int ascii = (int)'n'; ascii <= (int)'z'; ascii++) {
            if ((char)ascii == alphabet) {
                return (char)((int)alphabet - gap);
            }
            gap += 2;
        }
        gap = 1;
        for (int ascii = (int)'N'; ascii <= (int)'Z'; ascii++) {
            if ((char)ascii == alphabet) {
                return (char)((int)alphabet - gap);
            }
            gap += 2;
        }

        return alphabet;
    }

    public static String solution(String word) {
        String answer = "";
        answer = getWord(word);
        return answer;
    }
}
