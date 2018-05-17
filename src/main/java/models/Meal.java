package models;


import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Meal {

    private int id;
    private String dishName;
    private int calorieCount;
    private Set<Day> days;

    public Meal() {
    }

    public Meal(String dishName, int calorieCount) {
        this.dishName = dishName;
        this.calorieCount = calorieCount;
        this.days = new HashSet<Day>();
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="dish_name")
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Column(name="calories")
    public int getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="day_meal",
    joinColumns = {@JoinColumn(name="meal_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="day_id", nullable = false, updatable = false)})
    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    public void addDay(Day day){
        this.days.add(day);
    }
}
