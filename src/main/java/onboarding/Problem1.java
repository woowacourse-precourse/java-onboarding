package onboarding;

import java.util.List;

class Problem1 {
    public static Integer pl,pr,cl,cr;

    public static int addAll(String str){
        int l=str.length();
        int sum=0;
        for(int i=0; i<l; i++){
            sum+=(int)str.charAt(i)-(int)'0';
        }
        return sum;
    }
    public static int mulAll(String str){
        int l=str.length();
        int mul=1;
        for(int i=0; i<l; i++){
            mul=mul*((int)str.charAt(i)-(int)'0');
        }
        return mul;
    }
    public static int maxPage(String str){
        int add=addAll(str);
        int mul=mulAll(str);
        int maxValue;
        if(add>mul) maxValue=add;
        else maxValue=mul;
        return maxValue;
    }
    public static int maxResult(int pl,int pr){
        if(pl>pr)return pl;
        else return pr;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = -1;


        Integer pl=pobi.get(0);
        Integer pr=pobi.get(1);
        Integer cl=crong.get(0);
        Integer cr=crong.get(1);

        if(pl+1!=pr)return -1;
        if(cl+1!=cr)return -1;
        if(pl<1||pl>400||pr<1||pr>400) return -1;
        if(cl<1||cl>400||cr<1||cr>400) return -1;

        int max_pobi=maxResult(maxPage(pl.toString()),maxPage(pr.toString()));
        int max_crong=maxResult(maxPage(cl.toString()),maxPage(cr.toString()));

        if(max_pobi==max_crong) answer=0;
        else if(max_pobi>max_crong)answer= 1;
        else return answer=2;

        return answer;
    }
}