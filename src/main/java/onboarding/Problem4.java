package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeWordToFrogWord(word);
        return answer;
    }

    public static String changeWordToFrogWord(String word){
        String changedWord;
        char[] preWord = word.toCharArray();
        char[] postWord = new char[preWord.length];

        /**
         *  ASCII Table
         *  A = 65
         *  Z = 90
         *  a = 97
         *  z = 122
         *  아스키 코드를 활용하여 문자변환
         */
        for(int i=0; i<preWord.length; i++){
            if((preWord[i] >= 'A') && (preWord[i] <= 'Z'))
                postWord[i] = (char) (155 - preWord[i]);
            else if((preWord[i] >= 'a') && (preWord[i] <= 'z'))
                postWord[i] = (char) (219 - preWord[i]);
            else
                postWord[i] = preWord[i];
        }

        changedWord = new String(postWord);
        return changedWord;
    }
}
