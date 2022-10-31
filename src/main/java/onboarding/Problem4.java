package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        return answer;
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
