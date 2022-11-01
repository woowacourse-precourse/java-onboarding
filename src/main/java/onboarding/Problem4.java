package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = addAnswer(word,answer);

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
    public static String addCharAtAnswer(String answer,int addChar){
        answer+=Character.toString(addChar);
        return answer;
    }
    public static String addAnswer(String word,String answer){

        for(int i = 0; i < word.length(); i++){
            int replace = 0;
            int upper = 155, lower = 219;

            if(checkUpperLower(word.charAt(i)) == 1){
                replace = replaceReverseLetter(upper,(int)word.charAt(i));
                answer = addCharAtAnswer(answer,replace);
            }
            else if(checkUpperLower(word.charAt(i)) == 2){
                replace = replaceReverseLetter(lower,(int)word.charAt(i));
                answer = addCharAtAnswer(answer,replace);
            }
            else
                answer = addCharAtAnswer(answer,word.charAt(i));
        }
        return answer;
    }
}
