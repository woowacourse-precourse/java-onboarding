package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
	private static final int EMAIL=0;
	private static final int NICKNAME=1;

	public static List<String> solution(List<List<String>> forms) {
		Map<String,String> nickEmailMapper = genNickEmailMapper(forms);
		List<String> nickNameList = genNickNameList(forms);
		List<String> patternList = initPatternList(nickNameList);

		List<String> duplicateSubStrList = getDuplicateSubStr(patternList);
		List<String> hasDuplicateNickNameEmailList =
			genDuplicateNickNameEmailList(duplicateSubStrList,nickEmailMapper,nickNameList);
		Collections.sort(hasDuplicateNickNameEmailList);

		return hasDuplicateNickNameEmailList;
	}

	private static List<String> genDuplicateNickNameEmailList(List<String> duplicateSubStrList,
		Map<String,String> nickEmailMapper, List<String> nickNameList) {
		List<String> duplicateNickNameEmailList = Collections.emptyList();
		for (String duplicateSubStr : duplicateSubStrList) {
			duplicateNickNameEmailList = nickNameList.stream().filter(str -> str.contains(duplicateSubStr))
				.map(str -> nickEmailMapper.get(str)).collect(Collectors.toList());
		}
		return duplicateNickNameEmailList;
	}

	private static List<String> getDuplicateSubStr(List<String> patternList) {
		return patternList.stream().filter(str -> Collections.frequency(patternList, str) > 1)
			.collect(Collectors.toList());
	}

	private static List<String> initPatternList(List<String> nickNameList) {
		List<String> patternList = new ArrayList<>();
		for (String nickName : nickNameList) {
			for(int i = 0; i < nickName.length()-1; i++){
				String continuousStr = nickName.substring(i, i + 2);
				patternList.add(continuousStr);
			}
		}
		return patternList;
	}

	private static List<String> genNickNameList(List<List<String>> forms) {
		List<String> nickNameList = new ArrayList<>();
		for (List<String> user : forms)
			nickNameList.add(user.get(NICKNAME));
		return nickNameList;
	}

	private static Map<String,String> genNickEmailMapper(List<List<String>> forms) {
		Map<String,String> nickEmailMapper = new HashMap<>();
		for (List<String> user : forms)
			nickEmailMapper.put(user.get(NICKNAME),user.get(EMAIL));
		return nickEmailMapper;
	}
}
