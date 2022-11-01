package onboarding;

public class Problem3 {
    public static char numbers[] = {'3','6','9'};
    //숫자에 3 또는 6 또는 9 가 몇개 포함되어 있는지 반환한다.
    public static int cntThreeSixNine(String numberstring){
        int cnt=0;
        for(int i=0; i<numbers.length; i++){
            cnt = cnt + numberstring.length() - numberstring.replace(String.valueOf(numbers[i]), "").length();
        }
        return cnt;
    }
    public static int solution(int number) {
        int ans=0;
        int cnt=0;
        String numberstring = "";
        for(int i=1; i<=number; i++) {
            numberstring = Integer.toString(i);
            cnt = cntThreeSixNine(numberstring);
            ans = ans + cnt;
        }
        return ans;
    }
}

