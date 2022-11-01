package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        StringBuilder input = new StringBuilder(cryptogram);
        boolean chk = true;
        while(chk) {
            chk = checkDuplicatedAndDelete(input);
        }
        cryptogram = input.toString();
        return cryptogram;
    }


    // 문자열에서 연속되는 문자를 삭제하는 메서드
    private static boolean checkDuplicatedAndDelete(StringBuilder input) {
        boolean chk = false;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                input.deleteCharAt(i);
                input.deleteCharAt(i);
                i--;
                chk = true;
            }
        }
        return chk;
    }
}