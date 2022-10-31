package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(checkNumberRangeException(number)){
            return 0;
        }
        answer = countAllClap(number);
        return answer;
    }

    private static boolean checkNumberRangeException(int number){
        if(number >= 1 && number <= 10000){
            return false;
        }
        return true;
    }
    private static int countAllClap(int number) {
        int clapCnt = 0;
        for(int i=1; i<=number; i++){
            clapCnt += countNumClap(i);
        }
        return clapCnt;
    }

    private static int countNumClap(int num){
        int numClapCnt = 0;
        if(num < 10){
            numClapCnt += contain369(num);
        } else {
            numClapCnt += contain369s(num);
        }
        return numClapCnt;
    }

    private static int contain369(int num){
        if(num == 3 || num == 6 || num == 9){
            return 1;
        }
        return 0;
    }

    private static int contain369s(int num){
        int numClapCnt = 0;
        while(num > 0){
            int temp = num % 10;
            numClapCnt += contain369(temp);
            num/=10;
        }
        return numClapCnt;
    }

}
