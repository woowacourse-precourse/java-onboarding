package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String changedString = "";

        /* 문자일 경우에는 변환*/
            /* 대문자인 경우*/
            /* 소문자인 경우로 나누어서 진행*/
        for( int i = 0; i < word.length(); i++ ){
            char character = word.charAt(i);
            char changedCharacter = character;

            //대문자인 경우
            if( character>=65 && character <= 90 ){

                changedCharacter = changeString(character);

            }//소문자인 경우
            else if( character>=97 && character <= 122 ){

                character = (char)(character - 32);
                changedCharacter = (char)(changeString(character) + 32);

            }
            changedString += changedCharacter;

        }
        String answer = changedString;
        return answer;
    }

    /*대문자 기준 문자변환*/
    private static char changeString(char character){
        String before = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String after = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        int index = before.indexOf(character);
        return after.charAt(index);
    }
}
