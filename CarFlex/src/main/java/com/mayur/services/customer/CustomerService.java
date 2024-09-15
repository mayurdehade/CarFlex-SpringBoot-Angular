package com.mayur.services.customer;

import com.mayur.dtos.BookACarDto;
import com.mayur.dtos.CarDto;
import com.mayur.dtos.CarDtoList;
import com.mayur.dtos.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long carId);

    boolean bookACar(Long carId, BookACarDto bookACarDto);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoList searchCar(SearchCarDto searchCarDto);
}
