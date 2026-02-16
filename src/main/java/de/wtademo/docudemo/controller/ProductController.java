package de.wtademo.docudemo.controller;

import de.wtademo.docudemo.model.Product;
import de.wtademo.docudemo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Entität {@link Product}.
 * Stellt Endpunkte zur Manipulation und Abfrage des Produktkatalogs unter dem Basispfad /api/products bereit.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Produkt-API", description = "Technische Schnittstelle zur Produktverwaltung")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Abruf aller Produkte", 
               description = "Führt eine Datenbankabfrage über den ProductService aus und liefert die Ergebnismenge als JSON-Array zurück.")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    /* @GetMapping("/{id}")
    @Operation(summary = "Abruf eines Produkts", 
               description = "Führt eine Datenbankabfrage über den ProductService aus und liefert das Produkt mit der angegebenen ID als JSON-Objekt zurück. Weitere Beschriebung folgt....")
    public Product getProductById(@PathVariable Long id) {
        return service.findById(id);
    } */

    @PostMapping
    @Operation(summary = "Produkterstellung",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Status: OK. Objekt erfolgreich persistiert."),
                   @ApiResponse(responseCode = "400", description = "Status: Bad Request. Validierung des Schemas fehlgeschlagen.")
               })
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }
}