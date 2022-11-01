package onboarding;

public class Problem4 {

    // 대문자 알파벳 변환하는 메서드
    static char changeUpperElement (char element) {
        int elementAscii = element;
        if (elementAscii >= 65 && elementAscii <= 77) {
            elementAscii = 78 + (77 - elementAscii);
        }else if (elementAscii > 77 && elementAscii <= 90) {
            elementAscii = 77 - (elementAscii - 78);
        }
        return (char)elementAscii;
    }

    // 소문자 알파벳 변환하는 메서드
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

        // 주어진 문자열의 각 문자를 거치며ㅎ 변환
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