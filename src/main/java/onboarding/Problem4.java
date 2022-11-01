package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return changeWordToFrogWord(word);
    }

    public static String changeWordToFrogWord(String word){
        String changedWord;
        char[] tempWord = word.toCharArray();

        /**
         *  ASCII Table
         *  A = 65
         *  Z = 90
         *  a = 97
         *  z = 122
         *  아스키 코드를 활용하여 문자변환
         */
        for(int i=0; i<tempWord.length; i++){
            if((tempWord[i] >= 'A') && (tempWord[i] <= 'Z'))
                tempWord[i] = (char) (155 - tempWord[i]);
            if((tempWord[i] >= 'a') && (tempWord[i] <= 'z'))
                tempWord[i] = (char) (219 - tempWord[i]);
        }

        changedWord = new String(tempWord);
        return changedWord;
    }
}
