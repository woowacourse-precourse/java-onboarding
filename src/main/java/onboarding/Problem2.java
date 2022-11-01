package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // 6. String 길이가 남았는지 체크하기
    public static Boolean checkIfStringRemain(String s)
    {
        return (s.length() != 0) ? Boolean.TRUE: Boolean.FALSE;
    }

    // 7. 두 문자가 같은 지 체크하기
    public static Boolean checkIfNotDuplicatedAlphabet(char a, char b)
    {
        return (a == b) ? Boolean.FALSE : Boolean.TRUE;
    }
}
