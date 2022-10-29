package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] upper = new char[26];
        char[] lower = new char[26];
        for(int i=25, j=0; i>=0; i--,j++){
            upper[i] = (char)('A'+j);
            lower[i] = (char)('a'+j);
        }
        return answer;
    }
}
