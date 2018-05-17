package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name="breakfasts")
public class Breakfast extends Meal {

    public Breakfast(){

    }

    public Breakfast(String dishName, int calorieCount) {
        super(dishName, calorieCount);
    }

}
