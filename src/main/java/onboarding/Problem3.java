package onboarding;
public class Problem3 {
    public static int solution(int number) {
        int answer = Count369InAllNumber(number);
        return answer;
    }
    private static int Count369InAllNumber(int number){// 1부터 number까지 모든 숫자중 3,6,9 개수 확인
        int count;
        count = 0;
        for(int i=1; i<=number; i++){
            count+=CountContainDigit369(i);
        }
        return count;
    }
    private static int CountContainDigit369(int number) {// 숫자에 3,6,9 몇개 있는지 확인
        int lastnum;
        int temp;
        int count=0;
        temp = number;

        while (temp > 0) {
            lastnum = temp % 10;
            temp = temp / 10;
            if(lastnum == 3 || lastnum == 6 || lastnum ==9){
                count++;
            }
        }
        return count;
    }
}
