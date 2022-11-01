package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String modifiedString = cryptogram;

        while(true) {
            int length = modifiedString.length();
            if (isLengthShort(length)) break;

            char prev = prevInit(modifiedString);
            String s = stringInit(prev);

            for (int i = 1; i < length; i++) {
                char now = modifiedString.charAt(i);

                s = avoidOverlapping(now, prev, s);
                prev = now;
            }
            if (modifiedString.equals(s)) break;
            modifiedString = s;
        }
        return modifiedString;
    }
    static boolean isLengthShort (int length) {
        return length < 2;
    }
    static char prevInit (String s) { return s.charAt(0); }
    static String stringInit (char c) {
        return c + "";
    }
    static String avoidOverlapping (char now, char prev, String s) {
        // 중복되는 경우는 modifiedString에 추가하지 않습니다.
        // 이 경우, 기존에 추가되는 문자가 중복인 경우가 중복 경우마다 존재하기에, 제거합니다.
        if (isLengthNotShort(s) && isOverlapedChar(s, now))
            return s.substring(0, s.length() - 1);
        if (isNotOverlap(now, prev))
            return s + now;
        return s;
    }
    static boolean isNotOverlap (char now, char prev) {
        return now != prev;
    }

    // 이전 비교에서 추가된 문자가 현재 비교하는 문자와 중복인 여부를 반환합니다.
    static boolean isOverlapedChar (String s, char now) {
        return s.charAt(s.length() - 1) == now;
    }
    static boolean isLengthNotShort (String s) { return s.length() > 0; }
}
