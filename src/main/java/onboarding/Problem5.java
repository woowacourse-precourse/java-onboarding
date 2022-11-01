package onboarding;
import java.util.List;
import java.util.ArrayList;
public class Problem5 {

    static int[] arr={50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> answer=new ArrayList<Integer>();

        for(int i=0;i<arr.length;i++)
        {
            answer.add(money/arr[i]);
            money%=arr[i];
        }

        return answer;
    }
}


