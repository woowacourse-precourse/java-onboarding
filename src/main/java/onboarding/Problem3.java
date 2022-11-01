package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        try {
            constraint3(number);
        }catch(Exception e) {
            System.out.println("Problem1 exception : " + e.getMessage());
        }

        if (number < 3) {
            return answer;
        }

        for(int i = 3; i <= number; i++) {
            String makestr = ""+i;
            char [] curr = makestr.toCharArray();
            for(char c : curr) {
                if (c == '3' || c == '6' || c == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
    //제한사항을 검사하는 constraint
    static void constraint3(int number)throws Exception {
        if(number < 1 || number > 10000) {
            throw new Exception("좌측 페이지는 홀수이어야 합니다.");
        }
    }
}
