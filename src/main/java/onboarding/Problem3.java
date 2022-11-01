package onboarding;
//1부터 주어진 숫자까지 count하는 메소드
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer=clapcount(number);
        return answer;
    }
    public static int clapcount(int number){
        int count=0;

        for(int i=1;i<=number;i++) {
            int temp=i;
            while(temp!=0){
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
                    count++;
                }
                temp/=10;
            }
        }
        return count;
    }
}
