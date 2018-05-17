package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;


@Entity
@Table(name="lunches")
public class Lunch extends Meal {

    public Lunch(){

    }

    public Lunch(String dishName, int calorieCount) {
        super(dishName, calorieCount);
    }

}
