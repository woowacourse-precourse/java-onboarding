package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String momWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String reverseWord = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String answer = "";
        for(char c : word.toCharArray()){
            if(!Character.isAlphabetic(c)){
                answer += c;
                continue;
            }
            //대문자인 경우
            if(Character.isUpperCase(c)){
                int index = momWord.indexOf(c);
                answer += reverseWord.charAt(index);
                continue;
            }
            //소문자인 경우
            if(Character.isLowerCase(c)){
                int index = momWord.indexOf(c - 32);
                answer += (char)(reverseWord.charAt(index) + 32);
            }

        }
        return answer;
    }
}
