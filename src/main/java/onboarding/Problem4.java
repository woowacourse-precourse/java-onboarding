package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        for (char v: chars) {
            int ascii = (int)v;
            char ch = v;
            if (ascii >= 65 && ascii <= 90) {
                ch = (char)(155 - ascii);
            } else if (ascii >= 97 && ascii <= 122) {
                ch = (char)(219 - ascii);
            }

            answer = answer + ch;
        }
        return answer;
    }
}
// A: 65, Z: 90
// a: 97, z: 122
