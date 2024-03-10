package br.com.luxauto.luxauto;

import br.com.luxauto.luxauto.model.Car;
import br.com.luxauto.luxauto.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class LuxAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuxAutoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CarRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Car car = new Car();
                        car.setName("nome: " + i);
                        car.setMotor("motor: " + i);
                        car.setCil("cil: " + i);
                        car.setAcel("acel: " + i);
                        car.setHp("hp: " + i);
                        car.setTorque("torque: " + i);
                        car.setSpeed("speed: " + i);
                        car.setDoors("doors: " + i);
                        car.setSeats("seats: " + i);
                        car.setVal("val: " + i);
                        car.setPrice("price: " + i);
                        car.setImage("image: " + i);
                        car.setTitle("title: " + i);
                        car.setPage("page: " + i);
                        return car;
                    })
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
    }

}
