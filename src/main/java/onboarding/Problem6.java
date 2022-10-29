package onboarding;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class Problem6 {
	
	//forms안에 있는 닉네임들을 얻는다.
	public static List<String> getNickNameList(List<List<String>> forms)
	{
		List<String> nick_name_list = new ArrayList<>();
		
		for(List<String> nick_name_iter : forms)
			nick_name_list.add(nick_name_iter.get(1));
		
		return nick_name_list;
	}
	
	//중복된 값을 얻는다.
	public static List<String> getDupCheckList(List<String> nick_name_list)
	{
		
		List<String>	tmp_dup_check_list	= new ArrayList<>();
		
		/*
		 * nick_name_list에 있는 모든 닉네임들을 두글자씩 잘라서 
			tmp_dup_check_list에 넣어준다.
			(두글자중에 중복된 글자가 있다면 해당 글자는 중복된닉네임을 가르키는거나 마찬가지다)
			
		*/
		Iterator<String>	nick_name_list_iter	= nick_name_list.iterator();
		while (nick_name_list_iter.hasNext())//아이고망했다
		{
			String nick_name = nick_name_list_iter.next();
						
			for (int i = 0; i + 2 <= nick_name.length(); i++)
				tmp_dup_check_list.add(nick_name.substring(i, i + 2));
		}
		
		/*
		 * 두 글자씩 잘라낸 체크리스트에서 중복을 제거함과 동시에
		 * 닉네임에서 중복이 되지 않았음에도 들어간 글자들도 제거한다.
		 * (key에 해당하는 value값이 1이면은 중복된 글자가 아니라는 뜻이다)
		 * */
		Map<String, Integer> tmp_map = new HashMap<>();
		for (String word : tmp_dup_check_list)
		{
			if (tmp_map.containsKey(word) == true)
				tmp_map.put(word, tmp_map.get(word) + 1);
			else
				tmp_map.put(word, 1);
		}
		
		//제거하는 과정
		List<String>dup_check_list = new ArrayList<>();
		for(Map.Entry<String, Integer> mEntry : tmp_map.entrySet())
		{
			if (mEntry.getValue() > 1)
				dup_check_list.add(mEntry.getKey());
		}
		
		return dup_check_list;
	}
	
	
	public static List<String> solution(List<List<String>> forms) {
		
		/*forms로부터 모든 닉네임을 얻는다.*/
		List<String>	nick_name_list	= getNickNameList(forms);
		
		/*두 글자씩 나눈 중복체크할때 쓸 글자 리스트를 얻는다.*/
		List<String>dup_check_list = getDupCheckList(nick_name_list);
		
		/*중복이 있는 이름들의 이메일을 얻어냄*/
		List<String>	dup_nick_name_list	= new ArrayList<>();
		Iterator<List<String>>	forms_iter = forms.iterator();
		while (forms_iter.hasNext())
		{
			List<String> tmp_forms = forms_iter.next();
			for (String dup_list : dup_check_list)
			{
				if (tmp_forms.get(1).contains(dup_list) == true)
				{
					dup_nick_name_list.add(tmp_forms.get(0));
				}
			}
		}
		
		/*중복된 닉네임들 중에서 중복제거*/
		dup_nick_name_list = dup_nick_name_list.stream().distinct().collect(Collectors.toList());
		
		/*중복된 닉네임들을 오름차순으로 정렬*/
		Collections.sort(dup_nick_name_list);
		
        return dup_nick_name_list;
    }

}
