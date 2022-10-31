package onboarding;

public class Problem2 {

    private static boolean IsSmallAlpha(char c)
    {
        return 'a' <= c && c <= 'z';
    }

    private static boolean checkParam(String s)
    {
        if (s == null)
            return true;
        for (int i=0; i<s.length(); i++)
            if (!IsSmallAlpha(s.charAt(i)))
                return true;
        return false;
    }

    private static String makeAnswer(String cryptogram) {
        char index;
        int cnt;
        int length = cryptogram.length();
        String nextCryptogram = "";

        for (int i = 0; i < length; i++) {
            cnt = 0;
            index = cryptogram.charAt(i);
            for (int j = i + 1; j < length; j++){
                if (index != cryptogram.charAt(j)) {
                    break;
                }
                cnt++;
            }
            if (cnt == 0) {
                nextCryptogram += index;
            } else {
                i += cnt;
            }
        }
        if (nextCryptogram.equals(cryptogram)) {
            return cryptogram;
        } else {
            return makeAnswer(nextCryptogram);
        }
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        if (checkParam(cryptogram))
            return "";
        answer = makeAnswer(cryptogram);
        return answer;
    }
}
