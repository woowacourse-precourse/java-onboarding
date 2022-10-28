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
    public static String solution(String cryptogram) {
    String answer="";
    return answer;
    }
}
