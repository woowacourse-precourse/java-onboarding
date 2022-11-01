package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++){
            int term = i;
//            System.out.println("term = i = " + term);
            while(term > 0) {
                if ((term % 10) != 0 && (term % 10) % 3 == 0) {
                    answer++;
//                    System.out.println("answer = " + answer);
                }
                term /= 10;
//                System.out.println("in while, term = " + term);
            }
        }

        return answer;
    }
}
