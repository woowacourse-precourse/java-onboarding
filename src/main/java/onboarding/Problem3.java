package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        try {check(number);}
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
        answer = count369(number, answer);
        return answer;
    }

    /**
     * 입력값의 범위 지정*/
    private static void check(int number) {
        if(number < 1 || number > 10000)
            throw new IllegalArgumentException("숫자의 범위를 확인하세요");
    }

    /**
     * 3,6,9의 개수를 세는 함수*/
    private static int count369(int number, int answer) {
        for(int i = 1; i<= number; i++){
            char[] charArr = Integer.toString(i).toCharArray();
            for (char c : charArr) {
                if(c=='3' || c=='6' || c=='9') answer++;
            }
        }
        return answer;
    }
}
