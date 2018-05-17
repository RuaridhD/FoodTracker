package db;

import models.Day;
import models.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDay {

    private static Transaction transaction;
    private static Session session;

    public static List<Meal> getAllMealsOnDay(Day day){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> mealList = null;

        try {
            Criteria cr = session.createCriteria(Meal.class);
            cr.createAlias("days", "individual_day");
            cr.add(Restrictions.eq("individual_day.id", day.getId()));
            mealList = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return mealList;
    }
}
