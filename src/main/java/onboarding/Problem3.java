package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 369게임 1부터 주어진 숫자 number 까지 반복
        for(int i=1; i<=number; i++) {
            // 임시 변수 tmp
            int tmp = i;
            System.out.println("tmp: "+tmp);

            //tmp가 0이 될 때까지 반복
            while(tmp!=0) {
                //1의 자리 만들기
                int tenMod = tmp%10;
                //만약 1의 자리가 0이면 tmp/=10
                if(tenMod==0) {
                    tmp/=10;
                    continue;
                }
            }
        }

        return answer;
    }
}
