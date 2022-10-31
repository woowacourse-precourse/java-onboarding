package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordCharArray = word.toCharArray();
        for(int i = 0; i < wordCharArray.length; i ++){
            if (wordCharArray[i] <= 90 && wordCharArray[i] >= 65) {
                wordCharArray[i] = (char) ('A'+'Z' - wordCharArray[i]);
            }
            else if(wordCharArray[i] <= 122 && wordCharArray[i] >= 97){
                wordCharArray[i] = (char) ('a'+'z' - wordCharArray[i]);
            }
        }
        return String.valueOf(wordCharArray);
    }
}
