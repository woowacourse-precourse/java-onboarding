package onboarding;
//1.n까지 숫자 탐색
//2.숫자 문자열로 변환
//3.문자열 완탐하며 3,6,9 중 하나이면 cnt++
//4.반환

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int cnt=0;
        //1.n까지 숫자 탐색
        //2.숫자 문자열로 변환
        //3.문자열 완탐하며 3,6,9 중 하나이면 cnt++
        for(Integer i=1;i<=number;i++){

            String numStr = i.toString();
            for(int j=0;j<numStr.length();j++){
                if(numStr.charAt(j)=='3' || numStr.charAt(j)=='6' || numStr.charAt(j)=='9'){
                    cnt++;
                }
            }
        }
        //4.반환
        return answer=cnt;
    }
}