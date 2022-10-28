package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        checkException(number);

        answer = checkNum(number);

        return answer;
    }

    //중복되는 수 체크
    public static int checkDuplicaion(String number_string) {
        int duplicationCnt = 0;

        for (int i = 0; i < number_string.length(); i++) {
            if (number_string.charAt(i) == '3' || number_string.charAt(i) == '6' || number_string.charAt(i) == '9')
                duplicationCnt++;
        }
        return duplicationCnt;
    }

    //3,6,9 가 포함되는지 확인
    public static int checkNum(int number)
    {
        String number_string = "";
        int cnt = 0;

        for (int i = 1; i <= number; i++) {
            number_string = Integer.toString(i);
            if (number_string.contains("3") || number_string.contains("6") || number_string.contains("9")) {
                cnt += checkDuplicaion(number_string);
            }
        }
        return cnt ;
    }

    /*
    예외 처리 함수
     */
    public static void checkException(int number) {
        if (number < 1 || number > 10000)
            throw new IllegalArgumentException("ERROR");
    }
}
