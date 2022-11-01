package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteAdjacentOverlap(cryptogram);
    }

    private static String deleteAdjacentOverlap(String str){
        if (!ExistAdjacentOverlap(str))
            return str;
        char prev = '\0';
        String new_str = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == prev || str.charAt(i) == str.charAt(i + 1)){

                prev = str.charAt(i);
                i += 1;
                continue;
            }
            prev = str.charAt(i);
            new_str += prev;
        }
        if (str.charAt(str.length() - 1) != prev)
            new_str += str.charAt(str.length() - 1);
        return (deleteAdjacentOverlap(new_str));
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
