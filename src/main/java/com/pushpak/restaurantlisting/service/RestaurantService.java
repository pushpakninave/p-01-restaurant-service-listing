package com.pushpak.restaurantlisting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushpak.restaurantlisting.dto.RestaurantDto;
import com.pushpak.restaurantlisting.entity.RestaurantEntity;
import com.pushpak.restaurantlisting.mapper.RestaurantMapper;
import com.pushpak.restaurantlisting.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtoList = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant))
                .toList();
        return restaurantDtoList;
    }

    public Optional<RestaurantDto> getRestaurantById(Long id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return Optional.ofNullable(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant));
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        RestaurantEntity restaurantEntity = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        RestaurantEntity savedRestaurant = restaurantRepository.save(restaurantEntity);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }
}
