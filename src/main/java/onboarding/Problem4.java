package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            int check = isCheckCase(word.charAt(i));
            if(check == 0) answer += anotherCase(word.charAt(i));
            if(check == 1) answer += upperCase(word.charAt(i));
            if(check == 2) answer += lowerCase(word.charAt(i));
        }
        return answer;
    }

    private static int isCheckCase(Character checkWord){
        if(Character.isUpperCase(checkWord)) return 1;
        if(Character.isLowerCase(checkWord)) return 2;
        return 0;
    }

    private static Character upperCase(Character upperWord){
        int upper = 155 - upperWord;
        char upperChar = (char) upper;
        return upperChar;
    }

    private static Character lowerCase(Character lowerWord){
        int lower = 219 - lowerWord;
        char lowerChar = (char) lower;
        return lowerChar;
    }

    private static Character anotherCase(Character another){
        return another;
    }
}
