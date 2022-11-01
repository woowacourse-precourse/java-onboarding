package onboarding;

public class Problem4 {
    private static char conversion(Character cha) {
        //ascii로 계산해서 변환. 알파벳이 아니면 변환 x
        int ascii;
        int changedAscii;
        ascii = (int) cha;

        if (Character.isUpperCase(cha))
            changedAscii = 155 - ascii;
        else if (Character.isLowerCase(cha))
            changedAscii = 219 - ascii;
        else
            changedAscii = ascii;

        return (char) changedAscii;
    }

    public static String solution(String word) {
        char[] wordArr = word.toCharArray();
        char[] changedArr = new char[wordArr.length];

        int i = 0;
        for (Character cha : wordArr) {
            changedArr[i] = conversion(cha);
            i++;
        }
        String answer = new String(changedArr);
        return answer;
    }
}
