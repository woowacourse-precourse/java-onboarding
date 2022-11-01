package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";



        return answer;
    }
    public static int checkUpperLower(char letter){
        if('A' <= letter && letter <= 'Z')
            return 1;
        else if('a' <= letter && letter <= 'z')
            return 2;
        else
            return 0;
    }
    public static int replaceReverseLetter(int asciiNumber,int originCharNumber){
        int replace = 0;
        replace = asciiNumber - originCharNumber;
        return replace;
    }

}
