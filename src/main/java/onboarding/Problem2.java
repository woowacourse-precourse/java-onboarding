package onboarding;

//-----기능-----
//1. 중복 문자열 찾기
//2. 해당 문자열 제거
//3. 위 기능 반복

public class Problem2 {

    private static int dupStr(String s)    {
        for (int i = 0; i < s.length() - 1; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
                return i;
        }
        return -1;
    }

    public static String solution(String cryptogram) {
        int idx;
        while (true)
        {
            idx = dupStr(cryptogram);
            if (idx == -1)
                break;
            cryptogram = cryptogram.substring(0, idx) + cryptogram.substring(idx + 2);
        }
        return cryptogram;
    }
}
