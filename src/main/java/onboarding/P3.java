package onboarding;

public class P3 {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(solution(33));
    }

    public static int solution(int number) {
        int answer = 0;
        answer = clap(number);

        return answer;
    }

    public static int clap(int clapNum) {
        int numResult = 0;
//
//        for(int i=0; i<clapNum; i++) {
//            numResult += judgment(i);
//        }
//
        return numResult;
    }

    public static int judgment(int a) {
        String strA = String.valueOf(a);

        int count = 0;
        for(int i=0; i<strA.length(); i++) {
            Character c = strA.charAt(i);
            String strC = String.valueOf(c);

            if(strC.equals("3") || strC.equals("6") || strC.equals("9")) { /**equals로 바꿔보기*/
                count += 1;
            }
        }

        return count;
    }
}
