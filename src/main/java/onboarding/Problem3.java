package onboarding;

/**
 * 기능
 * 1. String에 3,6,9가 들어가는지 확인
 * 2. 3,6,9가 들어가는 숫자들의 개수 계산
 */
public class Problem3 {
    public static int solution(int number) {
        return clac(number);
    }

    /**
     * 1. 3,6,9가 들어가는지 확인하는 함수
     * @param strNum
     * @return 3,6,9가 들어가면 true 반환
     */
    static boolean checkGame(String strNum){
        for(int i=0;i<strNum.length();i++){
            if(strNum.charAt(i)=='3'||strNum.charAt(i)=='6'||strNum.charAt(i)=='9'){
                return true;
            }
        }
        return false;
    }

    /**
     * 2. 3,6,9가 들어가는 숫자들의 개수 계산 함수
     * @param number
     * @return 손뼉 쳐야하는 수 sum 반환
     */
    static int clac(int number){
        int sum=0;
        for(int num=1; num<number+1;num++){
            String strNum=Integer.toString(num);
            if(checkGame(strNum)==true){
                sum+=1;
            }
        }
        return sum;
    }
}
