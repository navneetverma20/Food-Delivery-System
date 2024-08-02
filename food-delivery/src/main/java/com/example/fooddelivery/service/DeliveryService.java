package com.example.fooddelivery.service;

import javax.persistence.EntityNotFoundException;
import com.example.fooddelivery.model.Delivery;
import com.example.fooddelivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery updateDeliveryStatus(Long deliveryId, String status) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }
}
