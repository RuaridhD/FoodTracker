package models;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name="dinners")
public class Dinner extends Meal {

    public Dinner(){

    }

    public Dinner(String dishName, int calorieCount) {
        super(dishName, calorieCount);
    }

}
