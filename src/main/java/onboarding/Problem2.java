package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer answer = new StringBuffer(cryptogram);

        while(true) {
            int sameIdx = getSameIdx(answer);

            if(sameIdx == -1) {
                break;
            }
        }

        return answer.toString();
    }

    private static int getSameIdx(StringBuffer string) {
        char[] charArray = string.toString().toCharArray();

        for(int i=0; i<charArray.length-1; i++) {
            if(charArray[i] == charArray[i+1]) {
                return i;
            }
        }
        return -1;
    }

}