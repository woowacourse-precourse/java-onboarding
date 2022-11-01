package onboarding;

public class Problem3 {
    public static int solution(int number) {

        //손뼉 횟수 계산 기능
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String str = Integer.toString(i);
            String[] arr = str.split("");

            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("3") || arr[j].equals("6") || arr[j].equals("9")) {
                    answer += 1;
                }
            }

        }

        return answer;
    }
}
