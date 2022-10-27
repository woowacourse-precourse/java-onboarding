package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    private static boolean[] checkDuplicate(String cryptogram) {
        boolean duplicates[] = new boolean[cryptogram.length()];

        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1)) {
                duplicates[i] = true;
                duplicates[i+1] = true;
            }
        }
        return duplicates;
    }
}
