-- use db_contabilidad_domestica;
drop database db_contabilidad_domestica;
 -- select * from cuentas;
-- Consulta Movimientos
/*
select m.idMovimiento, 
	   c.nombre as 'Cuenta', 
       t.nombre as 'Tipo', 
       e.nombre as 'Etiqueta', 
       m.valor, 
       m.fecha, 
       m.descripcion  
from Movimientos m
left join Cuentas c on (m.idCuenta=c.idCuenta)
left join Tipos t on (m.idTipo=t.idTipo)
left join Etiquetas e on (m.idEtiqueta=e.idEtiqueta);
*/

-- delete from Cuentas WHERE idCuenta=1;

select * from Cuentas;
select * from Movimientos;
select * from Previsiones;
select * from Monedas;
delete from Monedas where idMoneda=1;
delete from Cuentas where idCuenta=1;
delete from Movimientos where idMovimiento=3;