package com.pushpak.restaurantlisting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushpak.restaurantlisting.dto.RestaurantDto;
import com.pushpak.restaurantlisting.entity.Restaurant;
import com.pushpak.restaurantlisting.mapper.RestaurantMapper;
import com.pushpak.restaurantlisting.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtoList = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
                .toList();
        return restaurantDtoList;
    }
}
