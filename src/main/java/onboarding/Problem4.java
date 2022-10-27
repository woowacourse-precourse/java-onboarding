package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] charArr = new char[word.length()];
        int tmp=0;

        for (int i=0; i<word.length(); i++) {
            charArr[i] = word.charAt(i);
        }

        for (int i=0; i<word.length(); i++) {
            if (charArr[i] > 'a' && charArr[i] < 'z') {
                tmp = charArr[i] - 96; // 앞에서부터 몇 번째 캐릭터인지 -> tmp
                charArr[i] = (char)(123 - tmp); // 뒤에서부터 tmp 번째 캐릭터를 대입
            } else if (charArr[i] > 'A' && charArr[i] < 'Z') {
                tmp = charArr[i] - 64;
                charArr[i] = (char)(91 - tmp);
            }
        }

        return new String(charArr);
    }
}
