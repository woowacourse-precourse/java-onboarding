package onboarding;

public class Problem2 {

    static char[] cryptogramArray = cryptogram.toCharArray();
    static int cryptogramPointer = 0;
    static int continuityStart=0; static int continuityEnd=0;

    public static int howManyZero(int start,int frontOrBack) {
        int cnt = 0;
        if (frontOrBack==1) {
            for (int i=start; i<cryptogramArray.length; i++) {
                if (cryptogramArray[i]=='0') {
                    cnt++;
                }
            }
        } else if (frontOrBack==0) {
            for (int i=start; i>0; i--) {
                if (cryptogramArray[i]=='0') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void continuityToZero(int start, int end) {
        for (int i = start; i <= end; i++) {
            cryptogramArray[i] = '0';
        }
    }
    public static void charArrayToString() {
        for (int i=0; i<cryptogramArray.length; i++) {
            if (cryptogramArray[i]!='0') {
                answer = answer + cryptogramArray[i];
            }
        }

    public static String solution(String cryptogram) {
    String answer="";
    return answer;
    }
}
