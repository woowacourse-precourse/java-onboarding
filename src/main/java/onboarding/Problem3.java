package onboarding;

/**
 * 1. 각 숫자가 3,6,9를 포함하는지 확인
 * 2. 1~N까지 반복
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String stringNum ="";
        char temp;

        // 1~N까지 탐색
        for(int i = 1 ; i <= number ; i++){
            stringNum =Integer.toString(i);

            //각 숫자에 3,6,9가 포함되어있는지 확인
            for(int j = 0 ; j < stringNum.length() ; j++){
                temp = stringNum.charAt(j);
                if(temp == '3' || temp == '6' || temp == '9'){
                    answer++;
                }
            }
        }

        return answer;
    }
}
