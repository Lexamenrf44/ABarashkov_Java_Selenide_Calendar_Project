package ru.consultant.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.consultant.data.Month;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.consultant.data.Month.*;

@Tag("webTests")
public class CalendarTest extends TestBase {

    static Stream<Arguments> holidays() {
        return Stream.of(
                Arguments.of(JANUARY, 5),
                Arguments.of(FEBRUARY, 23),
                Arguments.of(MAY, 10)
        );
    }

    static Stream<Arguments> workingDays() {
        return Stream.of(
                Arguments.of(MARCH, 6),
                Arguments.of(APRIL, 23),
                Arguments.of(NOVEMBER, 26)
        );
    }

    @MethodSource("holidays")
    @ParameterizedTest(name = "{0} {1}")
    @DisplayName("Should assert given day is Holiday or Weekend")
    void assertPublicHoliday(Month month, Integer day) {
        Selenide.open("");
        boolean holiday = calendarPage.isHoliday(month, day);
        assertThat(holiday).isTrue();
    }

    @MethodSource("workingDays")
    @ParameterizedTest(name = "{0} {1}")
    @DisplayName("Should assert given day is Holiday or Weekend")
    void assertWorkingDays(Month month, Integer day) {
        Selenide.open("");
        boolean holiday = calendarPage.isHoliday(month, day);
        assertThat(holiday).isFalse();
    }
}
