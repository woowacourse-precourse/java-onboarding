package onboarding.resolve.problem4;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int idx = 0; idx < word.length(); idx++) {
            answer.append((char)getNew(word.charAt(idx)));
        }
        return answer.toString();
    }

    private static int getNew(int ord) {
        if (ord==32){
            return ord;
        }

        if (ord <= 90) {
            return 90 - (ord - 65);
        }
        return 122 - (ord - 97);

    }
}
