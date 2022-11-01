package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int index = 0;
        int end = 0;
        while(index < cryptogram.length()) {
            end = dupEndIndex(cryptogram, index);
            answer = removeSubstring(cryptogram, index, end);
            // 제거해야 할 문자가 있는 경우 cryptogram에서 중복 문자 제거.
            cryptogram = (answer==null) ? cryptogram : answer;
            // 제거했다면 다시 처음부터 중복 문자를 조사하기 위해 index를 0으로 초기화.
            // 연속 중복 문자가 없었다면 다음 문자부터 조사하기 위해 index+=1.
            index = (answer==null) ? ++index : 0;
        }
        answer = cryptogram;
        return answer;
    }

    /** start부터 end까지의 연속으로 중복된 문자열을 삭제한 문자열 반환, 삭제한 문자열이 없다면 null을 반환합니다. */
    private static String removeSubstring(String str, int start, int end) {
        if (end > start)
            return str.substring(0, start) + str.substring(end+1, str.length());
        else
            return null;
    }

    /** start로부터 연속으로 중복된 문자가 존재하는 마지막 인덱스를 반환합니다. */
    private static int dupEndIndex(String cryptogram, int start) {
        int end = start;
        while ( (end+1<cryptogram.length()) && (cryptogram.charAt(end)==cryptogram.charAt(end+1)) )
            end++;
        return end;
    }
}
