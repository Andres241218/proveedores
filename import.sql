-- Tabla Seccional
INSERT INTO seccional (nombre) VALUES ('Seccional Norte');
INSERT INTO seccional (nombre) VALUES ('Seccional Sur');

-- Tabla Usuario
INSERT INTO usuario (nombre, correo, rol) VALUES ('Juan Perez', 'juan.perez@example.com', 'Administrador');
INSERT INTO usuario (nombre, correo, rol) VALUES ('Maria Lopez', 'maria.lopez@example.com', 'Ejecutor');
INSERT INTO usuario (nombre, correo, rol) VALUES ('Carlos Martinez', 'carlos.martinez@example.com', 'Administrador');

-- Tabla EjecutorGasto
INSERT INTO ejecutorgasto (id_usuario, id_seccional) VALUES (2, 1);
INSERT INTO ejecutorgasto (id_usuario, id_seccional) VALUES (2, 2);

-- Tabla Categoria
INSERT INTO categoria (nombre) VALUES ('Alimentos y Bebidadas');
INSERT INTO categoria (nombre) VALUES ('Insumos Para la Operacion');
INSERT INTO categoria (nombre) VALUES ('Articulos y Prendas para la institucion');
INSERT INTO categoria (nombre) VALUES ('Laboratorios y combustibles');

-- Tabla Proveedor
INSERT INTO proveedor (nombre, nit, tipo, telefono, direccion, id_predecesor, id_categoria) 
VALUES ('Proveedor A', '1002301', 'Contratista', '555-1234', 'Calle Falsa 123', null, 1);
INSERT INTO proveedor (nombre, nit, tipo, telefono, direccion, id_predecesor, id_categoria) 
VALUES ('Proveedor B', '1002304', 'Contratista', '555-5678', 'Avenida Siempreviva 456', 1, 2);
INSERT INTO proveedor (nombre, nit, tipo, telefono, direccion, id_predecesor, id_categoria) 
VALUES ('Proveedor C', '1002303', 'Contratista', '555-5678', 'Avenida Siempreviva 456', 1, 3);
INSERT INTO proveedor (nombre, nit, tipo, telefono, direccion, id_predecesor, id_categoria) 
VALUES ('Proveedor D', '1002305', 'Contratista', '555-5678', 'Avenida Siempreviva 456', 2, 3);

-- Tabla Evaluacion
INSERT INTO evaluacion (fecha, calificacion, id_proveedor, id_usuario) 
VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 4, 1, 1);
INSERT INTO evaluacion (fecha, calificacion, id_proveedor, id_usuario) 
VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 3, 1, 1);
INSERT INTO evaluacion (fecha, calificacion, id_proveedor, id_usuario) 
VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 4.5, 1, 1);
INSERT INTO evaluacion (fecha, calificacion, id_proveedor, id_usuario) 
VALUES (TO_DATE('2023-04-07', 'YYYY-MM-DD'), 4.5, 2, 3);

-- Tabla Pregunta
INSERT INTO pregunta (pregunta, id_evaluacion, ) 
VALUES ('¿El proveedor responde oportunamente a los requerimientos(cotizaciones)?.', 1 );
INSERT INTO pregunta (pregunta, id_evaluacion, ) 
VALUES (' ¿La entrega se realizó en los tiempos pactados en la orden de compra/contrato?.', 1 );
INSERT INTO pregunta (pregunta, id_evaluacion, ) 
VALUES ('¿El proveedor siempre realiza las entregas enlos lugares donde indica la Universidad?.', 1 );

