package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;
import onboarding.problem7.vo.Relation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RelationsValidator extends AbstractValidator {
    public static final String INVALID_ID_FORMAT_MESSAGE = "사용자 아이디는 알파벳 소문자만 허용합니다.";
    public static final String ID_FORMAT_REGEX = "^[a-z]*$";

    public static final String INVALID_RELATIONS_SIZE_MESSAGE_FORMAT = "주어진 친구 관계는 %d개 이상 %d개 이하여야 합니다.";
    public static final int MIN_RELATION_SIZE = 1;
    public static final int MAX_RELATION_SIZE = 10_000;

    public static final String INVALID_RELATION_SIZE_MESSAGE_FORMAT = "친구관계는 길이 %d의 리스트/배열이어야 합니다.";
    public static final int VALID_RELATION_SIZE = 2;
    public static final String DUPLICATING_RELATION_MESSAGE = "동일한 친구 관계를 중복해서 제공할 수 없습니다.";


    @Override
    public boolean supports(Object target) {
        return target.getClass() == List.class;
    }

    @Override
    public void validate(Object target) {
        if (supports(target)) {
            validateRelations((List<List<String>>) target);
        }
    }

    public static void validateRelations(List<List<String>> relations) {
        isRelationsSizeValid(relations);

        relations.forEach(relation -> {
            isRelationSizeValid(relation);
            relation.forEach(RelationsValidator::isIdOnlyAlphabetLowerCase);
        });

        List<Relation> relationList = relations.stream().map(Relation::of).collect(Collectors.toList());
        hasRelationsDuplicateRelation(relationList);
    }

    private static void isRelationsSizeValid(List<List<String>> relations) {
        if (relations == null || relations.size() < MIN_RELATION_SIZE || MAX_RELATION_SIZE < relations.size()) {
            throw new IllegalArgumentException(String.format(INVALID_RELATIONS_SIZE_MESSAGE_FORMAT, MIN_RELATION_SIZE, MAX_RELATION_SIZE));
        }
    }

    private static void isRelationSizeValid(List<String> relation) {
        if (relation.size() != 2) {
            throw new IllegalArgumentException(String.format(INVALID_RELATION_SIZE_MESSAGE_FORMAT, VALID_RELATION_SIZE));
        }
    }

    private static void hasRelationsDuplicateRelation(List<Relation> relations) {
        relations.forEach(relation -> {
            if (1 < Collections.frequency(relations, relation)) {
                throw new IllegalArgumentException(DUPLICATING_RELATION_MESSAGE);
            }
        });
    }

    private static void isIdOnlyAlphabetLowerCase(String id) {
        if (!id.matches(ID_FORMAT_REGEX)) {
            throw new IllegalArgumentException(INVALID_ID_FORMAT_MESSAGE);
        }
    }
}
