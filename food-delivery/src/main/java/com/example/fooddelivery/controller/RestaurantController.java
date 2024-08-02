package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.MenuItem;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.service.RestaurantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
// Add other necessary imports

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }

    @PostMapping("/{restaurantId}/menu")
    public ResponseEntity<MenuItem> addMenuItem(@PathVariable Long restaurantId, @RequestBody MenuItem menuItem) {
        menuItem.setRestaurant(new Restaurant(restaurantId));
        MenuItem savedMenuItem = restaurantService.saveMenuItem(menuItem);
        return ResponseEntity.ok(savedMenuItem);
    }

    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<List<MenuItem>> getMenuItems(@PathVariable Long restaurantId) {
        List<MenuItem> menuItems = restaurantService.getMenuItemsByRestaurant(restaurantId);
        return ResponseEntity.ok(menuItems);
    }
}
