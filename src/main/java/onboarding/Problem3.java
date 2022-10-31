package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //369 게임 구현
        // 1부터 number까지의 숫자중 3,6,9의 갯수를 answer에 담아서 return하기

        for (int i = 1; i <= number; i++) {
            String num = String.valueOf(i);

            for (int j = 0; j < num.length(); j++) {
                int temp = Integer.parseInt(String.valueOf(num.charAt(j)));
                if (temp == 3 || temp == 6 || temp == 9) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
