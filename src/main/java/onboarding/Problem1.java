package onboarding;

import java.util.List;

class Problem1 {

    //각 자리의 숫자를 모두 더했을 때 나오는 값
    public static int max_sum(Integer page,Integer is_max){
        if(page/10 >=1){
            is_max += page%10;
            return max_sum(page/10,is_max);
        }
        is_max += page % 10;
        System.out.println("sum(197)"+is_max);
        return is_max;
    }

    //각 자리의 숫자를 모두 곱했을 때 나오는 값
    public static int max_multi(Integer page,Integer is_max){
        if(page/10 >=1){
            //System.out.println(page%10);
            is_max *= page%10;
            return max_multi(page/10,is_max);
        }
        is_max *= page % 10;
        System.out.println("multi(197)"+is_max);
        return is_max;
    }

    //각 자리의 숫자의 곱셈,덧셈 중 큰 숫자를 반환
    public static int max_page(Integer page){
        int max_sum = max_sum(page,0);
        int max_multi = max_multi(page,1);
        System.out.println("max_page : "+Integer.max(max_sum,max_multi));
        return Integer.max(max_sum,max_multi);
    }
    //포비가 이겼다면 1 , 크롱이 이겼다면 2 비겼다면 0 을 반환
    public static int winner(Integer a , Integer b){
        if(a>b){
            return 1;
        }
        if(a.equals(b)){
            return 0;
        }
        return 2;
    }
    //예외 처리 , 6번조건도 예외라고 생각하여 포함하였음
    public static boolean is_exception(List<Integer> page){
        //이상한 데이터가 들어왔다면 false 를 반환(예외처리 -1)
        if(page.get(0)%2== 0 && page.get(0)+1 != page.get(1)){
            return false;//올바른 data 들어왔을 때 1을 반환
        }
        //이상한 데이터가 들어왔다면 false 를 반환 (=6번 조건을 충족하지 않는다면.)
        if(page.get(0) == 1 || page.get(1) == 400){
            return false;
        }

        return true ; //이상한 data 들어왔을 떄 0을 반환
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) { //play game
        int answer = Integer.MAX_VALUE;
        //포비와 크롱의 좌,우 페이지를 각 변수에 저장
        int pobi_left_page = pobi.get(0);
        int pobi_right_page = pobi.get(1);

        int crong_left_page = crong.get(0);
        int crong_right_page = crong.get(1);

        //
        if(is_exception(pobi) && is_exception(crong)){
            //1. 책을 임의로 펼친다. 이미 solution의 argument로 들어왔음

            //2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 , 모두 곱해 가장 큰 수를 구한다.
            int pobi_left = max_page(pobi_left_page);
            int crong_left = max_page(crong_left_page);

            //3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 , 모두 곱해 가장 큰 수를 구한다.
            int pobi_right = max_page(pobi_right_page);
            int crong_right = max_page(crong_right_page);

            //4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
            int pobi_result = Integer.max(pobi_left,pobi_right);
            int crong_result = Integer.max(crong_left,crong_right);

            //
            System.out.println("포비 : " + pobi_result);
            System.out.println("크롱 : " + crong_result);

            //5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다. (포비 1 크롱 2 무승부 0 예외사항 -1(이미 처리))
            answer = winner(pobi_result,crong_result);

            System.out.println(answer);
            return answer;
        }
        //예외처리에 걸려 if문에 통과하지 못했다면 answer = -1
        answer = -1;

        System.out.println("answer : " + answer);
        return answer;
    }
}