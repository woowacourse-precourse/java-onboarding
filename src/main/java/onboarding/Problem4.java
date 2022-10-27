package onboarding;

public class Problem4 {

    static class AbnormalDictionary {

        private char findWord(char c) {
            if(!(('a'<=c && c<='z') || ('A'<=c && c<='Z'))) {
                return c;
            }

            int index = 'a'+'z';
            if('A'<=c && c<='Z') {
                index = 'A'+'Z';
            }

            char res = (char)(index - c);
            return res;
        }
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
