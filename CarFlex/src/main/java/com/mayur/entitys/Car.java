package com.mayur.entitys;

import com.mayur.dtos.CarDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Data
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    private String transmission;

    private String brand;

    private String type;

    private Date modelYear;

    private String description;

    private Integer price;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    public CarDto getCarDto(){
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setDescription(description);
        carDto.setColor(color);
        carDto.setModelYear(modelYear);
        carDto.setTransmission(transmission);
        carDto.setPrice(price);
        carDto.setType(type);
        carDto.setReturnImage(image);
        carDto.setBrand(brand);
        return carDto;
    }


}
