package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGenratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("0에서 9사이 랜덤한 값 생성 테스트")
    void generateRandomNumberTest() {
        // when
        int randomValue = randomNumberGenerator.generate();

        // then
        assertThat(randomValue).isBetween(0, 9);
    }

    @Test
    @DisplayName("반복테스트: 0에서 9사이 랜덤한 값 생성 테스트")
    void multiGenerateRandomNumberTest() {
        // given
        Set<Integer> randomNumberList = new HashSet<>();
        int testCount = 1000;

        // when
        for (int i = 0; i < testCount; i++) {
            int randomValue = randomNumberGenerator.generate();
            randomNumberList.add(randomValue);
        }

        assertThat(randomNumberList).allMatch(value -> value >= 0 && value <= 9);
        assertThat(randomNumberList.size()).isGreaterThan(1);
    }
}
