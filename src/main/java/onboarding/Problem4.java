package onboarding;

public class Problem4 {

    private static final Problem4 problem = new Problem4();

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if(problem.validation(now)) {
                now = problem.decrypt(now);
            }
            answer.append(now);
        }

        return answer.toString();
    }

    private boolean validation(char input) {
        return ('A' <= input && input <= 'Z') || ('a' <= input && input <= 'z');
    }

    private char decrypt(char input) {
        int diff;
        if(input <= 'Z') {
            diff = 'Z' - input;
            return (char)('A' + diff);
        }
        else {
            diff = 'z' - input;
            return (char)('a' + diff);
        }
    }
}
