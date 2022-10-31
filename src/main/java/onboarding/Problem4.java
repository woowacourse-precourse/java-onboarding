package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i= 0; i < word.length(); i++){
            char wordUnit = word.charAt(i);
            int tmpNum = 0;
            char changedWord = wordUnit;


            if ('A' <= wordUnit && wordUnit <= 'Z'){
                tmpNum = 'Z' - wordUnit + 'A';
                changedWord = (char) tmpNum;
            }else if('a' <= wordUnit && wordUnit <= 'z'){
                tmpNum = 'z' - wordUnit + 'a';
                changedWord = (char) tmpNum;
            }
            answer = answer + changedWord;
        }

        return answer;
    }
}
