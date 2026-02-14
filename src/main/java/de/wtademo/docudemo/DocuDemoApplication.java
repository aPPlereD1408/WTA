package de.wtademo.docudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptklasse der Anwendung.
 * Startet den Spring Boot Context und scannt automatisch alle Komponenten
 * (Controller, Services, Repositories) im selben Package oder darunter.
 */
@SpringBootApplication
public class DocuDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocuDemoApplication.class, args);
    }

}
