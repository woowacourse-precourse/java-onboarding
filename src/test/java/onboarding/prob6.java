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
                   //List size�� ���ڷ� �Ѿ�� �迭 ��ü�� size ���� Ŭ��, �ش� List�� size�� �迭�� ��������ϴ�.
            //�ݴ�� �ش� List size�� ���ڷ� �Ѿ�� �迭��ü�� size ���� ��������, ���ڷ� �Ѿ�� �迭��ü�� size�� �迭�� ��������ϴ�.
        final String[] results = collect.toArray(new String[0]);

        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] forms ={{"jm@email.com", "���̿�"},{"jason@email.com","���̽�"},{"woniee@email.com","����"},{"mj@email.com","������"},{"nowm@email.com","������"}};


        String[] result = solution(forms);

        for (String value : result)
            System.out.println(value);
	}

}
