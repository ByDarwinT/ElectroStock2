
# ElectroStock Docker Deployment

## 1. Overview

ElectroStock is a Spring Boot application that uses PostgreSQL for inventory management.

Docker Compose manages two services:

- **app:** Spring Boot application running on port 8080.
- **db:** PostgreSQL 16 database running on the internal Docker network.

## 2. Requirements

- Docker Engine
- Docker Compose v2
- Git

Java and Maven are provided by the Docker build image.

## 3. Environment Configuration

Create a local environment file from the example:

```bash
cp .env.example .env
```

Replace the placeholder with a secure database password.

Never commit `.env` or database credentials to Git.

## 4. Build and Run

From the project root:

```bash
docker compose config --quiet
docker compose up -d --build
```

Check container status:

```bash
docker compose ps
```

Expected services:

- `app`: Running
- `db`: Running (healthy)

## 5. Verify the Application

Open:

```text
http://localhost:8080/
```

Verify the products API:

```bash
curl http://localhost:8080/api/products
```

The API should return a JSON array.

## 6. Useful Commands

View application logs:

```bash
docker compose logs --tail=50 app
```

Stop containers:

```bash
docker compose down
```

Rebuild the application:

```bash
docker compose up -d --build
```

## 7. Data Persistence

PostgreSQL stores its data in the `postgres_data` Docker volume.

Running `docker compose down` does not remove this volume.

Avoid `docker compose down -v` unless database deletion is intentional.

## 8. Security Considerations

- Do not commit credentials.
- Do not expose PostgreSQL port 5432 publicly.
- Restrict access to application port 8080 when deploying to EC2.
- Configure HTTPS before using the application in production.
- Use environment-specific secrets for deployment.

## 9. Deployment Workflow

The repository follows this promotion flow:

1. Feature branches are merged into `dev`.
2. Validated changes are promoted to `qa`.
3. Approved changes are promoted to `main`.
4. Deployment to AWS EC2 is performed from the approved version.

Automated deployment will be introduced in a future CI/CD improvement.
