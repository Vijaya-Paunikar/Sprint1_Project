package com.example.controller;

import com.example.model.Service;
import com.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController 
{
	@Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/getServices")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createService")
    public ResponseEntity<String> addService(@RequestBody Service service) {
        serviceRepository.save(service);
        return new ResponseEntity<>("Service created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateService(@PathVariable Long id, @RequestBody Service updatedService) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            Service existingService = service.get();
            // Update service details
            existingService.setServiceName(updatedService.getServiceName());
            existingService.setDescription(updatedService.getDescription());
            existingService.setPricing(updatedService.getPricing());
            existingService.setSla(updatedService.getSla());

            serviceRepository.save(existingService);
            return new ResponseEntity<>("Service details updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            serviceRepository.deleteById(id);
            return new ResponseEntity<>("Service deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        }
    }
}
