package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 지정 횟수만큼 반복문을 돌아서 3,6,9가 있을 때마다 answer에 1씩 더해줌
        for (int i = 1; i < number+1; i++) {
            String temp = Integer.toString(i);
            for (int j = 0; j < temp.length(); j++){
                if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
                    answer++;
                }

            }
        }
        return answer;
    }
}
