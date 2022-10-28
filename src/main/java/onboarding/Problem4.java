package onboarding;

public class Problem4 {
    /*
     * 기능 정리
     * 1. 대문자,소문자를 나눠 문자매핑 시키기 (array의 0~25 index 번호를 각 알파벳을 의미하는 수로 사용하고,각 index 안에는 해당 매핑시킬 알파벳 아스키 코드값 할당)
     * 2. 매핑 배열을 가지고 문자열 변환하기
     * */

    static int upperCase[] = new int[26];
    static int lowerCase[] = new int[26]; // private or protected 정의 하는 것 생각할 것. static 항상 붙어야 하는 이유도 알아낼 것

    static void setLetterCaseMappingTable() {
        for (int i = 0; i < 26; i++) {
            upperCase[i] = 'Z' - i;
            lowerCase[i] = 'z' - i;
        }
    }

    static String getChangedString(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                newStr += (char)upperCase[ch - 'A'];
            } else if (Character.isLowerCase(ch)) {
                newStr += (char)lowerCase[ch - 'a'];
            } else if (Character.isSpaceChar(ch)) {
                newStr += ' ';
            }
        }

        return newStr;
    }

    public static String solution(String word) { // 문자열인데 이름을 word로 해놓은 이유
        setLetterCaseMappingTable();
        String answer = getChangedString(word);
        return answer;
    }
}
