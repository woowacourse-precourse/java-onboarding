package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//0 있으면 무조건 덧셈으로 계산,
// 1이 있는경우.
//  2자리 일때, 1이 한개면 덧셈 ,  1이 2개여도 덧셈
//  3자리일때, 1이 한개면 곱셈, 1이 두개,세개면 덧셈
// 0 1 둘다 없으면 무조건 곱셈

//위 방법보다는 일단 pobi의 수 2개 각각 덧셈 곱셈 다 해서 max값 vs crong의 수 2개 각각 덧셈 곱셈 다 해서 maxㅂ 붙이기
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //좌우 페이지가 오름차순으로 1차이가 아닐때.(제한사항)
        if (pobi.get(0)+1 != pobi.get(1))
            return -1;

        if (crong.get(0)+1 != crong.get(1))
            return -1;
        //배열 길이 2가 초과될시 (제한사항)
        if (pobi.size() > 2 ) {
            return -1;
        }
        if (crong.size() > 2 ) {
            return -1;
        }

        //pobi거 리스트에서 최댓값 뽑기
        int max_num1 = 0;
        for (int i = 0; i < 2; i++) {
            int num = pobi.get(i);
            int plus =  Plus(num);
            int multi = Multiply(num);
            if (plus > max_num1) {
                max_num1 =  plus;
            }
            if (multi > max_num1) {
                max_num1 =  multi;
            }

        }
        //crong거 리스트에서 최댓값 뽑기
        int max_num2 = 0;
        for (int i = 0; i < 2; i++) {
            //덧셈,곱셈중에 더 큰값.
            int num = crong.get(i);
            int plus =  Plus(num);
            int multi = Multiply(num);
            if (plus > max_num2) {
                max_num2 =  plus;
            }
            if (multi > max_num2) {
                max_num2 =  multi;
            }
        }

        if (max_num1 > max_num2) {
            return 1;
        } else if (max_num1 == max_num2) {
            return 0;
        } else {
            return 2;
        }

    }
    public static int Plus(int num) {
        int sum = 0;
        while( num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int  Multiply(int num) {
        int sum = 1;
        while( num != 0){
            sum *= num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer>pobi  = new ArrayList<Integer>();
        List<Integer>crong  = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            pobi.add(sc.nextInt());
        }
        for (int i = 0; i < 2; i++) {
            crong.add(sc.nextInt());
        }
        int n = solution(pobi,crong);



    }
}

