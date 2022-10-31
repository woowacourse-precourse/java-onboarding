package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //입력한 숫자까지
        for(int i=1; i<=number; i++){
            String numStr = String.valueOf(i);

            //손뼉을 치는 횟수 (숫자에 3, 6, 9가 들어갈 때마다)
            for(int j=0; j<numStr.length(); j++) {
                if(numStr.charAt(j) == 51 | numStr.charAt(j) == 54 | numStr.charAt(j) == 57 )
                    answer += 1;
            }
        }

        return answer;
    }
}
