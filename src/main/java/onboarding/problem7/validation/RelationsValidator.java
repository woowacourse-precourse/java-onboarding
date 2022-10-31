package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;
import onboarding.problem7.vo.Relation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 입력값이 Relation 객체를 만들기에 유효한 지 검증하는 작업을 모아둔 Validator 클래스입니다.
 * @author BackFoxx
 */
public class RelationsValidator extends AbstractValidator {
    public static final String DUPLICATING_RELATION_MESSAGE = "동일한 친구 관계를 중복해서 제공할 수 없습니다.";

    public static final String USER_ID = "user id";

    public static final String RELATIONS = "Relations";
    public static final int MIN_RELATIONS_SIZE = 1;
    public static final int MAX_RELATIONS_SIZE = 10_000;

    public static final String RELATION = "Relation";
    public static final int RELATION_SIZE = 2;
    public static final int DUPLICATING_ALLOWED_SIZE = 1;

    /**
     * 주어진 리스트를 검증하기 위해 외부에서 사용할 수 있는 유일한 메소드입니다.
     * 필요한 검증 작업을 호출하여 연속으로 실행할 수 있습니다.
     * 각 검증 작업에서 유효성 검사에 실패한 경우 예외가 발생합니다.
     * @param target 이메일, 이름 문자열 두 개로 구성된 List<String> 의 리스트입니다.
     */
    public static void validate(List<List<String>> target) {
        isSizeOfListInValidRange(RELATIONS, target, MIN_RELATIONS_SIZE, MAX_RELATIONS_SIZE);

        target.forEach(relation -> {
            isSizeOfListInValidRange(RELATION, relation, RELATION_SIZE, RELATION_SIZE);
            relation.forEach(member -> isStringMatchingToRegex(USER_ID, member, ALPHABET_LOWERCASE_ONLY_REGEX, ALPHABET_LOWERCASE_ONLY_DESCRIPTION));
        });

        List<Relation> relationList = target.stream().map(Relation::of).collect(Collectors.toList());
        hasRelationsDuplicateRelation(relationList);
    }

    /**
     * 주어진 친구관계 배열 중에 겹치는 친구관계가 있는 지 검증하는 메소드입니다.
     * @param relations 친구관계가 담긴 Relation 배열입니다.
     */
    private static void hasRelationsDuplicateRelation(List<Relation> relations) {
        relations.forEach(relation -> {
            if (DUPLICATING_ALLOWED_SIZE < Collections.frequency(relations, relation)) {
                throw new IllegalArgumentException(DUPLICATING_RELATION_MESSAGE);
            }
        });
    }
}
