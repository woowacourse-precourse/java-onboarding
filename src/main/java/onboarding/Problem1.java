package onboarding;
import java.util.List;

// 1. 올바른 페이지가 입력 되었는지 확인: boolean isNotRightPAge(List<Integer> list)
// 2. 한 사람의 최댓값 구하기: int maxNum
// 2-1. 페이지 더하기: plusNum
// 2-2. 페이지 곱하기: multiNum
// 2-3. 비교: compare

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 올바른 페이지가 입력 되었는지 확인하기
        if(isNotRightPage(pobi) || isNotRightPage(crong)) {
            return -1;
        }
        // 각 사람의 더 큰 숫자 구하기
        if(maxNum(pobi)>maxNum(crong)) {return 1;}
        if(maxNum(pobi)<maxNum(crong)) {return 2;}
        return 0;
    }
    public static int maxNum(List<Integer> list) {
        int maxPlus = compare(plusNum(list.get(0)), plusNum(list.get(1)));
        int maxMulti = compare(multiNum(list.get(0)), multiNum(list.get(1)));
        int maxNum = compare(maxPlus, maxMulti);
        return maxNum;
    }

    public static int compare(int num1, int num2) {
        if(num1 > num2) {return num1;}
        return num2;
    }

    public static int plusNum(int num) {
        int plus=0;
        while(num>0) {
            plus+=(num%10);
            num/=10;
        }
        return plus;
    }

    public static int multiNum(int num) {
        int multi = 1;
        while(num>0) {
            multi*=(num%10);
            num/=10;
        }
        return multi;
    }

    public static boolean isNotRightPage(List<Integer> list) {
        if(list.get(0) !=(list.get(1)-1)) {
            return true;
        }
        return false;
    }

}