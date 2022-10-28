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

	public static List<String> getNickNameList(List<List<String>> forms)
	{
		List<String> nick_name_list = new ArrayList<>();
		
		for(List<String> nick_name_iter : forms)
			nick_name_list.add(nick_name_iter.get(1));
		
		return nick_name_list;
	}
	
	public static List<String> getDupCheckList(List<String> nick_name_list)
	{
		//Set<String> filter = new Set<String>();
		
		List<String> tmp_dup_check_list = new ArrayList<>();
		
		Iterator<String>nick_name_list_iter = nick_name_list.iterator();
		
		while (nick_name_list_iter.hasNext())//아이고망했다
		{
			String nick_name = nick_name_list_iter.next();
			
			/*for (int i = 2; i <= nick_name.length(); i++ )
			{
				for (int j = 0; i + j <= nick_name.length(); j++ )
				{
					tmp_dup_check_list.add(nick_name.substring(j, i + j));
				}
			}*/
			
			for (int i = 0; i + 2 <= nick_name.length(); i++)
				tmp_dup_check_list.add(nick_name.substring(i, i + 2));
		}
		Map<String, Integer> tmp_map = new HashMap<>();
		
		for (String word : tmp_dup_check_list)
		{
			if (tmp_map.containsKey(word) == true)
				tmp_map.put(word, tmp_map.get(word) + 1);
			else
				tmp_map.put(word, 1);
		}
		
		List<String>dup_check_list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> mEntry : tmp_map.entrySet())
		{
			if (mEntry.getValue() > 1)
				dup_check_list.add(mEntry.getKey());
		}
		
		return dup_check_list;
	}
	
	
	public static List<String> solution(List<List<String>> forms) {
		
		List<String>		nick_name_list		= getNickNameList(forms);
		Iterator<String>	nick_name_list_iter	= nick_name_list.iterator();
		
		List<String>			dup_nick_name_list = new ArrayList<>();
		
		List<String>dup_check_list = getDupCheckList(nick_name_list);
		
		
		Iterator<List<String>>	forms_iter = forms.iterator();
		
		
		//중복이 있는 이름들의 이메일을 얻어냄
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
		
		//리스트 중복제거
		dup_nick_name_list = dup_nick_name_list.stream().distinct().collect(Collectors.toList());
		Collections.sort(dup_nick_name_list);
        return dup_nick_name_list;
    }

}
