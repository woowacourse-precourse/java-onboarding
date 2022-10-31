package onboarding;

public class Problem4 {
    static class Gram {
        String word;

        public Gram(String word) throws Exception {
            if (!isValidGram(word.length())) throw new Exception("Wrong String");
            this.word = word;
        }

        private boolean isValidGram(int n) {
            return n > 0 && n <= 1000;
        }


    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
