package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char ch : word.toCharArray()){
            answer += changeChar(ch);
        }

        return answer;
    }

    public static char changeChar(char ch) {

        char changeCh = ch;

        if( ch >= 65 && ch <= 90){    //대문자변환

            changeCh = (char) (90 - (ch - 65));

            if(ch >= 78) changeCh = (char) (65 + (90 - ch));
        }

        if( ch >= 97 && ch <= 122){    //소문자변환

            changeCh = (char) (122 - (ch - 97));

            if(ch >= 110) changeCh = (char) (97 + (122 - ch));
        }

        return changeCh;
    }
}
