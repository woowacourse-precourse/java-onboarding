package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            int check = isCheckCase(word.charAt(i));
        }
        return answer;
    }

    private static int isCheckCase(Character checkWord){
        if(Character.isUpperCase(checkWord)) return 1;
        if(Character.isLowerCase(checkWord)) return 2;
        return 0;
    }
}
