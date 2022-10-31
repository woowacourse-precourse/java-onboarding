package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;
import onboarding.problem7.vo.Relation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RelationsValidator extends AbstractValidator {
    public static final String DUPLICATING_RELATION_MESSAGE = "동일한 친구 관계를 중복해서 제공할 수 없습니다.";

    public static final String USER_ID = "user id";

    public static final String RELATIONS = "Relations";
    public static final int MIN_RELATIONS_SIZE = 1;
    public static final int MAX_RELATIONS_SIZE = 10_000;

    public static final String RELATION = "Relation";
    public static final int RELATION_SIZE = 2;
    public static final int DUPLICATING_ALLOWED_SIZE = 1;

    public static void validateRelations(List<List<String>> relations) {
        isSizeOfListInValidRange(RELATIONS, relations, MIN_RELATIONS_SIZE, MAX_RELATIONS_SIZE);

        relations.forEach(relation -> {
            isSizeOfListInValidRange(RELATION, relation, RELATION_SIZE, RELATION_SIZE);
            relation.forEach(member -> isStringMatchingToRegex(USER_ID, member, ALPHABET_LOWERCASE_ONLY_REGEX, ALPHABET_LOWERCASE_ONLY_DESCRIPTION));
        });

        List<Relation> relationList = relations.stream().map(Relation::of).collect(Collectors.toList());
        hasRelationsDuplicateRelation(relationList);
    }

    private static void hasRelationsDuplicateRelation(List<Relation> relations) {
        relations.forEach(relation -> {
            if (DUPLICATING_ALLOWED_SIZE < Collections.frequency(relations, relation)) {
                throw new IllegalArgumentException(DUPLICATING_RELATION_MESSAGE);
            }
        });
    }
}
