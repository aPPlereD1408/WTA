package de.wtademo.docudemo.repository;

import de.wtademo.docudemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Hier können später spezielle SQL-Queries definiert werden
}
