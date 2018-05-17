package models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="days")
public class Day {

    private int id;
    private GregorianCalendar date;
    private DayName dayName;
    private Set<Meal> meals;

    public Day() {
    }

    public Day(GregorianCalendar date, DayName dayName) {
        this.date = date;
        this.dayName = dayName;
        this.meals = new HashSet<Meal>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="date")
    public Calendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @Enumerated(EnumType.STRING)
    public DayName getDayName() {
        return dayName;
    }

    public void setDayName(DayName dayName) {
        this.dayName = dayName;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "day_meal",
    inverseJoinColumns = {@JoinColumn(name = "meal_id", nullable = false, updatable = false)},
    joinColumns = {@JoinColumn(name = "day_id", nullable = false, updatable = false)})
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public static int calculateCalorieTotal(List<Meal> meals){
        int total = 0;
        for (Meal meal : meals){
           total += meal.getCalorieCount();
        }
        return total;
    }


}
