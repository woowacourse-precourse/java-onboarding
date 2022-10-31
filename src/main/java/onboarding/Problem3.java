package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;

        ArrayList<Integer> alist = new ArrayList<>();
        int n1=0,n10=0,n100=0,n1000 = 0,n10000 = 0;
        if(number >= 1 && number <=10000){

            for(int i=1;i<=number;i++){
                alist.clear();
                n10000 = i/10000;
                n1000 = (i%10000)/1000;
                n100 = ((i%10000)%1000)/100;
                n10 = (((i%10000)%1000)%100)/10;
                n1 = (((i%10000)%1000)%100)%10;
                alist.add(n10000);
                alist.add(n1000);
                alist.add(n100);
                alist.add(n10);
                alist.add(n1);
                for(int j=0;j<alist.size();j++){
                    int temp = alist.get(j);
                    if(temp == 3 || temp == 6 || temp == 9)
                        result++;
                }
            }
            return result;
        }
        else return -1;
    }
}
