package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //1
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> nicknameList = new ArrayList<>();
        HashMap<String,String> dic = new HashMap<>();

        for(List<String> ls:forms)
        {
            dic.put(ls.get(1),ls.get(0));
            nicknameList.add(ls.get(1));
        }

        //2
        Iterator<String> it = nicknameList.iterator();
        int checkIndex=0;
        ArrayList<Integer> skip= new ArrayList<>();
        while(it.hasNext())
        {
            String temp = it.next();
            Boolean skipNow = false;
            for(Integer inte:skip)
            {
                if(inte==checkIndex)
                {
                    skipNow=true;
                }
            }
            if(skipNow)
            {
                checkIndex++;
                continue;
            }

            for(int i=0;i<nicknameList.size();i++) {
                if (checkIndex != i)
                {
                    String subNickName=nicknameList.get(i);
                    for(int j=0;j<=subNickName.length()-1;j++) {
                        if(j+2>subNickName.length())
                            continue;
                        if (temp.contains(subNickName.substring(j, j + 2))) {
                            answer.add(temp);
                            skip.add(i);
                            answer.add(nicknameList.get(i));
                            break;
                        }
                    }
                }
            }
            checkIndex++;
        }

        //3
        HashSet<String> set = new HashSet<>(answer);
        answer.clear();
        it = set.iterator();
        while(it.hasNext())
        {
            answer.add(dic.get(it.next()));
        }
        Collections.sort(answer);
        return answer;
    }
}
