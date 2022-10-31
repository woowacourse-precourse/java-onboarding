package onboarding;

public class Problem3 {

    //입력의 각 자리수에서 3,6,9 개수를 count하여 반환한다.
    public static int getCount(int num){
        int count = 0;
        while(num != 0){
            if(num%10 != 0 && num%10%3 == 0)
                count++;
            num = num / 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<= number; i++){
            answer += getCount(i);
        }

        return answer;
    }
}
