package onboarding;
//1. 369 여부 확인: int isContain(char) - 3,6,9인경우 1, 그 외 0.
//2. 각 자릿수의 369 포함 갯수 확인: int toCharArray(num) - isContain의 리턴 값 합하기
//3. number보다 작은 수에서 필요한 박수 숫자 합하기
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += toCharArray(i);
        }
        return answer;
    }

    public static int toCharArray(int num) {
        int count =0;
        String strNum = ""+num;
        char[] ch = strNum.toCharArray();
        for(int i=0; i<ch.length; i++) {
            count += isContain(ch[i]);
        }
        return count;
    }

    public static int isContain(char chNum) {
        if(chNum=='3'||chNum=='6'||chNum=='9') {
            return 1;
        }
        return 0;
    }

}