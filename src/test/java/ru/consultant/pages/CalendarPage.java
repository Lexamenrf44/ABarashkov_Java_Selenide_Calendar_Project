package ru.consultant.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.consultant.data.Month;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.*;

public class CalendarPage {

    private final String xPathForMonth = "//th[@class='month' and text()='%s']";

    public boolean isHoliday(Month month, Integer day) {
        ElementsCollection allDays = $x(format(xPathForMonth, month.getMonthName()))
                .parent()
                .parent()
                .parent()
                .$("tbody").findAll("td");

        SelenideElement foundDay = allDays.filterBy(text(day.toString())).first();
        String classValues = foundDay.getAttribute("class");

        return classValues.contains("holiday") || classValues.contains("weekend");
    }
}
