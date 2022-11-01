package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Problem1 {   // Problem1이라는 class 선언 (문제 1에 대한 class 선언, 클래스 이름은 소스 파일명과 동일해야 됨)
    // 기능 구현 목록
    // 1. 예외처리
    //  (1) pobi와 crong에는 왼쪽페이지번호, 오른쪽페이지 번호가 순서대로 들어있다
    //  (2) 포비와 크롱이 주운 책의 페이지는 번호가 1부터 400페이지이다.
    //  (3) pobi와 crong의 길이는 2이다.
    //  (4) 책은 왼쪽페이지는 홀수, 오른쪽 페이지는 짝수
    //  (5) 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
    // 2. 포비와 크롱의 각 왼쪽페이지의 합과 곱, 오른쪽페이지의 합과 곱 계산하기
    // 3. 포비와 크롱의 최대값 계산 및 결과 반환
    public static int solution(List<Integer> pobi, List<Integer> crong) { // 클래스의 멤버함수 솔루션이라는 이름의 메서드) 선언 (매개변수로 리스트를 입력받음

        int pobi_max = 0; // pobi의 점수 중 최대값을 저장할 변수
        int crong_max = 0; // crong의 점수 중 최대값을 저장할 변수
        int answer = 1; // 답

        // pobi와 crong의 4가지 점수를 저장할 배열 선언 (왼쪽페이지의 합, 왼쪽페이지의 곱, 오른쪽페이지의 합, 오른쪽페이지의 곱)
        int[] pobi_num = {0,0,0,0};
        int[] crong_num = {0,0,0,0};


        // 예외 처리
        // 1. pobi와 crong에는 왼쪽페이지번호, 오른쪽페이지 번호가 순서대로 들어있다
        if ( (pobi.get(0) > pobi.get(1)) || (crong.get(0) > crong.get(1)) ||
                (pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)
        ){

            //System.out.println("(제한사항 위반)입력된 리스트 중 대한 왼쪽 페이지 수가 오른쪽 페이지수보다 큰 것이 존재하거나 연속되지 않은 수가 존재합니다.");
            answer = -1;
            return answer;
        }
        // 2. 포비와 크롱이 주운 책의 페이지는 번호가 1부터 400페이지이다.
        else if (
                (pobi.get(0) < 1) || (pobi.get(1) > 400) || (crong.get(0) < 1) || (crong.get(1) > 400)
        ){
            //System.out.println("(제한사항 위반)1~400페이지를 초과하는 것이 존재합니다.");
            answer = -1;
            return answer;
        }
        // 3. pobi와 crong의 길이는 2이다.
        else if (pobi.size() != 2 || crong.size() != 2){
            //System.out.println("(제한사항 위반)입력된 List의 길이가 2가 아닌 것이 존재합니다.");
            answer = -1;
            return answer;
        }
        // 4. 책은 왼쪽페이지는 홀수, 오른쪽 페이지는 짝수
        else if (pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 ||
                crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0
        ){
            //System.out.println("왼쪽페이지는 홀수, 오른쪽 페이지는 짝수가 아닌 것이 존재합니다.");
            answer = -1;
            return answer;
        }
        // 5. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        else if (pobi.get(0) == 1 || pobi.get(1) == 400 ||
                crong.get(0) == 1 || crong.get(1) == 400
        ){
            //System.out.println("시작 면이나 마지막 면에 해당되는 것이 존재합니다.");
            answer = -1;
            return answer;
        }


        // 포비와 크롱의 가장 큰 수를 찾기 위해 4가지 경우에 대해 계산
        for (int d = 0; d < 2; d++){

            int pobi_num_s = pobi.get(d); // 포비의 페이지숫자의 각자리의 합을 계산하기 위한 변수
            int pobi_num_m = pobi.get(d); // 포비의 페이지숫자의 각자리의 곱을 계산하기 위한 변수
            int pobi_sum = 0; // 포비의 페이지숫자의 각자리의 합을 저장할 변수
            int pobi_mul = 1; // 포비의 페이지숫자의 각자리의 곱을 저장할 변수
            int crong_num_s = crong.get(d); // 크롱의 페이지숫자의 각자리의 합을 계산하기 위한 변수
            int crong_num_m = crong.get(d); // 크롱의 페이지숫자의 각자리의 곱을 계산하기 위한 변수
            int crong_sum = 0; // 크롱의 페이지숫자의 각자리의 합을 저장할 변수
            int crong_mul = 1; // 크롱의 페이지숫자의 각자리의 합을 저장할 변수



            while(pobi_num_s != 0){
                // 포비의 페이지 숫자를 10으로 나눈 나머지를 pobi_sum에 더한다.
                pobi_sum += pobi_num_s % 10;
                // 그 다음 자리수에 대해 계산하기 위해 pobi_num_s를 10으로 나눈 수로 업데이트
                pobi_num_s /= 10;
            }
            pobi_num[0 + (d*2)] = pobi_sum;

            while(pobi_num_m != 0){
                // 포비의 페이지 숫자를 10으로 나눈 나머지를 pobi_mul에 곱한다.
                pobi_mul *= pobi_num_m % 10;
                // 그 다음 자리수에 대해 계산하기 위해 pobi_num_s를 10으로 나눈 수로 업데이트
                pobi_num_m /= 10;
            }
            pobi_num[1 + (d*2)] = pobi_mul;


            while(crong_num_s != 0){
                // 크롱의 페이지 숫자를 10으로 나눈 나머지를 crong_sum에 더한다.
                crong_sum += crong_num_s % 10;
                // 그 다음 자리수에 대해 계산하기 위해 crong_num_s를 10으로 나눈 수로 업데이트
                crong_num_s /= 10;
            }
            crong_num[0 + (d*2)] = crong_sum;


            while(crong_num_m != 0){
                // 크롱의 페이지 숫자를 10으로 나눈 나머지를 crong_mul에 곱한다.
                crong_mul *= crong_num_m % 10;
                // 그 다음 자리수에 대해 계산하기 위해 crong_num_s를 10으로 나눈 수로 업데이트
                crong_num_m /= 10;
            }
            crong_num[1 + (d*2)] = crong_mul;

        }



        return answer;
    }
}