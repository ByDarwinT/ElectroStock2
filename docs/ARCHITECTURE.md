# ElectroStock Architecture

## Project Overview

ElectroStock is a web application built with Java, Spring Boot, PostgreSQL, Bootstrap, and JavaScript.

The application provides two catalogs: an electronic products catalog connected to PostgreSQL and a Pokémon catalog that consumes data from PokéAPI.

## Backend Architecture

The backend follows a layered architecture:

- **Controller:** Handles HTTP requests and REST endpoints.
- **Service:** Coordinates business operations.
- **Repository:** Provides database access using Spring Data JPA.
- **Model:** Defines the entities stored in PostgreSQL.

## Frontend Architecture

The frontend uses HTML, Bootstrap, jQuery, and Vanilla JavaScript to display responsive cards, search filters, and item details.

## Data Sources

- PostgreSQL stores electronic product information.
- PokéAPI provides external Pokémon data through REST endpoints.

## Version Control

The project uses Git and GitHub with development (`dev`), quality assurance (`qa`), and production (`main`) branches.