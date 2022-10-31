package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        //solution(5);
        solution(15);
        //solution(297);
        //solution(4444);
    }
    public static int solution(int number) {
        int answer = 0;
        int numLength = 0;
        int countClap = 0;

        for(int i = 1; i <= number; i++) {
            numLength = (int) Math.log10(i)+1;
            System.out.println(numLength);

            switch (numLength) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;

            }
        }

        return answer;
    }
}
