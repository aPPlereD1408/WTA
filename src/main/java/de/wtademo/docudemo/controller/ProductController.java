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

    /**
     * Initialisiert den Controller mit dem erforderlichen {@link ProductService}.
     * @param service Der Service zur Persistenzierung und Abfrage von Produkten.
     */
    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * Ruft den aktuellen Bestand aller Produkte ab.
     * * @return List<Product> Eine Liste aller in der Datenbank persistierten Produkte.
     */
    @GetMapping
    @Operation(summary = "Abruf aller Produkte", 
               description = "Führt eine Datenbankabfrage über den ProductService aus und liefert die Ergebnismenge als JSON-Array zurück.")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    /**
     * Persistiert ein neues Produktobjekt.
     * * @param product Das zu speichernde Produkt-Objekt im RequestBody.
     * @return Product Das erfolgreich gespeicherte Objekt inklusive generierter Identifikatoren.
     * @throws RuntimeException bei Validierungsfehlern oder Datenbankkonflikten.
     */
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