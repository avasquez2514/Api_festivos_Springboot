-- Crear tabla tipo_festivo
CREATE TABLE tipo_festivo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    modo_calculo VARCHAR(255)
);

-- Insertar valores en la tabla tipo_festivo
INSERT INTO tipo_festivo (nombre, modo_calculo) VALUES ('Fijo', 'No se puede variar');
INSERT INTO tipo_festivo (nombre, modo_calculo) VALUES ('Ley de Puente Festivo', 'Se traslada al lunes siguiente');
INSERT INTO tipo_festivo (nombre, modo_calculo) VALUES ('Basado en Pascua', 'Se calcula en base al Domingo de Pascua');
INSERT INTO tipo_festivo (nombre, modo_calculo) VALUES ('Basado en Pascua y Ley de Puente Festivo', 'Basado en Pascua y trasladado al lunes siguiente si aplica');

-- Crear tabla festivo
CREATE TABLE festivo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dia INT,
    mes INT,
    nombre VARCHAR(255),
    tipo INT,
    dias_desde_pascua INT,
    FOREIGN KEY (tipo) REFERENCES tipo_festivo(id)
);

-- Insertar valores en la tabla festivo
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (1, 1, 'Año Nuevo', 1, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (6, 1, 'Día de Reyes', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (19, 3, 'San José', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Jueves Santo', 3, -3);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Viernes Santo', 3, -2);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Domingo de Pascua', 3, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (1, 5, 'Día del Trabajo', 1, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Ascensión del Señor', 4, 40);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Corpus Christi', 4, 61);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (0, 0, 'Sagrado Corazón de Jesús', 4, 68);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (29, 6, 'San Pedro y San Pablo', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (20, 7, 'Independencia Colombia', 1, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (7, 8, 'Batalla de Boyacá', 1, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (15, 8, 'Asunción de la Virgen', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (12, 10, 'Día de la Raza', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (1, 11, 'Todos los santos', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (11, 11, 'Independencia de Cartagena', 2, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (8, 12, 'Inmaculada Concepción', 1, 0);
INSERT INTO festivo (dia, mes, nombre, tipo, dias_desde_pascua) VALUES (25, 12, 'Navidad', 1, 0);
