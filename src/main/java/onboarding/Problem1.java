package onboarding;

import java.util.List;

class Problem1 {
    public static int add(Integer page){
        int result=0;
        int x=page.intValue();
        int length = (int)(Math.log10(x)+1);

        for(int i=0;i<length;i++){
            result+=x%10;
            x/=10;
        }
        return result;
    }
    public static int multiple(Integer page){
        int result=1;
        int x=page.intValue();
        int length = (int)(Math.log10(x)+1);
        for(int i=0;i<length;i++){
            result*=x%10;
            x/=10;
        }
        return result;
    }
    public static int compare(Integer a, Integer b){
        int result=-1;
        if(a>b)
            return a;
        else if(b>a)
            return b;
        return a;
    }

    public static boolean is_exception(List<Integer> a){
        if(a.get(0)%2!=1 || a.get(1)%2!=0 || a.get(1)-a.get(0)!=1)
            return true;
        else
            return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer=-2;

        if(is_exception(pobi)==true || is_exception(crong)==true){
            answer=-1;
        }
        else{
            int pobi_add = compare(add(pobi.get(0)),add(pobi.get(1)));
            int pobi_multiple=compare(multiple(pobi.get(0)),multiple(pobi.get(1)));
            int pobi_result=compare(pobi_add,pobi_multiple);

            int crong_add=compare(add(crong.get(0)),add(crong.get(1)));
            int crong_multiple=compare(multiple(crong.get(0)),multiple(crong.get(1)));
            int crong_result=compare(crong_add,crong_multiple);

            if(pobi_result>crong_result)
                answer=1;
            else if(crong_result>pobi_result)
                answer=2;
            else if(pobi_result==crong_result)
                answer=0;
            else    answer=-1;
        }
        return answer;
    }
}