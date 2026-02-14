package de.wtademo.docudemo.controller;

import de.wtademo.docudemo.model.Product;     // WICHTIG: de.wtademo...
import de.wtademo.docudemo.service.ProductService; // WICHTIG: de.wtademo...
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Produkt-API", description = "Verwaltung des Produktkatalogs")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Alle Produkte holen", description = "Liefert eine Liste aller verfügbaren Produkte aus der DB.")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Neues Produkt anlegen",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Produkt erfolgreich angelegt"),
                   @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten")
               })
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }
}
