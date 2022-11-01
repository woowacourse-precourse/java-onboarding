package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong)) return -1;
        if(playerScore(pobi)>playerScore(crong))return 1;
        else if(playerScore(pobi)<playerScore(crong))return 2;
        else return 0;
    }

    static boolean isException(List<Integer> player){
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        if(leftPage % 2 == 0 || rightPage % 2 == 1)return true;
        if(leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400)return true;
        if(rightPage != leftPage + 1)return true;
        return false;
    }

    static int playerScore(List<Integer> player){
        if(pageScore(player.get(0))>pageScore(player.get(1)))return pageScore(player.get(0));
        else return pageScore(player.get(1));
    }

    static int pageScore(int page) {
        int sum=0;
        int multi=1;
        while(page>0){
            sum+=page%10;
            multi*=page%10;
            page/=10;
        }
        if(sum>multi)return sum;
        else return multi;
    }
}