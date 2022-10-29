package onboarding;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(solution(36));
    }

    public static int solution(int number) {
        // 1. 3 6 9 숫자가 몇개 존재하는지 담을 변수 생성
        // 2. 숫자를 하나씩 세면서 해당 숫자내에 3 6 9 가 몇개 있는지 확인하는 메서드 생성
        // 3. 정답 반환

        if (number <= 2) {
            return 0;
        }

        int howManyNums = countHowManyNums(number);;

        return howManyNums;
    }

    private static int countHowManyNums(int number) {
        int tmpHowManyNums = 0;
        String strNumber = "";

        for (int i = 3; i <= number; i++) {
            strNumber = String.valueOf(i);
            for (int j = 0; j < strNumber.length(); j++) {
                if (strNumber.charAt(j) == '3' || strNumber.charAt(j) == '6' || strNumber.charAt(j) == '9') {
                    tmpHowManyNums++;
                }
            }
        }

        return tmpHowManyNums;
    }
}
