package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class prob6 {

	// TODO Auto-generated method stub
	public static String[] solution(String[][] forms){

        String[] answer = new String[forms.length];

        HashSet<String> emails = new HashSet<>();

        final Map<String, String > hashMap = new HashMap<>();

        for (int i = 0; i < forms.length; i++) {

            final String name = forms[i][1];

            if(name.length() < 2){
                break;
            }


            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if(!email.equals(forms[i][0])){
                        emails.add(email);
                        emails.add(forms[i][0]);
                    }
                }
                hashMap.put(key, forms[i][0]);
            }
        }

        final List<String> collect = emails.stream()
                .sorted()
                .collect(Collectors.toList());
                   //List size가 인자로 넘어가는 배열 객체의 size 보다 클때, 해당 List의 size로 배열이 만들어집니다.
            //반대로 해당 List size가 인자로 넘어가는 배열객체의 size 보다 작을때는, 인자로 넘어가는 배열객체의 size로 배열이 만들어집니다.
        final String[] results = collect.toArray(new String[0]);

        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] forms ={{"jm@email.com", "제이엠"},{"jason@email.com","제이슨"},{"woniee@email.com","워니"},{"mj@email.com","엠제이"},{"nowm@email.com","이제엠"}};


        String[] result = solution(forms);

        for (String value : result)
            System.out.println(value);
	}

}
