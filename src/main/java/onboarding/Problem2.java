package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = clearRepeat(cryptogram);
        return answer;
    }

    private static String clearDupliationWord(String word){
        Boolean dup = false;
        String returnWord = "";
        if (word.length() < 2){
            return word;
        }
        char previousChar = word.charAt(0);
        word += "\0";
        for (int i = 1; i < word.length(); i ++){
            if (previousChar == word.charAt(i)){
                dup = true;
            }
            if (previousChar != word.charAt(i) && dup){
                dup = false;
                previousChar = word.charAt(i);
            }
            if (previousChar != word.charAt(i) && !dup){
                returnWord += previousChar;
            }
            previousChar = word.charAt(i);
        }
        return returnWord;
    }

    private static String clearRepeat(String word){
        boolean flag = true;
        while (flag){
            String temp = clearDupliationWord(word);
            if (temp.equals(word)){
                flag = false;
            }
            word = temp;
        }
        return word;
    }

}
