package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Brian", "O’Conner", "brian@mail.ru"),
              new Car("VAZ", 2106));
      userService.add(new User("Dominic", "Toretto", "dominic@mail.ru"),
              new Car("VAZ", 2101));
      userService.add(new User("Letty", "Ortiz", "letty@mail.ru"),
              new Car("VAZ", 2103));
      userService.add(new User("Mia", "Toretto", "mia@mail.ru"),
              new Car("VAZ", 2107));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar().getModel() + " - " + user.getCar().getSeries());
//         System.out.println();
//      }

      Car car = new Car("VAZ", 2107);

      List<User> users2 = userService.listUsers(car);
      for (User user : users2) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getModel() + " - " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
