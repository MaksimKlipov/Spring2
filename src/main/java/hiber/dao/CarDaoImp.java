package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars(Car car) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession()
                .createQuery("from Car where model = :carModel and series = :carSeries")
                .setParameter("carModel", car.getModel())
                .setParameter("carSeries", car.getSeries());
        return query.getResultList();
    }
}
