
package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalClap = 0;
        for (int i=1 ; i<=number ; i++){
            totalClap += getClapCount(i);
        }
        return totalClap;
    }

    //1. 한 자리의 정수가 3, 6, 9 인지 확인하고 true/false 를 반환하는 기능
    private static boolean is369(int n){
        String number = String.valueOf(n);
        if (number.contains("3")){
            return true;
        }
        if (number.contains("6")){
            return true;
        }
        if (number.contains("9")){
            return true;
        }
        return false;
    }

    //2. 전체 자리의 정수의 3, 6, 9개수를 세는 기능(getClapCount)
    private static int getClapCount(int n){
        int clap = 0;
        while(n > 0){
            if(is369(n%10)){
                clap += 1;
            }
            n/=10;
        }
        return clap;
    }
}

