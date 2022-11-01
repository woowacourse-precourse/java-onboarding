package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=3; i<= number; i++){
            int temp = i;
            while (temp > 0){
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9 ){
                    answer += 1;
                }
                temp = temp / 10;
            }
//            System.out.println(i+ "까지 박수" + answer);
        }
        return answer;
    }
}
