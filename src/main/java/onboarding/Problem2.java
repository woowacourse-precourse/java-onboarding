package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        System.out.println("pr2: " + cryptogram);
        System.out.println("return: " + clearDupliationWord(cryptogram));
        String answer = "answer";
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
