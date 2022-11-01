package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i ++) {
            answer += CheckClap369(i);
        }
        return answer;
    }

    /**
     * 숫자를 문자열로 바꿔서 3, 6, 9의 갯수를 검사
     * @param gameNumber 대상 숫자
     * @return 3, 6, 9의 갯수
     */
    public static int CheckClap369(int gameNumber){
        int checker = 0;
        String stringNumber = String.valueOf(gameNumber);

        for(int i = 0; i < stringNumber.length(); i ++ ){
            if(stringNumber.charAt(i) == '3' || stringNumber.charAt(i) == '6' || stringNumber.charAt(i) == '9'){
                checker++;
            }
        }
        return checker;
    }
}
