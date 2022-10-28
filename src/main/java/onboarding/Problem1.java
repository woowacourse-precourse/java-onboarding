package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외 처리
        if(checkPageValidation(pobi) == false || checkPageValidation(crong) == false){
            //시작면이나 마지막면을 펼친 경우(=유효한 페이지가 아님. 1~400 범위 안의 숫자가 아닌 경우)
            answer = -1;
            return answer;
        }else if(checkPageSequence(pobi) == false || checkPageSequence(crong) == false){
            //리스트의 숫자가 연속되지 않을 경우
            answer = -1;
            return answer;
        }else if(checkPagePosition(pobi) == false || checkPagePosition(crong) == false){
            //리스트의 숫자가 홀짝 순서가 아니라 짝홀 순서로 왔을 경우
            answer = -1;
            return answer;
        }

        //모든 예외를 통과한 정상 입력
        int pobiMax = 0;
        int crongMax = 0;
        for(int i = 0; i < 2; i++){
            int a = plusDigits(pobi.get(i));
            int b = multiplyDigits(pobi.get(i));
            int c = Math.max(a, b);
            pobiMax = Math.max(pobiMax, c);

            int d = plusDigits(crong.get(i));
            int e = multiplyDigits(crong.get(i));
            int f = Math.max(d, e);
            crongMax = Math.max(crongMax, f);
        }

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

    private static boolean checkPageValidation(List<Integer> pages){
        for(int i = 0; i < pages.size(); i++){
            if(pages.get(i) < 1 || pages.get(i) > 400){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPageSequence(List<Integer> pages){
        int num = pages.get(0);
        for(int i = 1; i < pages.size(); i++){
            if(pages.get(i) != num+1){
                return false;
            }else{
                num = pages.get(i);
            }
        }
        return true;
    }

    private static boolean checkPagePosition(List<Integer> pages){
        //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 함
        if(pages.get(0)%2 == 0 || pages.get(1)%2 == 1){
            return false;
        }
        return true;
    }
}