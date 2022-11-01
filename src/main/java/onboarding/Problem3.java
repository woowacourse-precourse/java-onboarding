package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //1 부터 Number까지 3,6,9의 여부 확인
        for(int i = 1; i <= number; i++) {
            String numToStr = "" + i;
            for(int j = 0; j < numToStr.length(); j++){
                //하나하나 자르면서 확인
                String checkNumber = numToStr.substring(j, j + 1); // 긴 문자를 크기 1로 잘라서 확인하는 문자열 생성
                if(checkNumber.equals("3") || checkNumber.equals("6") || checkNumber.equals("9"))
                    answer++;
            }
        }
        return answer;
    }
}
