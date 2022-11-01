package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 기능 요구사항 6에 대한 예외 case
        for (int i = 0; i < 2; i++) {
            if((pobi.get(i) <= 1) || (pobi.get(i) >= 400)) return -1;
            if((crong.get(i) <= 1) || (crong.get(i) >= 400)) return -1;
        }

        // 제한 사항 1 - pobi와 crong의 길이는 2이다.
        // 제한 사항 2 - pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
        if((pobi.get(1)-pobi.get(0) != 1) || (crong.get(1)-crong.get(0) !=1)) return -1;
        int pvalue = compare(pobi.get(0),pobi.get(1));
        int cvalue = compare(crong.get(0),crong.get(1));
        if(pvalue>cvalue) return 1;
        else if(pvalue<cvalue) return 2;
        else return 0;
    }
    // 왼쪽 page와 오른쪽 page를 비교하는 함수
    public static int compare(int a, int b){
        int ones1 = a % 10; int tens1 = (a / 10) % 10; int huns1 = (a / 100);
        int ones2 = b % 10; int tens2 = (b / 10) % 10; int huns2 = b / 100;
        int value1 = 0; int value2 = 0;
        if(huns1>0) value1 = ones1 + tens1 + huns1;
        else value1 = ones1 + tens1;
        if(huns2>0) value2 = ones2 * tens2 * huns2;
        else value2 = ones2 * tens2;
        if(value1>value2) return value1;
        else return value2;
    }
}