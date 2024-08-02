package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Delivery;
import com.example.fooddelivery.service.DeliveryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// Add other necessary imports

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PutMapping("/{deliveryId}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable Long deliveryId, @RequestBody String status) {
        Delivery updatedDelivery = deliveryService.updateDeliveryStatus(deliveryId, status);
        return ResponseEntity.ok(updatedDelivery);
    }
}
