package ua.lviv.iot.repair;

import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.lviv.iot.repair.manager.RepairRepository;
import ua.lviv.iot.repair.model.Fix;
import ua.lviv.iot.repair.model.Hammer;
import ua.lviv.iot.repair.model.RatingInstruments;

@SpringBootApplication
public class Lab8Application {

    public static void main(String... args) throws SQLException {
        SpringApplication.run(Lab8Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(RepairRepository repository) {
        return (args) -> {
            repository.save(new Hammer(400, RatingInstruments.LOW_RATING, Fix.DOOR, 76, 6, "metal"));
            repository.save(new Hammer(400, RatingInstruments.LOW_RATING, Fix.DOOR, 76, 6, "metal"));
            repository.save(new Hammer(400, RatingInstruments.LOW_RATING, Fix.DOOR, 76, 6, "metal"));
            repository.save(new Hammer(400, RatingInstruments.LOW_RATING, Fix.DOOR, 76, 6, "metal"));
            repository.save(new Hammer(400, RatingInstruments.LOW_RATING, Fix.DOOR, 76, 6, "metal"));

            repository.findAll().forEach(hammer -> System.out.println(hammer));
        };

    }
}
