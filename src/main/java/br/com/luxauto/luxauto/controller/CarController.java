package br.com.luxauto.luxauto.controller;

import br.com.luxauto.luxauto.model.Car;
import br.com.luxauto.luxauto.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/Car"})
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/find-all-cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Car> findById(@PathVariable("id") int id){
        try {
            return carRepository.findById((long) id)
                    .map(record -> ResponseEntity.ok().body(record))
                    .orElseThrow(() -> new Exception("Car not found with id " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
