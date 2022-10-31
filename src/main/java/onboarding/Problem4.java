package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        answer = reverseWord(word);

        return answer;
    }
    public static String reverseWord(String word) {
        StringBuilder result = new StringBuilder();
        for (char currentCharacter : word.toCharArray()) {
            //소문자일경우
            if (checkLowerCase(currentCharacter)) {
                result.append(convertLowerCase(currentCharacter));
                continue;
            }
            //대문자일경우
            if (checkUpperCase(currentCharacter)) {
                result.append(convertUpperCase(currentCharacter));
                continue;
            }
            result.append(currentCharacter);

        }
        return result.toString();
    }

    public static char convertLowerCase(char input) {
        if(input >= 97 && input <=109)
        {
            int gap = (109-input)*2 + 1 ;
            return (char) (input + gap);
        }
        else{
            int gap = (input-110)*-2 - 1 ;
            return (char) (input + gap);
        }
    }

    public static char convertUpperCase(char input) {
        if(input >= 65 && input <=77)
        {
            int gap = (77-input)*2 + 1 ;
            return (char) (input + gap);
        }
        else{
            int gap = (input-78)*-2 - 1 ;
            return (char) (input + gap);
        }
    }

    public static boolean checkUpperCase(char input) {
        return input >= 65 && input <= 90;
    }

    public static boolean checkLowerCase(char input) {
        return input >= 97 && input <= 122;
    }


}
