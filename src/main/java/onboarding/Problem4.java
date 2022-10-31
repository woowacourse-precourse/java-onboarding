package onboarding;

public class Problem4 {
    public static String changeWord(String word) {
        String value = "";
        char[] charArr = word.toCharArray();
        for(int i = 0; i< charArr.length; i++) {
            if(charArr[i] != ' '){
                char one = charArr[i];
                int num = one;
                int newNum;
                if(num >= 65 && num <= 90) {
                    newNum = 155 - num;
                    char newWord = (char)newNum;
                    value = value + newWord;
                } else if(num >= 97 && num <=122) {
                    newNum = 219 - num;
                    char newWord = (char)newNum;
                    value = value + newWord;
                }
            } else {
                value = value + " ";
            }
        }

        return value;
    }
    public static String solution(String word) {
        String answer = "";
        answer = changeWord(word);
        return answer;
    }
}
