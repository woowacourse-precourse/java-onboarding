package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countClapAll(number);
        return answer;
    }
    public static int countClapAll(int number){
        int cnt = 0;
        for ( int i=1; i<= number; i++){
            cnt+=countClap(i);
        }
        return cnt;
    }
    public static int countClap(int number){
        String strNumber = Integer.toString(number);
        int cnt = 0;
        for(int i=0;i<strNumber.length();i++){
            int curnumber = Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            if(curnumber%3 == 0 && curnumber != 0){
                cnt+=1;
            }
        }
        return cnt;
    }
}
