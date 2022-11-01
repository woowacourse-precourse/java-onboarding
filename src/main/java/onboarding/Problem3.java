package onboarding;
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private int CountContainDigit369(int number) {// 숫자에 3,6,9 몇개 있는지 확인
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
