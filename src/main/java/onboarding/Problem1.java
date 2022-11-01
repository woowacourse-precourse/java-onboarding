package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 prob = new Problem1();
        answer = prob.result(pobi.get(0), pobi.get(1), crong.get(0), crong.get(1), pobi, crong);
        return answer;
    }

    public int result(int pobi1, int pobi2, int crong1, int crong2, List<Integer> pobi, List<Integer> crong){
        int value = 0;
        if(pobi1 == 1 || pobi1 == 399 || pobi2 == 2 || pobi2 == 400 || crong1 == 1 || crong1 ==399 || crong2 == 2 || crong2 == 400){
            value = -1;
        }else if(pobi2 == pobi1 + 1 && crong2 == crong1 + 1){ // 포비와 크롱 값 비교
            if(pmaxcheck(pobi, crong) > cmaxcheck(pobi, crong)){
                value = 1;
            }else if(pmaxcheck(pobi, crong) < cmaxcheck(pobi, crong)){
                value = 2;
            }else{
                value = 0;
            }
        }else{
            value=-1;
        } return value;

    }

    public int pmaxcheck(List<Integer> pobi, List<Integer> crong){ // 포비 자리수 별 더한 값과 곱한 값 중에 큰 값
        int max = 0;
        if(pplucheck(pobi, crong) > pmulcheck(pobi, crong)){
            max = pplucheck(pobi, crong);
        }else if(pplucheck(pobi, crong) < pmulcheck(pobi, crong)){
            max = pmulcheck(pobi, crong);
        }else{
            max = pplucheck(pobi, crong);
        } return max;
    }

    public int cmaxcheck(List<Integer> pobi, List<Integer> crong){ // 크롱 자리수 별 더한 값과 곱한 값 중에 큰 값
        int max = 0;
        if(cplucheck(pobi, crong) > cmulcheck(pobi, crong)){
            max = cplucheck(pobi, crong);
        }else if(cplucheck(pobi, crong) < cmulcheck(pobi, crong)){
            max = cmulcheck(pobi, crong);
        }else{
            max = cplucheck(pobi, crong);
        } return max;
    }

    public int pplucheck(List<Integer> pobi, List<Integer> crong){ // 크롱 각 자리수 더한 값 비교해서 높은 값
        int empty = 0;
        for(int i = 0; i < 2; i++){
            int sum = plus(pobi.get(i));
            if(sum > empty){
                empty = sum;
            }else if(sum < empty){
                empty = empty;
            }else{
                empty = empty;
            }
        } return empty;
    }

    public int cplucheck(List<Integer> pobi, List<Integer> crong){ // 크롱 각 자리수 더한 값 비교해서 높은 값
        int empty = 0;
        for(int i = 0; i < 2; i++){
            int sum = plus(crong.get(i));
            if(sum > empty){
                empty = sum;
            }else if(sum < empty){
                empty = empty;
            }else{
                empty = empty;
            }
        } return empty;
    }


    public int pmulcheck(List<Integer> pobi, List<Integer> crong){ // 포비 각 자리수 곱한 값 비교해서 높은 값
        int empty = 0;
        for(int i = 0; i < 2; i++){
            int sum = mul(pobi.get(i));
            if(sum > empty){
                empty = sum;
            }else if(sum < empty){
                empty = empty;
            }else{
                empty = empty;
            }
        } return empty;
    }

    public int cmulcheck(List<Integer> pobi, List<Integer> crong){ // 크롱 각 자리수 곱한 값 비교해서 높은 값
        int empty = 0;
        for(int i = 0; i < 2; i++){
            int sum = mul(crong.get(i));
            if(sum > empty){
                empty = sum;
            }else if(sum < empty){
                empty = empty;
            }else{
                empty = empty;
            }
        } return empty;
    }

    public int plus(int num){ // 포비와 크롱의 각각 자리수 구해서 더하기
        int plusum = 0;
        while(num>0){
            plusum += num % 10;
            num /= 10;
        }
        return plusum;
    }

    public int mul(int num){ // 포비와 크롱의 각각 자리수 구해서 곱하기
        int mulsum = 1;
        while(num>0){
            mulsum *= (num % 10);
            num /= 10;
        }
        return mulsum;
    }
}