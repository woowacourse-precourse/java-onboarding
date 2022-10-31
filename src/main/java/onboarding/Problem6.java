package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,List<String>> nicknames = new HashMap<>(); // 글자(두 글자) 별 이메일 HashMap
        List<String> answer = new ArrayList<>();
        for(List<String> arr : forms)
        {
            for(int i=0; i<arr.get(1).length()-1; i++)
            {
                String tmp = arr.get(1).substring(i,i+2); // 2글자씩 문자 생성
                List<String> add_list = new ArrayList<>();
                if (nicknames.containsKey(tmp)) // nicknames 안에 해당 이메일이 key 값으로 있을 경우
                {
                    add_list = nicknames.get(tmp); // nicknames 안에 해당 email의 value 반환
                    if(!add_list.contains(arr.get(0))) // nickname안에 해당 이메일이 중복처리 안 되었을 경우
                    {
                        add_list.add(arr.get(0));
                        nicknames.put(tmp,add_list); // 이메일 중복 추가
                    }
                }
                else // nickname 안에 해당 이메일이 없을 경우
                {
                    add_list.add(arr.get(0));
                    nicknames.put(tmp,add_list);
                }

            }
        }
        for(Map.Entry<String,List<String>> nickname : nicknames.entrySet())
        {
            List<String> emails = nickname.getValue();
            if(emails.size() >= 2) // 해당 글자에 2개 이상의 이메일이 들어있을 경우
            {
                for(int j=0; j<emails.size(); j++)
                {
                    if(!answer.contains(emails.get(j))) answer.add(emails.get(j)); // answer에 이메일이 들어있지 않다면 추가
                }
            }
        }
        Collections.sort(answer); // 오름차순 정렬
        return answer;
    }
}
