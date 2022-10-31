package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String numStr = i+"";
            int cnt=0; // 박수 횟수 저장 변수
            for(int j=0;j<numStr.length();j++){
                // 숫자에 있는 3,6,9 문자 개수 counting
                if(numStr.charAt(j)=='3'||numStr.charAt(j)=='6'||numStr.charAt(j)=='9'){
                    cnt++;
                }
            }
            answer+=cnt;
        }
        return answer;
    }
}
