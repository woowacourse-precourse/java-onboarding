package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 기능 요구사항 6에 대한 예외 case
        if((pobi.get(0) == 1) || (pobi.get(1) == 400)) return -1;
        if((crong.get(0) == 1) || (crong.get(1) == 400)) return -1;

        if((pobi.get(1)-pobi.get(0)>1) || (crong.get(1)-crong.get(0)>1)) return -1;
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