package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean flag = true;
        while (flag){
            String temp = clearDupliationWord(cryptogram);
            if (temp.equals(cryptogram)){
                flag = false;
            }
            cryptogram = temp;
        }
        String answer = cryptogram;
        return answer;
    }

    private static String clearDupliationWord(String word){
        Boolean dup = false;
        String returnWord = "";
        if (word.length() < 1){
            return returnWord;
        }
        char duplication = word.charAt(0);
        word += "\0";
        for (int i = 1; i < word.length(); i ++){
            if (duplication == word.charAt(i)){
                dup = true;
            }
            if (duplication != word.charAt(i) && dup){
                dup = false;
                duplication = word.charAt(i);
            }
            if (duplication != word.charAt(i) && !dup){
                returnWord += duplication;
            }
            duplication = word.charAt(i);
        }
        return returnWord;
    }

}
