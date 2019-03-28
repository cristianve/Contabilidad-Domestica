use db_contabilidad_domestica;

-- MONEDAS

insert into Monedas (nombre) values ('EUR');
insert into Monedas (nombre) values ('USD');
insert into Monedas (nombre) values ('JPY');
insert into Monedas (nombre) values ('GBP');
insert into Monedas (nombre) values ('CHF');
insert into Monedas (nombre) values ('AUD');
insert into Monedas (nombre) values ('CAD');
insert into Monedas (nombre) values ('SEK');
insert into Monedas (nombre) values ('HKD');
insert into Monedas (nombre) values ('NOK');

-- TIPOS

insert into Tipos (nombre) values ('Ingreso');
insert into Tipos (nombre) values ('Gasto');
insert into Tipos (nombre) values ('Transferencia');

-- Etiquetas
				/* ESPECIAL */
insert into Etiquetas (nombre) values ('Otros');
				/* TIPO INGRESO */
insert into Etiquetas (nombre, idTipo) values ('Salario', 1);
insert into Etiquetas (nombre, idTipo) values ('Paga Extra Vacaciones', 1);
insert into Etiquetas (nombre, idTipo) values ('Paga Extra Navidad', 1);
				/* TIPO GASTO */
insert into Etiquetas (nombre, idTipo) values ('Electricidad', 2);
insert into Etiquetas (nombre, idTipo) values ('Internet', 2);
insert into Etiquetas (nombre, idTipo) values ('Agua', 2);
				/* TIPO TRANSFERENCIA */
insert into Etiquetas (nombre, idTipo) values ('Mi Esposa', 3);

-- CUENTAS
				
insert into Cuentas (idCuenta,nombre, saldo, idMoneda, descripcion) values (1,'Caixa', 100, 1, 'Mi Esposa');
insert into Cuentas (nombre, saldo, idMoneda, descripcion) values ('BBVA', 25, 1, 'Personal');
insert into Cuentas (nombre, saldo, idMoneda, descripcion) values ('Santander', 0, 1, 'Personal');
insert into Cuentas (nombre, idMoneda) values ('Billetera 2', 1);

-- MOVIMIENTOS
				/* TIPO INGRESO */
insert into Movimientos (idCuentaOrigen, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 1, 2, 1000, '2017-04-15', 'Faltan 500 por pagarme');
				/* TIPO GASTO */
insert into Movimientos (idCuentaOrigen, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 2, 6, 200, '2017-04-17', 'Incluye multa de enero');
                /* TIPO TRANSFERENCIA */
insert into Movimientos (idCuentaOrigen, idCuentaDestino, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 2, 3, 8, 20, '2017-04-18', 'Solo 20?');

-- PREVISIONES
				/* TIPO INGRESO */
insert into Previsiones (idCuentaOrigen, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 1, 2, 2000, '2017-05-15', 'Paga con bono');
				/* TIPO GASTO */
insert into Previsiones (idCuentaOrigen, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 2, 6, 150, '2017-05-17', 'sin multas :D!');
                /* TIPO TRANSFERENCIA */
insert into Previsiones (idCuentaOrigen, idCuentaDestino, idTipo, idEtiqueta, valor, fecha, descripcion) values (1, 2, 3, 8, 30, '2017-05-18', 'Solo 30?');
