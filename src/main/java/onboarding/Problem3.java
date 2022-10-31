package onboarding;

//문제 3번 기능 요구 사항
//1. 슷자를 string으로 바꿔 3, 6, 9개수 다 더하는 함수

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int num=0;num<=number;num++) {
            String numToString= Integer.toString(num);

            for(int i=0;i<numToString.length();i++) {
                if(numToString.charAt(i)=='3'||numToString.charAt(i)=='6'||numToString.charAt(i)=='9') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
