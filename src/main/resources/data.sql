INSERT INTO alquilerhardware.profesor (id, apellidos, nombre)
    VALUE
    (1, 'Benitez Chico', 'Francisco'),
    (2, 'Garcia Perez', 'Juan'),
    (4, 'Gonzalez Perez', 'Jose'),
    (3, 'Gonzalez Lopez', 'Maria'),
    (5, 'Gonzalez Rodriguez', 'Maria'),
    (6, 'Gonzalez Sanchez', 'Jose'),
    (7, 'Gonzalez Sanchez', 'Maria');

INSERT INTO alquilerhardware.aula_informatica (id, numero_aula, planta)
    VALUE
    (1, 11, 2),
    (2, 13, 2);


INSERT INTO alquilerhardware.carrito_pcs (id, numero_pcs, planta, sistema_operativo)
    VALUE
    (1, 10, 1,'WINDOWS'),
    (2, 10, 1,'GUADALINEX'),
    (3, 10, 2,'WINDOWS'),
    (4, 10, 2,'GUADALINEX');

INSERT INTO alquilerhardware.carrito_tablets (id, numero_tablets, planta)
    VALUE
    (1, 10, 1),
    (2, 10, 1),
    (3, 10, 2),
    (4, 10, 2);

INSERT INTO alquilerhardware.roles VALUES (1,'ADMIN');
INSERT INTO alquilerhardware.roles VALUES (2,'USER_CARRITO_1PLANTA');
INSERT INTO alquilerhardware.roles VALUES (3,'USER_CARRITO_2PLANTA');