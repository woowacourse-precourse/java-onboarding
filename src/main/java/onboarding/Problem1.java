package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int random(){
        Random rd = new Random();
        return rd.nextInt(400); // 1 ~ 399
    }
    // 난수 발생

    public static List makeList(){
        List<Integer> list = new ArrayList<>();
        int n1 = random();
        int n2 = 0;
        if(n1==399)
            n2 = 400;
        else
            n2 = n1+1;
        list.add(n1);
        list.add(n2);
        return list;
    }
    // 리스트 만들기

    public static int calc(List<Integer> list) {
        int ls = 0;
        int lp = 0;
        int rs = 0;
        int rp = 0;
        int num1, num2, sum, product;
        List<Integer> arr = null;
        for (int i = 0; i < list.size(); i++) {
            num1 = list.get(i);
            num2 = list.get(i);
            sum = 0;
            product = 1;
            while (num1 != 0) {
                sum += num1 % 10;
                product *= num2 % 10;
                num1 /= 10;
                num2 /= 10;
            }
            if (i == 0) {
                ls = sum;
                lp = product;
            } else {
                rs = sum;
                rp = product;
            }
            arr = Arrays.asList(ls, lp, rs, rp);
        }
        return Collections.max(arr);
    }
    // 한 페이지에서 큰 값 계산

    public static boolean listCheck(List<Integer> list){
        if(list.get(list.size()-1) - list.get(list.size()-2) == 1)
            return true;
        else
            return false;
    }
    // 리스트 값 체크
    public static void main(String[] args){
        List<Integer> list = makeList();
        System.out.println(list);
        System.out.println(calc(list));
        System.out.println(listCheck(list));
    }
    // 리스트 초기화
    // 리스트 비교
}