Документация:
[API Docs (Swagger UI)](https://vyacheslav-kanov.github.io/GhostLagAPI/api/)


## Как запустить базу данных PostgreSQL

Для локального запуска БД используется Docker и docker‑compose. Устанавливать PostgreSQL вручную не требуется.

### Шаг 1. Установить Docker

1. Скачайте Docker Desktop для вашей ОС с официального сайта.
2. Установите Docker Desktop (потребуется немного свободного места на диске C).
3. После установки запустите Docker Desktop и убедитесь, что он работает (значок в трее без ошибок).

### Шаг 2. Запустить PostgreSQL через docker-compose

В корне репозитория уже лежит файл `docker-compose.yml` со службой `postgres`.
Выполните в терминале из корня проекта:

```bash
docker compose up -d postgres
```

Это команда:

- скачает образ `postgres` из Docker Hub (если его ещё нет локально);
- запустит контейнер с базой `tournament` и пользователем `postgres/postgres`;
- пробросит порт PostgreSQL на `localhost:5433`, как указано в `application.properties`.

Проверить, что контейнер запущен:

```bash
docker ps
```

В списке должен быть сервис `postgres`.

### Шаг 3. Настройки подключения в приложении

Spring Boot уже сконфигурирован для подключения к этой базе:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/tournament
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

После запуска контейнера достаточно запустить приложение (`mvn spring-boot:run` или через IDE).

### Шаг 4. Остановка базы

Чтобы остановить контейнер с БД:

```bash
docker compose down
```

Если нужно только временно приостановить:

```bash
docker compose stop postgres
```


