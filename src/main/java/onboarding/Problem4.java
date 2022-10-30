package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String errorMessage = "[Error] 범위 초과";
        char[] wordArray = word.toCharArray();

        if (word.length()<1 || word.length()>1000) {
            return errorMessage;
        }
        for (int i=0; i<wordArray.length; i++) {
            if (wordArray[i]>='a' && wordArray[i]<='z') {
                answer += (char)('z' -wordArray[i]+'a');
            } else if (wordArray[i]>='A' && wordArray[i]<='Z') {
                answer += (char)('Z' -wordArray[i]+'A');
            } else if (wordArray[i] == ' ') {
                answer += " ";
            }
        }

        return answer;
    }
}
