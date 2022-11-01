package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer= new ArrayList<String>();
        ArrayList<String> str=new ArrayList<String>();
        str.add(user);
        HashMap<String,Integer> map=new HashMap<String,Integer>();

        for(int i=0;i< friends.size();i++)
        {
            for(int j=0;j<friends.get(i).size();j++)
            {
                map.put(friends.get(i).get(j),0);
                if(friends.get(i).get(j)==user)
                {
                    if(j==0)
                        str.add(friends.get(i).get(1));
                    else
                        str.add(friends.get(i).get(0));
                }
            }
        }

        return answer;
    }
}
