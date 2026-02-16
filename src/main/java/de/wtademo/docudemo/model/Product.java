package de.wtademo.docudemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Repräsentiert ein Produkt im Katalog.
 * Dies ist die JPA Entity, die auf die Tabelle 'products' gemappt wird.
 *
 * @author Google Gemini
 */
@Entity
@Data
@Table(name = "products")
@Schema(description = "Das Datenmodell für ein Produkt")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Automatisch generierte ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Der Name des Produkts", example = "Super Widget 3000")
    private String name;

    @Schema(description = "Preis in Euro", example = "99.99")
    private Double price;

    /**
     * Eine kurze Beschreibung des Produkts. Optionales Feld.
     */
    @Schema(description = "Optionale Beschreibung")
    private String description;
}
