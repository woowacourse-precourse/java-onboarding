package onboarding;

public class Problem3 {
    /*
    * 1. 매개 변수를 입력 받는데 매개 변수는 10,000 이하의 자연수 이다.
    * 2. 매개 변수에서 3,6,9가 들어가는 수가 있으면 손뼉을 친다.
    * 3. 결과를 반환한다.
    * */
    public static int solution(int number) {
        int answer = 0;

        if(number > 10000 || number < 0){
            throw new RuntimeException("규칙에 위반됩니다.");
        }

        for (int i = 0; i <= number; i++) {
            if((Integer.toString(i).indexOf("3") != -1) || (Integer.toString(i).indexOf("6") != -1)||(Integer.toString(i).indexOf("9") != -1)){
                answer += Integer.toString(i).chars().filter(c -> c == '3').count();
                answer += Integer.toString(i).chars().filter(c -> c == '6').count();
                answer += Integer.toString(i).chars().filter(c -> c == '6').count();
            }
        }
        return answer;
    }
}
