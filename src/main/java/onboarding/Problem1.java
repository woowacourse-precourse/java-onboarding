package onboarding;

import java.util.List;

class Problem1 {
    //예외 사항 판별 함수
    private static boolean except_case(List<Integer> lst){
        if (lst == null || lst.get(0) == null || lst.get(1) == null){
            return false;
        }

        int elem1 = lst.get(0);
        int elem2 = lst.get(1);

        if (elem1 <= 1 || elem2 >= 400 || elem1%2 == 0 || elem2%2 == 1 || elem2-elem1 != 1){
            return false;
        }

        return true;
    }
    //주어진 페이지에서 가능한 수를 생성하는 함수
    private static int[] prod_mul_add(int page){
        int[] result = {1, 0};

        while(page >= 1){
            result[0] *= (page % 10);
            result[1] += (page % 10);
            page /= 10;
        }

        return result;
    }


    //왼쪽 페이지, 오른쪽 페이지에서 가능한 수 중 가장 큰 수를 찾는 함수
    private static int max_int(List<Integer> lst){
        int max = 0;
        for(Integer page:lst){
            int[] mul_add= prod_mul_add(page);
            max = Math.max(Math.max(mul_add[0], mul_add[1]), max);
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //주어진 페이지가 예외 사항에 해당하면 -1을 return
        if (except_case(pobi) == false || except_case(crong) == false){
            return -1;
        }

        //포비와 크롱의 가장 큰 수를 찾는다.
        int max_pobi = max_int(pobi);
        int max_crong = max_int(crong);

        //포비의 가장 큰 수가 크롱의 가장 큰 수보다 크면 1을, 같으면 0을, 작으면 2를 반환한다.
        if (max_pobi > max_crong){
            return 1;
        }
        else if (max_pobi < max_crong){
            return 2;
        }
        else return 0;
    }
}