SELECT car.idCar, supercar.make
FROM car
RIGHT JOIN supercar ON car.idCar = supercar.idSuperCar;

SELECT supercar.idSuperCar, car.make
FROM supercar
RIGHT JOIN car ON supercar.idSuperCar = car.idCar;

SELECT supercar.idSuperCar, car.model
FROM supercar
RIGHT JOIN car ON supercar.idSuperCar = car.idCar;

SELECT car.idCar, supercar.model
FROM car
RIGHT JOIN supercar ON car.idCar = supercar.idSuperCar;
