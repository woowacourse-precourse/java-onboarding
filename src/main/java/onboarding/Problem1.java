package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1) {
            return -1;
        }
        if (pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400){
            return -1;
        }

        int pobiMax = maxOfSumOrProd(pobi.get(0)) > maxOfSumOrProd(pobi.get(1)) ? maxOfSumOrProd(pobi.get(0)) : maxOfSumOrProd(pobi.get(1)); //포비의 왼쪽 더한 수, 왼쪽 곱한 수, 오른쪽 더한 수, 오른쪽 곱한 수 중에 제일 큰 수
        int crongMax = maxOfSumOrProd(crong.get(0)) > maxOfSumOrProd(crong.get(1)) ? maxOfSumOrProd(crong.get(0)) : maxOfSumOrProd(crong.get(1)); //크롱의 왼쪽 더한 수, 왼쪽 곱한 수, 오른쪽 더한 수, 오른쪽 곱한 수 중에 제일 큰 수

        if (pobiMax == crongMax) { //포비 큰 수, 크롱 큰 수 같으면?
            return 0; // 0 뱉음
        }

        return pobiMax > crongMax ? 1 : 2; //포비 큰 수가 크면? 1 뱉음 아니면 2 뱉음
    }

    public static List<Integer> digit(int number) { //자릿수를 추출 input은 number로 정의(왼,오 쪽수가 되겠죵??)
        List<Integer> digitArr = new ArrayList<>();//추출한 자릿수를 넣을 빈 배열 선언

        int num = number;

        while(num > 0) { //자릿수가 0보다 커야 됨...! 즉, 모든 자릿수에 대해 반복
            digitArr.add(num %10); //빈 배열에 숫자를 10으로 나눈 나머지 즉 1의 자리를 넣는다
            num /= 10; //숫자를 10으로 나눈다 즉, 1의 자리를 없앰
        }

        return digitArr; //채워진 배열을 반환
    }

    public static int maxOfSumOrProd(int number){ //input은 왼쪽 페이지, 오른쪽 페이지가 포함된 길이가 2인 배열
        int digitSum = 0; //자릿수 더한 것의 합

        List<Integer> digitArr = digit(number); // 숫자의 자릿수를 배열로 넣음

        for (int i=0; i<digitArr.size(); i++){ //자릿수의 길이만큼 돌면서
            digitSum = digitSum + digitArr.get(i);//digitSum에 자릿수를 계속 더해감
        }

        int digitProduct = 1; //자릿수의 곱 0으로 선언

        for(int i=0; i<digitArr.size(); i++){ // 자릿수의 길이만큼 돌면서
            digitProduct = digitProduct * digitArr.get(i);//digitProduct에 자릿수를 계속 곱해감
        }

        return (digitSum < digitProduct) ? digitProduct : digitSum;//digitSum이 digitProduct보다 작으면 digitProduct 반환 아니면 digitSum 반환
    }

}