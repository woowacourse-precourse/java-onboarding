package onboarding;

public class Problem4 {

    static char changeUpperElement (char element) {
        int elementAscii = element;
        if (elementAscii >= 65 && elementAscii <= 77) {
            elementAscii = 78 + (77 - elementAscii);
        }else if (elementAscii > 77 && elementAscii <= 90) {
            elementAscii = 77 - (elementAscii - 78);
        }
        return (char)elementAscii;
    }

    static char changeLowerElement (char element) {
        int elementAscii = element;
        if (elementAscii >= 97 && elementAscii <= 109) {
            elementAscii = 110 + (109 - elementAscii);
        }else if (elementAscii <= 122 && elementAscii > 109) {
            elementAscii = 109 - (elementAscii - 110);
        }
        return (char)elementAscii;
    }

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char element = word.charAt((i));
            if ((int)element == 32) {
                answer += " ";
            }else if (Character.isUpperCase(element)) {
                answer += changeUpperElement(element);
            }else {
                answer += changeLowerElement(element);
            }
        }
        return answer;
    }
}