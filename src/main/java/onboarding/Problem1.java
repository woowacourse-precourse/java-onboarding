package onboarding;

import java.util.List;

import static java.lang.Math.abs;

class Problem1 {
    public static int maxNum(int n){ // 가장 큰 수를 구하는 함수
        int plus = 0;
        int mul = 1;
        int n1 = n;
        int n2 = n;

        while (n1!=0) {
            plus+=n1%10;
            n1 /= 10;
        }
        while (n2!=0) {
            mul *= n2%10;
            n2 /= 10;
        }
        if (plus > mul) {
            return plus;
        }
        else {
            return mul;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 처리 - 첫면, 마지막 면일 때. 1~400 범위 초과 시
        if (pobi.get(0)>=400 || pobi.get(1)>=400 || pobi.get(0)<=1 || pobi.get(1)<=1 || crong.get(0)>=400 || crong.get(1)>=400 || crong.get(0)<=1 || crong.get(1)<=1 ) {
            return -1;
        }
        // 예외 처리 - 연속되는 페이지가 아닐 때
        int pobi_differ = abs(pobi.get(0)-pobi.get(1));
        int crong_differ = abs(crong.get(0)-crong.get(1));
        if (pobi_differ!=1 || crong_differ!=1) {
            return -1;
        }

        // 최대값 저장할 변수 초기화
        int pobiMax = 0;
        int crongMax = 0;

        // pobi 최대값 결정
        int pobi0 = maxNum(pobi.get(0));
        int pobi1 = maxNum(pobi.get(1));

        if (pobi0> pobi1){ pobiMax = pobi0; }
        else { pobiMax = pobi1; }

        // crong 최대값 결정
        int crong0 = maxNum(crong.get(0));
        int crong1 = maxNum(crong.get(1));

        if (crong0 > crong1){ crongMax = crong0; }
        else { crongMax = crong1; }

        // answer 결정
        if (pobiMax>crongMax) { answer = 1; }
        else if (pobiMax<crongMax) { answer = 2; }
        else if(pobiMax == crongMax) {  answer = 0; }
        else { answer = -1; }

        return answer;
    }
}
