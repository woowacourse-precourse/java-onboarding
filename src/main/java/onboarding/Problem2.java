package onboarding;

public class Problem2 {

    public static StringBuilder sb = new StringBuilder();
    public static String solution(String cryptogram) {
        String answer = "answer";

        deleteRepetition(cryptogram);
        //
        return answer;
    }

    public static String deleteRepetition(String cryptogram) {
        //1.입력 문자열을 순회하며 중복 구간을 찾는다.
        int length = cryptogram.length();

        char prev = cryptogram.charAt(0);
        int sequenceCount = 0;
        boolean isSequence = false;
        for(int i = 1; i < length; i++) {
            if(prev == cryptogram.charAt(i)) {
                sequenceCount++;
                isSequence = true;
            }

            sb.append(prev);

            //2.중복 구간이 끝나면 중복 구간을 StringBuilder 에서 삭제한다.
            if(prev != cryptogram.charAt(i) && isSequence) {
                int currentLength = sb.length();
                sb.delete((currentLength - sequenceCount - 1), currentLength);
                isSequence = false;
                sequenceCount = 0;
            }
            prev = cryptogram.charAt(i);
        }
        sb.append(cryptogram.charAt(length - 1));

        return sb.toString();
    }
}
