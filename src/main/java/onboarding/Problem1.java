package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항
        // 1. pobi와 crong의 길이는 2여야 한다.
        if (pobi.size()!=2 || crong.size()!=2) {
            return -1;
        }
        // 2. left는 홀수, right는 짝수
        if (pobi.get(0)%2!=1 | pobi.get(1)%2!=0 | crong.get(0)%2!=1 | crong.get(1)%2!=0) {
            return -1;
        }
        // 3. left = right - 1
        if (pobi.get(1)-pobi.get(0)!=1 | crong.get(1)-crong.get(0)!=1) {
            return -1;
        }
        // 4. 1 <= left <= 399 and 2 <= right <= 400
        if (pobi.get(0)<1 | pobi.get(0)>399 | pobi.get(1)<2 | pobi.get(1)>400) {
            return -1;
        }
        if (crong.get(0)<1 | crong.get(0)>399 | crong.get(1)<2 | crong.get(1)>400) {
            return -1;
        }

        List<Integer> scoresPobi = merge(mapToSum(pobi), mapToMul(crong));
        List<Integer> scoresCrong = merge(mapToSum(crong), mapToMul(crong));

        int maxPobi = Collections.max(scoresPobi);
        int maxCrong = Collections.max(scoresCrong);

        int answer = 0;
        if (maxPobi < maxCrong) {
            answer = 2;
        } else if (maxPobi > maxCrong) {
            answer = 1;
        }
        return answer;
    }

    static int sumDigits(int digits){
        // 정수 digits가 주어졌을 때 자리수별 숫자(digit)의 합을 return
        // 정수 digits를 10으로 나누었을 때 나머지(digit)를 차례로 더한다.
        int sum = 0;

        while(digits!=0) {
            // digits를 10으로 나눈 나머지(digit)를 sum에 더한다.
            sum += digits%10;
            // digits를 10으로 나눈 몫을 digits에 저장한다.
            digits /= 10;
        }
        return sum;
    }

    static int multiplyDigits(int digits) {
        // 숫자 digits가 주어졌을 때 자리수별 숫자(digit)의 곱을 return
        // 정수 digits를 10으로 나누었을 때 나머지(digit)를 차례로 곱한다.
        int mul = 1;

        while(digits!=0) {
            // digits를 10으로 나눈 나머지(digit)를 mul에 곱한다.
            mul *= digits%10;
            // digits를 10으로 나눈 볷을 digits에 저장한다.
            digits /= 10;
        }
        return mul;
    }

    static List<Integer> mapToSum(List<Integer> intList) {
        List<Integer> sumList =  new ArrayList<>(intList);
        sumList.replaceAll(i -> sumDigits(i));
        return sumList;
    }

    static List<Integer> mapToMul(List<Integer> intList) {
        List<Integer> mulList =  new ArrayList<>(intList);
        mulList.replaceAll(i -> multiplyDigits(i));
        return mulList;
    }

    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        return merged;
    };
}