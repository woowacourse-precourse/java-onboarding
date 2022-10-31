package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        //solution(5);
        solution(33);
        //solution(297);
        //solution(4444);
    }
    public static int solution(int number) {
        int answer = 0;
        int numLength;
        int countClap = 0;

        for(int i = 1; i <= number; i++) {
            numLength = (int) Math.log10(i)+1;

            switch (numLength) {
                case 1:
                    if(i % 3 == 0)
                        countClap++;
                    break;
                case 2:
                    int[] arrDouble = new int[2];
                    arrDouble[0] = i / 10;
                    arrDouble[1] = i % 10;

                    if(arrDouble[0] % 3 == 0)
                        countClap++;
                    if(arrDouble[1] % 3 == 0 && arrDouble[1] != 0)
                        countClap++;

                    break;
                case 3:
                    //System.out.println("three");
                    break;
                case 4:
                    //System.out.println("four");
                    break;

            }
        }
        answer = countClap;
        return answer;
    }
}
