package onboarding;

public class Problem2 {

    public static StringBuilder sb;
    public static String solution(String cryptogram) {

        boolean hasRepetition = true;
        //3.문자열 내에 중복되는 문자가 없을 때까지 반복한다.
        while(hasRepetition && !cryptogram.isBlank()) {
            hasRepetition = deleteRepetition(cryptogram, cryptogram.length());
            cryptogram = sb.toString();
        }

        //4.중복되는 문자가 없다면 반복을 종료하고 결과 문자열을 출력한다.
        return sb.toString();
    }

    public static boolean deleteRepetition(String cryptogram, int length) {
        //1.입력 문자열을 순회하며 중복 구간을 찾는다.
        sb = new StringBuilder();
        char prev = cryptogram.charAt(0);
        int sequenceCount = 0;
        boolean isSequence = false;
        boolean hasSequence = false;

        for(int i = 1; i < length; i++) {
            if(prev == cryptogram.charAt(i)) {
                sequenceCount++;
                isSequence = true;
                hasSequence = true;
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
        if(prev == cryptogram.charAt(length - 1) && isSequence) {
            int currentLength = sb.length();
            sb.delete((currentLength - sequenceCount - 1), currentLength);
            isSequence = false;
            sequenceCount = 0;
        }

        return hasSequence;
    }
}