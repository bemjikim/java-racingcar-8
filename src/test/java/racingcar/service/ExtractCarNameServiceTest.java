package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtractCarNameServiceTest {

    private ExtractCarNameService extractCarNameService;

    @BeforeEach
    void setUp() {
        extractCarNameService = new ExtractCarNameService();
    }

    @Test
    @DisplayName("자동차 이름이 두 개일때의 추출 테스트")
    public void extractTwoCarNameTest() {
        String input = "pobi,jun";

        List<String> output = new ArrayList<String>(){{
            add("pobi");
            add("jun");
        }};

        assertEquals(output, extractCarNameService.extractCarName(input));
    }

    @Test
    @DisplayName("자동차 이름이 세 개일때의 추출 테스트")
    public void extractThreeCarNameTest() {
        String input = "pobi,jun,july";

        List<String> output = new ArrayList<String>(){{
            add("pobi");
            add("jun");
            add("july");
        }};

        assertEquals(output, extractCarNameService.extractCarName(input));
    }

    @Test
    @DisplayName("구분자뒤에 공백이 있을 경우의 추출 테스트")
    public void extractCarNameWithDelimiterAndBlankTest() {
        String input = "pobi, jun, july";

        List<String> output = new ArrayList<String>(){{
            add("pobi");
            add("jun");
            add("july");
        }};

        assertEquals(output, extractCarNameService.extractCarName(input));
    }

    @Test
    @DisplayName("구분자뒤에 공백이 있을 경우의 추출 테스트2")
    public void extractCarNameWithDelimiterAndBlankTest2() {
        String input = "pobi,               jun,             july";

        List<String> output = new ArrayList<String>(){{
            add("pobi");
            add("jun");
            add("july");
        }};

        assertEquals(output, extractCarNameService.extractCarName(input));
    }

    @Test
    @DisplayName("자동차 이름에 숫자, 영어, 한글이 포함될 경우의 추출 테스트")
    public void extractCarNameWithNumberAndEnglishAndKoreanTest() {
        String input = "테스트a1, 테스트23, test123";

        List<String> output = new ArrayList<String>(){{
            add("테스트a1");
            add("테스트23");
            add("test123");
        }};

        assertEquals(output, extractCarNameService.extractCarName(input));
    }
}
