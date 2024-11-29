package ru.consultant.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.consultant.pages.CalendarPage;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class TestBase {

    protected final CalendarPage calendarPage = new CalendarPage();

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.consultant.ru/law/ref/calendar/proizvodstvennye/2024/";
        Configuration.browserSize = "1440x900";
        Configuration.browser = FIREFOX;
        Configuration.headless = false;
    }
}
