package nextstep.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("0-9 사이 랜덤숫자 테스트")
    void test001RandomSuccess() {
        int randomNum = new RandomGenerator().create();
        Assertions.assertThat(randomNum).isBetween(0, 9);
    }
}