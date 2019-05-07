package ua.lviv.iot.repair;

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

	public static void main(String[] args) {
		SpringApplication.run(Lab8Application.class, args);
	}
	
	
	 @Bean
	    public CommandLineRunner demo(final RepairRepository repository) {
	        return (args) -> {
	            repository.save(new Hammer(400, RatingInstruments.LOW_RATING , Fix.DOOR , 76 , 6 , "metal"));
	            repository.save(new Hammer(400, RatingInstruments.LOW_RATING , Fix.DOOR , 76 , 10 , "tree"));
	            

	            repository.findAll().forEach(repair -> System.out.println(repair));
	            System.out.println("------------------------------------------------------------");
	            
	            System.out.println("------------------------------------------------------------");
	        };

}
	 }
