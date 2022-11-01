package onboarding;


/**
 * 1. 1부터 number 까지 i 반복문
 * 2. i를 문자열로 변환 후 각 자리수에 3또는 6또는 9가 있는지 검사해서 각 자리수의 3,6,9개수 반환 : clapNum(int num)
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1. 1부터 number 까지 i 반복문
        for(int i=1;i<=number;i++){
            answer += clapNum(i);
        }

        return answer;
    }

    // i를 문자열로 변환 후 각 자리수에 3또는 6또는 9가 있는지 검사해서 각 자리수의 3,6,9개수 반환 : clapNum(int num)
    public static int clapNum(int num){
        String str = ""+num;
        int ret = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9'){
                ret++;
            }
        }
        return ret;
    }
}
