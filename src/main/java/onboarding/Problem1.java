package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


class Problem1 {
    //예외 확인 메서드
    public static int exception_check(List<Integer> name) {  
        // 예외사항 3가지 확인
        if((name.get(0) % 2 != 1 || name.get(1) % 2 != 0) || (name.get(0) == 1 || name.get(1) == 400) || (name.get(1)-name.get(0) != 1)) {
            return -1;
        } else{
            return 0;
        }
    }
    //점수 비교 및 결과값 추출 메서드
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobi_page = new ArrayList<Integer>();
        List<Integer> crong_page = new ArrayList<Integer>();
        int answer = Integer.MAX_VALUE;
        //예외처리 함수 호출하여 answer 값 설정
        if ( exception_check(pobi) == -1 || exception_check(crong) == -1 ) {
            answer = -1;
        } else{
            //각자리수의 합과 곱 리스트에 추가
            for (int i = 0; i < 2; i++) {
                int sum = 0;
                int mul = 1;
                int num = pobi.get(i);
                while (num != 0) {
                    sum += num % 10;
                    mul *= num % 10;
                    num /= 10;
                }
                pobi_page.add(sum);
                pobi_page.add(mul);
            }

            for (int i = 0; i < 2; i++) {
                int sum = 0;
                int mul = 1;
                int num = crong.get(i);
                while (num != 0) {
                    sum += num % 10;
                    mul *= num % 10;
                    num /= 10;
                }
                crong_page.add(sum);
                crong_page.add(mul);
            }
            //최대값끼리 비교하여 결과값 반환
            answer = (Collections.max(pobi_page) > Collections.max(crong_page)) ? 1 : (Collections.max(pobi_page) == Collections.max(crong_page)) ? 0 : 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<Integer>();
        List<Integer> crong= new ArrayList<Integer>();
        //페이지 입력받기
        Scanner sc = new Scanner(System.in);
        pobi.add(sc.nextInt());
        pobi.add(sc.nextInt());
        crong.add(sc.nextInt());
        crong.add(sc.nextInt());
        //결과 출력
        System.out.println(solution(pobi, crong));
    }

}