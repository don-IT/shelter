-- ==============================
-- Flyway Migration: Initial Schema
-- ==============================

-- Table: shelters
CREATE TABLE shelters (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          address VARCHAR(255),
                          phone VARCHAR(50)
);

-- Table: animals
CREATE TABLE animals (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         species VARCHAR(100),
                         age INTEGER,
                         status VARCHAR(50),
                         shelter_id BIGINT,
                         CONSTRAINT fk_animal_shelter FOREIGN KEY (shelter_id)
                             REFERENCES shelters (id)
                             ON DELETE SET NULL
);

-- Table: adopters
CREATE TABLE adopters (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          contact VARCHAR(255),
                          city VARCHAR(100)
);

-- Join Table: adoptions (for Many-to-Many)
CREATE TABLE adoptions (
                           animal_id BIGINT NOT NULL,
                           adopter_id BIGINT NOT NULL,
                           PRIMARY KEY (animal_id, adopter_id),
                           CONSTRAINT fk_adoption_animal FOREIGN KEY (animal_id)
                               REFERENCES animals (id)
                               ON DELETE CASCADE,
                           CONSTRAINT fk_adoption_adopter FOREIGN KEY (adopter_id)
                               REFERENCES adopters (id)
                               ON DELETE CASCADE
);

-- Table: employees
CREATE TABLE employees (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           role VARCHAR(100),
                           shelter_id BIGINT,
                           CONSTRAINT fk_employee_shelter FOREIGN KEY (shelter_id)
                               REFERENCES shelters (id)
                               ON DELETE SET NULL
);

-- Table: medical_checks
CREATE TABLE medical_checks (
                                id BIGSERIAL PRIMARY KEY,
                                date DATE NOT NULL,
                                description TEXT,
                                animal_id BIGINT,
                                employee_id BIGINT,
                                CONSTRAINT fk_medicalcheck_animal FOREIGN KEY (animal_id)
                                    REFERENCES animals (id)
                                    ON DELETE CASCADE,
                                CONSTRAINT fk_medicalcheck_employee FOREIGN KEY (employee_id)
                                    REFERENCES employees (id)
                                    ON DELETE SET NULL
);
