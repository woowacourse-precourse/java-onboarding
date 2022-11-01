package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = overlapNameFinder(forms);
        answer=noDuplication(answer);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static ArrayList<String> overlapNameFinder(List<List<String>> forms) {
        ArrayList<String> emails = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> person = forms.get(i);
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> comparePerson = forms.get(j);
                if (compareName(person.get(1), comparePerson.get(1))) {
                    emails.add(person.get(0));
                    emails.add(comparePerson.get(0));
                }
            }
        }
        return emails;
    }

    public static boolean compareName(String name1, String name2) { //이름이 2글자 이상 중복되는지 확인하는 함수
        if(name1.length()==1 || name2.length()==1) return false;
        for (int i = 0; i < name1.length()-1; i++) {
            String temp1=name1.substring(i,i+2);
            for (int j = 0; j < name2.length()-1; j++) {
                String temp2 =name2.substring(j,j+2);
                if (temp1.equals(temp2))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> noDuplication(List<String> emails) //중복을 제거하는 함수
    {
        HashSet<String> temp =new HashSet<String>();
        ArrayList<String> result =new ArrayList<String>();
        for(String email : emails)
        {
            temp.add(email);
        }
        for(String email : temp)
        {
            result.add(email);
        }
        return result;
    }
}
