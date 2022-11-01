package onboarding;

import java.util.*;

public class Problem6 {
    //크루의 닉네임이 중복되는지 판별해주는 함수
    private static void is_duplicate(List<List<String>> forms, HashMap<String, Integer> index, int[] duplicated){
        for(int i = 0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j<nickname.length()-1; j++){
                String key = nickname.substring(j, j+2);

                if (index.containsKey(key)) {
                    if (index.get(key) != i) {
                        duplicated[index.get(key)] = 1;
                        duplicated[i] = 1;
                    }
                    index.put(key, i);
                }
                else index.put(key, i);
            }
        }
    }

    //닉네임이 중복되는 크루들의 이메일을 이메일 형식이 맞다면 리스트로 반환하는 함수
    private static List<String> email_list(List<List<String>> forms, int[] duplicated){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i<forms.size(); i++){
            if (duplicated[i] == 1) {
                String email = forms.get(i).get(0);
                if (email.substring(email.length()-10, email.length()).equals("@email.com")) result.add(email);
            }
        }

        return result;
    }

    //중복되는 닉네임을 가지는 크루들의 이메일을 이메일 형식을 제외한 부분으로 정렬한 리스트를 반환하는 함수
    private static List<String> sort_email(List<String> lst){
        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1_sub = o1.substring(0, o1.length()-10);
                String o2_sub = o2.substring(0, o2.length()-10);

                return o1.compareTo(o2);
            }
        });

        return lst;
    }

    public static List<String> solution(List<List<String>> forms) {
        //두글자 문자열이 마지막으로 나타나는 인덱스를 저장하는 hashmap
        HashMap<String, Integer> index = new HashMap<String, Integer>();

        //크루별 닉네임 중복 여부를 나타내는 배열
        int[] duplicated = new int[forms.size()];
        List<String> ans = new ArrayList<String>();

        //크루의 닉네임이 중복되는지 판별한다.
        is_duplicate(forms, index, duplicated);

        //중복되는 닉네임을 가지는 크루들의 이메일을 리스트에 담는다.
        ans = email_list(forms, duplicated);

        //이메일 리스트를 정렬한다.
        ans = sort_email(ans);

        return ans;
    }
}
