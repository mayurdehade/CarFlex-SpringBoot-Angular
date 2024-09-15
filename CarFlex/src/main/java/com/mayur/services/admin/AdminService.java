package com.mayur.services.admin;

import com.mayur.dtos.BookACarDto;
import com.mayur.dtos.CarDto;
import com.mayur.dtos.CarDtoList;
import com.mayur.dtos.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    boolean postCar(CarDto carDto);

    List<CarDto> getAllCars();

    void deleteCar(Long carId);

    CarDto getCarById(Long carId);

    boolean updateCar(Long carId, CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarDtoList searchCar(SearchCarDto searchCarDto);

}
