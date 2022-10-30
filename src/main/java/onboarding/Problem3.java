package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i =1 ; i <number+1; i++){
            answer+=count(i);
        }

        return answer;
    }

    //커밋1. 숫자에 3,6,9 있는지 세기
    public static int count(int num){
        int count = 0;
        while(num !=0){
            if(num%10%3 ==0 && num%10 != 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

}
