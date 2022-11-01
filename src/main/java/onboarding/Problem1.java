package onboarding;

import java.util.List;

class Problem1 {

    public static int getMax(int value1, int value2){
        if(value1 > value2){
            return value1;
        }
        return value2;
    }

    public static int getSum(int value){
        int hundred = value / 100;
        int ten = (value % 100) / 10;
        int one = value % 10;
        return (hundred + ten + one);
    }

    public static int getProd(int value){
        int[] arr = new int[3];
        arr[0] = value / 100;
        arr[1] = (value % 100) / 10;
        arr[2] = value % 10;

        int prod = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                prod *= arr[i];
            }
        }
        return prod;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(pobi.size() != 2 || crong.size() != 2){
            return -1;
        }

        if(pobi.contains(1) || pobi.contains(400) || crong.contains(1) || crong.contains(400)){
            return -1;
        }

        int i = 0;
        if( (pobi.get(i+1)-pobi.get(i))!=1 || (crong.get(i+1)-crong.get(i))!=1 ){
            return -1;
        }

        int pobi_max = Integer.MIN_VALUE;
        for(i=0; i<pobi.size(); i++){
            int po = pobi.get(i);
            int pob1 = getSum(po);
            int pob2 = getProd(po);
            int pob = getMax(pob1, pob2);
            if(pob > pobi_max){
                pobi_max = pob;
            }
        }

        int crong_max = Integer.MIN_VALUE;
        for(i=0; i<crong.size(); i++){
            int cr = crong.get(i);
            int cro1 = getSum(cr);
            int cro2 = getProd(cr);
            int cro = getMax(cro1, cro2);
            if(cro > crong_max){
                crong_max = cro;
            }
        }

        if(pobi_max == crong_max){
            return 0;
        }else if(pobi_max > crong_max){
            return 1;
        }
        return 2;
    }

}