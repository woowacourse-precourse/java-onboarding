package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteAdjacentOverlap(cryptogram);
    }
    private static boolean ExistAdjacentOverlap(String str){
        char prev = '\0';
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == prev){
                return true;
            }
            prev = str.charAt(i);
        }
        return false;
    }
}
