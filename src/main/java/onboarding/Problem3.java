package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getClapCnt(number);
        return answer;
    }

    // number의 박수 총 박수 횟수 구하기
    private static int getClapCnt(int number) {
        int clapCnt = 0;
        for(int i=1; i<=number; i++){
            clapCnt += getNumberClapCnt(i);
        }
        return clapCnt;
    }

    // 입력받은 수의 박수 횟수 구하기
    private static int getNumberClapCnt(int num){
        int numClapCnt = 0;
        if(num < 10){
            numClapCnt += check369UnderTen(num);
        } else {
            numClapCnt += check369AboveTen(num);
        }
        return numClapCnt;
    }

    // 10 미만의 수에 369 포함 체크
    private static int check369UnderTen(int num){
        if(num == 3 || num == 6 || num == 9){
            return 1;
        }
        return 0;
    }

    // 10 이상의 수에 369 포함 체크
    private static int check369AboveTen(int num){
        int numClapCnt = 0;
        while(num > 0){
            int temp = num % 10;
            numClapCnt += check369UnderTen(temp);
            num/=10;
        }
        return numClapCnt;
    }

}
