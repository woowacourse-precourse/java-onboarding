package onboarding;

public class Problem4 {

    static char changeUpperElement (char element) {
        int elementascii = element;
        if (elementascii >= 65 && elementascii <= 77) {
            elementascii = 78 + (77 - elementascii);
        }else if (elementascii > 77 && elementascii <= 90) {
            elementascii = 77 - (elementascii - 78);
        }
        return (char)elementascii;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}