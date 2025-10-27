package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarList;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacingServiceTest {
    private RacingService racingService;
    private List<CarList> carInfoList;
    private final List<String> input = new ArrayList<>() {{
        add("pobi");
        add("jun");
    }};

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
        carInfoList = new ArrayList<>();
    }

    @Test
    @DisplayName("자동차 이름 등록 테스트")
    public void registCarNameTest() {
        for (String name : input) {
            carInfoList.add(registCarName(name, 0));
        }

        assertEquals("pobi", carInfoList.get(0).getName());
        assertEquals(0, carInfoList.get(1).getMoveCount());

        assertEquals("jun", carInfoList.get(1).getName());
        assertEquals(0, carInfoList.get(1).getMoveCount());
    }

    @Test
    @DisplayName("경주 과정 출력 테스트")
    void roundStartTest() {
        racingService.setupCarNameList(input);
        RandomNumberGenerator generator = new FixedNumberGenerator(5, 2, 3, 6);

        // 출력 캡처
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when - 2라운드 진행
        racingService.roundStart(generator);
        racingService.roundStart(generator);

        // then
        String output = out.toString().trim();

        assertThat(output)
                .contains("pobi : -") // 1라운드 이동
                .contains("jun :")   // 1라운드 정지
                .contains("pobi : -")  // 2라운드 정지
                .contains("jun : -"); // 2라운드 이동
    }

    @Test
    @DisplayName("공동 우승자 비교 테스트")
    void findJointWinnerTest(){
        racingService.setupCarNameList(input);
        RandomNumberGenerator generator = new FixedNumberGenerator(5, 2, 3, 6);

        racingService.roundStart(generator);
        racingService.roundStart(generator);

        List<String> winners = racingService.findWinner();
        assertThat(winners).containsExactly("pobi", "jun");
    }

    @Test
    @DisplayName("단독 우승자 비교 테스트")
    void findSoloWinnerTest(){
        racingService.setupCarNameList(input);
        RandomNumberGenerator generator = new FixedNumberGenerator(5, 2, 6, 6);

        racingService.roundStart(generator);
        racingService.roundStart(generator);

        List<String> winners = racingService.findWinner();
        assertThat(winners).containsExactly("pobi");
    }

    public CarList registCarName(String name, int moveCount) {
        return new CarList(name, moveCount);
    }

    static class FixedNumberGenerator extends RandomNumberGenerator {
        private final int[] numbers;
        private int index = 0;

        FixedNumberGenerator(int... numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers[index++ % numbers.length];
        }
    }
}
