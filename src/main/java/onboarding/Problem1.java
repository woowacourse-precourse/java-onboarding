package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong){
        int maxpobi = 0;
        int maxcrong = 0;
        if ((!isVaild(pobi)) || (!isVaild(crong))){
            return -1;
        }
        for (int i=0; i < pobi.size(); i++){
            maxpobi = Math.max(sumOfDigits(pobi.get(i),true),sumOfDigits(pobi.get(i),false));
        }
        for (int i=0; i < pobi.size(); i++){
            maxcrong = Math.max(sumOfDigits(crong.get(i),true),sumOfDigits(crong.get(i),false));
        }
        if (maxpobi==maxcrong){
            return 0;
        }
        else if (maxpobi > maxcrong){
            return 1;
        }
        return 2;
    }
    public static int sumOfDigits(int num, boolean isSum){
        int result = 0;
        if (isSum){
            while (num > 0){
                result += num%10;
                num/=10;
            }
        }
        else{
            result = 1;
            while (num > 0){
                result *= num%10;
                num/=10;
            }
        }
        return result;
    }
    public static boolean isVaild(List<Integer> list){
        if (list.get(0)<=1 || list.get(1)>=400 || list.get(1)<=1 || list.get(0)>=400){
            return false;
        }
        else if(list.get(0) != list.get(1)-1){
            return false;
        }
        else if(list.get(0)%2!=1 || list.get(1)%2!=0){
            return false;
        }
        return true;
    }
}