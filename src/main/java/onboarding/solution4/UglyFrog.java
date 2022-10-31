package onboarding.solution4;

public class UglyFrog {
    private static char frogNom(char c){
        if ('a' < c && c < 'm'){
            return (char) ('z' - (c -'a'));
        }
        else if ('m' < c && c < 'z'){
            return (char) ('z' - c);
        }
        else if ('A' < c && c < 'M'){
            return (char) ('Z' - (c - 'A'));
        }
        return (char) ('Z' - c);
    }
    public static String frogWord(String word){
        int length = word.length();
        String result = "";
        for (int i = 0; i < length; i++){
            result += frogNom(word.charAt(i));
        }
        return result;
    }
}
