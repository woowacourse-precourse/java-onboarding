package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer= Calculate(cryptogram);
        return answer;
    }
    public static int EndPoint(String a,int idx) { // 연속된 문자열의 끝지점을 반환하는 함수
        char tmp = a.charAt(idx);
        int cnt = idx+1;
        while (tmp == a.charAt(cnt)) {
            cnt++;
        }
        return cnt-1;
    }
    public static int check(String a) {
        char tmp = a.charAt(0);
        for(int i=0;i<a.length();i++){
            if(tmp != a.charAt(i)){
                return 0;
            }
        }
        return 1;
    }
    public static String  Calculate(String a) { //재귀함수
        int start =-1;
        int end = -1;
        for (int i=0;i<a.length()-1;i++) {
            if (a.charAt(i)==a.charAt(i+1)) {//연속된 문자열 검사
                if ( check(a) == 1){
                    return "";
                }
                start = i;
                end = EndPoint(a,i);
                break;
            }
        }
        if(start == -1) {
            return a;
        }
        String tmp= ReString(a,start,end);
        return Calculate(tmp);
    }

    // 연속된 문자열 제거하는 함수

    public static String  ReString(String a,int start, int end) {
        return a.substring(0,start)+a.substring(end+1);
    }
}
