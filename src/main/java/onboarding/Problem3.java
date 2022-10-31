package onboarding;

public class Problem3 {

    public static int solution(int number) {
        if(checkException(number)){
            throw new IllegalArgumentException();
        }
        return getCount(number);
    }
    public static int getCount(int number){
        int answer = 0;
        for(int i=3;i<=number;i++){
            int tmp=i;
            while(tmp>0){
                if(tmp % 10 != 0 && (tmp % 10)%3 == 0){
                    answer++;
                }
                tmp /= 10;
            }
        }
        return answer;

    }
    public static boolean checkException(int number){
        if(checkNumber(number)){
            return true;
        }

        return false;
    }
    public static boolean checkNumber(int number){
        return number < 1 || number > 1000;
    }
}
