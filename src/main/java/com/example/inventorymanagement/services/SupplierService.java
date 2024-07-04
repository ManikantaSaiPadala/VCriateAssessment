package com.example.inventorymanagement.services;

import com.example.inventorymanagement.models.Supplier;
import com.example.inventorymanagement.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier.setName(supplierDetails.getName());
            supplier.setContactInfo(supplierDetails.getContactInfo());
            supplier.setProducts(supplierDetails.getProducts());
            return supplierRepository.save(supplier);
        } else {
            return null;
        }
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        return supplierOptional.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found with id " + id));
    }
}
