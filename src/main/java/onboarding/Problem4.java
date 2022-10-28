package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordList = word.toCharArray();


        String answer = getWords(wordList);
        return answer;
    }

    private static String getWords(char[] wordList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordList.length; i++) {
            if (Character.isWhitespace(wordList[i])) {
                sb.append(" ");
                continue;
            }
            if(Character.isUpperCase(wordList[i])){
                sb.append((char)(155-(int) wordList[i]));
            } else {
                sb.append((char)(219-(int) wordList[i]));
            }
            System.out.println(sb);
        }
        return sb.toString();
    }

}
