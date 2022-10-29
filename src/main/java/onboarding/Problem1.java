package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외 처리
        if(checkPageValidationException(pobi) || checkPageValidationException(crong)){
            //시작면이나 마지막면을 펼친 경우(=유효한 페이지가 아님. 1~400 범위 안의 숫자가 아닌 경우)
            answer = -1;
            return answer;
        }else if(checkPageSequenceException(pobi) || checkPageSequenceException(crong)){
            //리스트의 숫자가 연속되지 않을 경우
            answer = -1;
            return answer;
        }else if(checkPagePositionException(pobi) || checkPagePositionException(crong)){
            //리스트의 숫자가 홀짝 순서가 아니라 짝홀 순서로 왔을 경우
            answer = -1;
            return answer;
        }

        //모든 예외를 통과한 정상 입력
        List<Integer> pobiNums = new ArrayList<>();
        List<Integer> crongNums = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            pobiNums.add(plusDigits(pobi.get(i)));
            pobiNums.add(multiplyDigits(pobi.get(i)));

            crongNums.add(plusDigits(crong.get(i)));
            crongNums.add(multiplyDigits(crong.get(i)));
        }
        int pobiMax = max(pobiNums);
        int crongMax = max(crongNums);

        //포비와 크롱을 비교하여 반환값 설정
        if(pobiMax > crongMax){
            answer = 1;
        }else if(pobiMax < crongMax){
            answer = 2;
        }else{
            answer = 0;
        }

        return answer;
    }

    private static int plusDigits(int number){
        int sum = 0;
        while(number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    private static int multiplyDigits(int number){
        int sum = 1;
        while(number > 0){
            sum *= number%10;
            number /= 10;
        }
        return sum;
    }

    private static boolean checkPageValidationException(List<Integer> pages){
        for(int i = 0; i < pages.size(); i++){
            if(pages.get(i) < 1 || pages.get(i) > 400){
                return true;
            }
        }
        return false;
    }

    private static boolean checkPageSequenceException(List<Integer> pages){
        if(pages.get(0)+1 != pages.get(1)){
            return true;
        }
        return false;
    }

    private static boolean checkPagePositionException(List<Integer> pages){
        //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 함
        if(pages.get(0)%2 == 0 || pages.get(1)%2 == 1){
            return true;
        }
        return false;
    }

    private static int max(List<Integer> numbers){
        //리스트를 내림차순으로 정렬해서 인덱스 0번째 수를 반환
        Collections.sort(numbers, Collections.reverseOrder());
        return numbers.get(0);
    }
}