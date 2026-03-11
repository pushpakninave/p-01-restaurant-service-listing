package com.pushpak.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pushpak.restaurantlisting.dto.RestaurantDto;
import com.pushpak.restaurantlisting.entity.RestaurantEntity;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantEntity mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(RestaurantEntity restaurant);
}
