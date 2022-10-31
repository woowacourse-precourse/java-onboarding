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
                //1의 자리가 3의 배수인지 확인하기
                int threeMod = tenMod%3;
                //3의 배수이면 answer+1 아니면 그대로
                answer = threeMod == 0 ? answer+1 : answer;
                System.out.println("i: "+i+", tenMod: "+tenMod+", threeMod: "+threeMod+", answer: "+answer);
                //tmp/=10
                tmp/=10;
            }
        }

        return answer;
    }
}
