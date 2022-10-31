package onboarding;

public class Problem2 {
    public static int[] findDupliIndex(StringBuilder s) {
        int i, j;

        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                break;
        }

        j = i + 1;
        while (j < s.length() && s.charAt(i) == s.charAt(j))
            j++;

        return new int[] { i, j };
    }
    
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);
        
        int[] result;
        do{
            result = findDupliIndex(answer);
        } while (result[0] < answer.length() - 1 && answer.delete(result[0], result[1]) != null);

        return answer.toString();
    }
}
