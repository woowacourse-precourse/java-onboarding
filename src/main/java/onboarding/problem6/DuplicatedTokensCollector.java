package onboarding.problem6;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DuplicatedTokensCollector
        implements Collector<Set<String>, Map<String, Integer>, Set<String>> {
    @Override
    public Supplier<Map<String, Integer>> supplier() {
        return ConcurrentHashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Integer>, Set<String>> accumulator() {
        return (acc, tokens) -> tokens.forEach(
                token -> acc.merge(token, 1, Integer::sum));
    }

    @Override
    public BinaryOperator<Map<String, Integer>> combiner() {
        return (acc1, acc2) -> {
            acc2.forEach((key, value) -> acc1.merge(key, value, Integer::sum));
            return acc1;
        };
    }

    @Override
    public Function<Map<String, Integer>, Set<String>> finisher() {
        return (acc -> {
            Set<String> duplicatedTokens = new HashSet<>();
            acc.forEach((key, value) -> {
                if (2 <= value) {
                    duplicatedTokens.add(key);
                }
            });
            return duplicatedTokens;
        });
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT);
    }
}
