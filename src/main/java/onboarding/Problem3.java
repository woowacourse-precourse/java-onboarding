package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        //1부터 number까지 전체탐색
        for (int i = 1 ; i <= number ; i++){
            //number는 변하면 안되기 때문에 copy생성
            int copy = i;

            //자리수마다 3,6,9가 해당하면 count += 1 해주는 기능
            while(copy > 0) {
                //10으로 나눈 나머지
                int cal = copy % 10;
                //계산
                if(cal == 3 || cal == 6 || cal == 9 ) count += 1;
                //계속해서 10으로 나눈 몫 저장
                copy /= 10;
            }
        }

        int answer = count;
        return answer;
    }
}
