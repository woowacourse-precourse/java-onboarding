package onboarding;


public class Problem3 {

    public static void main(String[] args) {
        System.out.println(solution(13));
        System.out.println(solution(33));
    }

        public static int solution(int number) {
        int answer = 0;
        for(int i=1 ;i <= number; i++){
            for(String c : Integer.toString(i).split("")) {
                if(Integer.parseInt(c)%3 == 0 && !"0".equals(c)) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}


