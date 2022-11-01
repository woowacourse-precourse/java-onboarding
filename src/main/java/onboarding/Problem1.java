package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi1 = pobi.get(0);
        int pobi2 = pobi.get(1);

        int crong1 = crong.get(0);
        int crong2 = crong.get(1);

        if(pobi.size() != 2 && crong.size() != 2){
            answer = -1;
        }
        if(pobi1 < 1 || pobi1 > 400 || pobi1 % 2 == 0 || pobi2 < 1 || pobi2 > 400 || pobi2 % 2 == 1 || crong1 < 1 || crong1 > 400 || crong1 % 2 == 0 ||
                crong2 < 1 || crong2 > 400 || crong2 % 2 == 1){
            answer = -1;
        }
        if(pobi2-pobi1 != 1 || crong2 - crong1 != 1){
            answer = -1;
        }
        else{
            if(Math.max(findMax(pobi1),findMax(pobi2)) > Math.max(findMax(crong1),findMax(crong2))){
                answer = 1;
            }
            else if(Math.max(findMax(pobi1),findMax(pobi2)) < Math.max(findMax(crong1),findMax(crong2))){
                answer = 2;
            }
            else{
                answer = 0;
            }
        }

        return answer;
    }

    public static int findMax(int num){
        int plus = 0;
        int multi = 1;
        int res = 0;

        String str = Integer.toString(num);

        for(int i=0;i<str.length();i++){
            plus += Integer.parseInt(str.split("")[i]);
            multi *= Integer.parseInt(str.split("")[i]);
        }
        res = Math.max(plus, multi);
        return res;
    }
}

