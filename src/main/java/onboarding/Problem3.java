package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = calc369(number);
        return answer;
    }
    //369 계산 함수 구현
    private static int calc369(int number){
        int result=0;
        for(int i=1; i<=number; i++){
            String num = Integer.toString(i);
            for(int j=0; j<num.length(); j++){
                if((num.charAt(j)-48)%3==0 && (num.charAt(j)-48)!=0){
                    result++;
                }
            }
        }
        return result;
    }
}
