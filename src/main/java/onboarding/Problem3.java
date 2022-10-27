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
        String strnumber = Integer.toString(number);
        int cnt = 0;
        for(int i=0;i<strnumber.length();i++){
            String curnumber = String.valueOf(strnumber.charAt(i));
            if(Integer.parseInt(curnumber) %3 ==0){
                cnt+=1;
            }
        }
        return cnt;
    }
}
