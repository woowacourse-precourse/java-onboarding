package onboarding;

/*
기능 구현 목록
1. 숫자의 분리
2. 문자열로 변환 후 각 글자마다 분리 (split() 이용)
3. 각 글자마다 3, 6, 9 인지 확인 후 맞으면 answer++
 */




public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String s = Integer.toString(i);
            String[] splits = s.split("");
            for(String split : splits){
                answer+=isContain369(split);
            }
        }
        return answer;
    }

    public static int isContain369(String s){
        Integer k = Integer.parseInt(s);
        if(k!=0&&k%3==0) return 1;
        return 0;
    }
}
