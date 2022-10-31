package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import onboarding.validatechecker.Problem6ValidateChecker;

public class Problem6 {
	private static final int EMAIL = 0;
	private static final int NICKNAME = 1;
	private static final int UNDUPLICATED = 1;

	public static List<String> solution(List<List<String>> forms) {
		Problem6ValidateChecker.isFormsValidate(forms);
		Map<String,String> nickEmailMapper = genNickEmailMapper(forms);
		List<String> nickNameList = genNickNameList(forms);
		List<String> patternList = genPatternList(nickNameList);

		Set<String> duplicatePatternSet = genDuplicatePatternSet(patternList);
		List<String> duplicatePatternEmailList =
			genDuplicatePatternEmailList(duplicatePatternSet,nickEmailMapper,nickNameList);
		Collections.sort(duplicatePatternEmailList);

		return duplicatePatternEmailList;
	}

	private static List<String> genDuplicatePatternEmailList(Set<String> duplicatePatternSet,
		Map<String,String> nickEmailMapper, List<String> nickNameList) {
		List<String> duplicatePatternEmailList = new ArrayList<>();
		for (String duplicatePattern : duplicatePatternSet) {
			duplicatePatternEmailList.addAll(nickNameList.stream().filter(str -> str.contains(duplicatePattern))
				.map(nickEmailMapper::get).collect(Collectors.toList()));
		}
		return duplicatePatternEmailList;
	}

	private static Set<String> genDuplicatePatternSet(List<String> patternList) {
		return patternList.stream().filter(str -> Collections.frequency(patternList, str) > UNDUPLICATED)
			.collect(Collectors.toSet());
	}

	private static List<String> genPatternList(List<String> nickNameList) {
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
