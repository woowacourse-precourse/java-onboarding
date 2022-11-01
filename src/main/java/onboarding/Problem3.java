package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getCount(number);
        return answer;
    }
    
    static int getCount(int num){
        int answer = 0;
        int number = num;
        for(int i=1;i<number+1;i++) {
            int x = i;
            int y = 0;
            while (x != 0) {
                y = x % 10;
                if (y == 3 || y == 6 || y == 9) {
                    answer++;
                    System.out.println(i);
                }
                x = x / 10;
            }
        }
        return answer;
    }
}
