import db.DBDay;
import db.DBHelper;
import models.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Meal breakfast1 = new Breakfast("Bacon roll", 100);
        DBHelper.save(breakfast1);
        Meal breakfast2 = new Breakfast("Cereal", 50);
        DBHelper.save(breakfast2);
        Meal lunch1 = new Lunch("Pie and Chips", 300);
        DBHelper.save(lunch1);
        Meal lunch2 = new Lunch("Beans on Toast", 150);
        DBHelper.save(lunch2);
        Meal dinner1 = new Dinner("Hotpot", 400);
        DBHelper.save(dinner1);
        Meal dinner2 = new Dinner("Pasta bake", 350);
        DBHelper.save(dinner2);

        Day day1 = new Day(new GregorianCalendar(2018,04,14), DayName.MONDAY);
        DBHelper.save(day1);
        Day day2 = new Day(new GregorianCalendar(2018,04,15), DayName.TUESDAY);
        DBHelper.save(day2);
        Day day3 = new Day(new GregorianCalendar(2018,04,16), DayName.WEDNESDAY);
        DBHelper.save(day3);

        DBHelper.addMealToDay(day1, breakfast1);
        DBHelper.addMealToDay(day1, lunch1);
        DBHelper.addMealToDay(day1, dinner1);

        DBHelper.addMealToDay(day3, breakfast1);
        DBHelper.addMealToDay(day3, lunch2);
        DBHelper.addMealToDay(day3, dinner2);


        List<Day> dayList = DBHelper.getAll(Day.class);
        List<Meal> mealList = DBHelper.getAll(Meal.class);
//        DBHelper.delete(day3);
//        List<Day> dayList2 = DBHelper.getAll(Day.class);

        List<Meal> allMealsForDay = DBDay.getAllMealsOnDay(day3);

        int total = Day.calculateCalorieTotal(allMealsForDay);

    }
}
