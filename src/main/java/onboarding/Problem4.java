package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            answer += reverseLetter(word.charAt(i));
        }

        return answer;
    }

    public static char reverseLetter(char letter){
        char result=' ';
        String lowcaseword = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if(!Character.isAlphabetic(letter)){
            return letter;
        }
        else if(Character.isLowerCase(letter)){
            int index = lowcaseword.indexOf(letter);
            result = lowcaseword.charAt( (lowcaseword.length()-1) - index );
        }
        else if (Character.isUpperCase(letter)) {
            int index = uppercaseword.indexOf(letter);
            result = uppercaseword.charAt( (uppercaseword.length()-1) - index );
        }

        return result;
    }
}
