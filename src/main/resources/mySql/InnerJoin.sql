select *
from Station
inner join Garages
on Station.stationNum = Garages.stationNum;

select *
from Invoices
inner join Orders
on Invoices.estimatedTimeOfArrival = Orders.estimatedTimeOfArrival;

select *
from Invoices
inner join Orders
on Invoices.distance = Orders.distance;

select *
from Invoices
inner join Orders
on Invoices.destination = Orders.destination;


