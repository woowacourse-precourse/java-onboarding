package onboarding;

import java.util.List;

class Problem1 {
    public static int addAllNumbers(int page){
        return String.valueOf(page).chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static int multiplyAllNumbers(int page){
        int sum=1;

        for(char c:String.valueOf(page).toCharArray())
            sum*=Character.getNumericValue(c);

        return sum;
    }

    public static boolean validPages(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);

        if(left<1 || 400<left || right<1 || 400<right)
            return false;

        if(right!=left+1)
            return false;

        if(left==1 || right==400)
            return false;

        if(left%2==0 || right%2==1)
            return false;

        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!validPages(pobi) || !validPages(crong))
            return -1;

        int pobiScore=0;
        for(int i:pobi){
            int addSum=addAllNumbers(i);
            int mulSum=multiplyAllNumbers(i);

            pobiScore = Math.max(pobiScore, Math.max(addSum, mulSum));
        }

        int crongScore=0;
        for(int i:crong){
            int addSum=addAllNumbers(i);
            int mulSum=multiplyAllNumbers(i);

            crongScore = Math.max(crongScore, Math.max(addSum, mulSum));
        }

        if(pobiScore>crongScore)
            return 1;
        else if(pobiScore<crongScore)
            return 2;
        else
            return 0;
    }
}