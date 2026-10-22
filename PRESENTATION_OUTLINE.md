# Presentation Outline — ElectroStock and PokéAPI

## Slide 1 — Project overview
ElectroStock: dual-source product and Pokémon catalogs with responsive UI.

## Slide 2 — Objective
Develop and explain a Java web system that demonstrates local persistence, REST endpoints, external API consumption and responsive frontend interactions.

## Slide 3 — Scope
Includes product backend CRUD, read-only product catalog, PokéAPI read-only catalog, search with four-second debounce, type/generation filters, detail modals. Excludes authentication, shopping cart, Pokémon persistence and Pokémon modifications.

## Slide 4 — Technologies and libraries
Java 17, Spring Boot 4.0.1, Spring MVC, Spring Data JPA, Hibernate, PostgreSQL, Maven, Bootstrap 5, jQuery 3.7.1, vanilla JavaScript, PokéAPI. Debounce is an algorithmic technique rather than a separate dependency.

## Slide 5 — Design pattern and architecture
Layered backend with Controller → Service → Repository → PostgreSQL. Repository pattern and dependency injection. Browser handles UI and external PokéAPI calls. MVC-style responsibilities, with REST JSON replacing template-based server views.

## Slide 6 — Paradigms
Object-oriented Java, declarative annotations, functional list operators, event-driven DOM events, asynchronous Promise-based requests.

## Slide 7 — Own CRUD API
Explain GET collection, GET item, POST, PUT and DELETE; show JSON and HTTP status codes.

## Slide 8 — External API chaining
`/pokemon/{id}` + `/pokemon-species/{id}` in parallel → extract species evolution URL → `/evolution-chain/{id}` → one detailed modal.

## Slide 9 — Search and filters
jQuery `.on('input')`, 4-second debounce with timers, type/generation select filters, Promise caches, local intersection by name/ID + memberships.

## Slide 10 — Responsive design
Bootstrap cards, grid breakpoints: mobile 1, tablet 2, desktop 3 columns; modal dialog.

## Slide 11 — Demonstration and tests
Show both URLs, search, select types and generations, click a Pokémon to see image, stats, description and evolutions. Display browser Network and Console tabs; include Playwright E2E results after actually running them.

## Slide 12 — Results, limitations and future work
Two data sources successfully integrated as a single website; caveats: network dependencies and read-only UI. Future: automated E2E suite, pagination strategy, stronger error retry, typed DTOs.
