package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (score(pobi)==-1 || score(crong)==-1){
            return -1;
        }
        else if(score(pobi)>score(crong)){
            return 1;
        }
        else if(score(pobi)<score(crong)){
            return 2;
        }
        return 0;
    }
    static int findMax(List<Integer> num, int index){
        String str = num.get(index).toString();
        int tmp1 = 0;
        int tmp2 = 1;
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(str.split("")));
        for (String s : myList) {
            tmp1 += Integer.parseInt(s);  //자릿수 덧셈
        }
        for (String s : myList) {
            tmp2 *= Integer.parseInt(s);
        }
        return Math.max(tmp1,tmp2);
    }
    static int score(List<Integer> user){
        if (user.get(0)+1 != user.get(1)){
            return -1;
        }
        if (user.get(0)==1 || user.get(1)==400){
            return -1;
        }
        int user_max = 0;
        for (int i =0;i<user.size();i++){
            int tmp = findMax(user,i);
            user_max = Math.max(tmp,user_max);
        }
        return user_max;
    }
}