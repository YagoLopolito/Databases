SELECT COUNT(idCar), make
FROM car
GROUP BY make
HAVING COUNT(idCar) <10;

SELECT COUNT(idCar), model
FROM car
GROUP BY model
HAVING COUNT(idCar) <10;

SELECT COUNT(idSuperCar), model
FROM supercar
GROUP BY model
HAVING COUNT(idSuperCar) <10;

SELECT COUNT(idSuperCar), make
FROM supercar
GROUP BY make
HAVING COUNT(idSuperCar) <10;

SELECT COUNT(idWage), mount
FROM salary
GROUP BY mount
HAVING COUNT(idWage) <10;

