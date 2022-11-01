package onboarding;

import java.util.List;

class Problem1 {
    public static int findMax(List<Integer> name){
        int maxName = 0;
        for(int num : name){
            int tmp = num;
            int tmpAns1 = 0; // 각자리 더한 값
            int tmpAns2 = 1; // 각자리 곱한 값
            while(tmp!=0){
                tmpAns1 += tmp%10;
                tmp /= 10;
            }
            tmp = num;
            while(tmp!=0){
                tmpAns2 *= tmp%10;
                tmp /= 10;
            }
            if (tmpAns1 >= tmpAns2){
                maxName = tmpAns1;
            }
            else{
                maxName = tmpAns2;
            }
        }
        return maxName;
    }
    public static int findException(List<Integer> name){
        if(name.get(1) - 1 == name.get(0)){
            return 0;
        }
        return -1;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxPobi = 0, maxCrong = 0;

        if(findException(pobi) == -1 || findException(crong) == -1){
            return -1;
        }

        maxPobi = findMax(pobi);
        maxCrong = findMax(crong);

        if(maxPobi > maxCrong){
            answer = 1;
        }else if(maxPobi < maxCrong){
            answer = 2;
        }else if(maxPobi == maxCrong){
            answer = 0;
        }else{
            answer = -1;
        }
        return answer;
    }
}