package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += helper(i);
        }
        return answer;
    }

    public static int helper(int number) {
        int cnt = 0, temp;
        while (number > 0) {
            temp = number % 10;
            number = number / 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                cnt++;
            }
        }
        return cnt;
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int number;
//
//        number = sc.nextInt();
//
//        System.out.println(solution(number));
//
//    }
}
