package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms)
    {
//        if(!checkWrong(forms))
//            return null;

        List<String> duplWords = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++)
        {
            String duplWord = "";
            List<String> sub_list = new ArrayList<>();

            String name1 = forms.get(i).get(1);
            sub_list.add(forms.get(i).get(0));
            boolean duplFlag = false;
            for(int j = i + 1; j < forms.size(); j++)
            {
                String name2 = forms.get(j).get(1);
                duplWord = compareName(name1, name2);

                if(!duplFlag && checkDuplWord(duplWords, duplWord))
                    break;

                if(!duplWord.equals(""))
                {
                    if(!duplFlag) {
                        duplWords.add(duplWord);
                    }
                    duplFlag = true;
                    sub_list.add(forms.get(j).get(0));
                }
            }

            if(sub_list.size() > 1) {
                System.out.println(sub_list.toString());
                list.add(sub_list);
                System.out.println(list.toString());
            }
        }

        System.out.println("duplWords : " + duplWords.toString());
        System.out.println("list : " + list.toString());

        Collections.sort(list.get(0));
        List<String> answer = list.get(0);
        return answer;
    }

    private static boolean checkWrong(List<List<String>> forms)
    {
        if(forms.size() < 1 || forms.size() > 10000)
            return false;

        String regexEmail = "[a-zA-Z0-9+-\\_.]{12,20}@email\\.com";
        String regexHangeul = "[가-힣]{2,20}";
        for(int i = 0; i < forms.size(); i++)
        {
            if(!forms.get(i).get(0).matches(regexEmail))
                return false;
            if(!forms.get(i).get(1).matches(regexHangeul))
                return false;
        }

        return true;
    }
    private static String compareName(String name1, String name2)
    {
        String standardName = "";
        char[] matchName;
        if(name1.length() > name2.length())
        {
            standardName = name1;
            matchName = name2.toCharArray();
        }
        else
        {
            standardName = name2;
            matchName = name1.toCharArray();
        }

        String duplWord = "";
        for(int i = 2; i < matchName.length; i++)
        {
            String matchWord = "";
            for(int j = 0; j < i; j++)
            {
                matchWord += matchName[j];
            }

            if(standardName.contains(matchWord))
                duplWord = matchWord;
        }

        return duplWord;
    }

    private static boolean checkDuplWord(List<String> duplWords, String duplWord)
    {
        for(String word : duplWords)
        {
            if(word.equals(duplWord))
                return true;
        }

        return false;
    }
    public static void main(String[] args)
    {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        List<String> answer = solution(forms);
        System.out.println("answer : " + answer.toString());
    }
}
