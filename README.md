
# Carshowroom REST-Client

It's a rest client application for Practical task.

# Getting Started
#### Download server sources:
```
https://github.com/inkrot/carshowroom-restclient.git
```
# Use examples
## Add order
```
add-order --customer "Rest Customer" --model "camry" --brand "Toyota" --options 1,2
```
- **customer** name of the customer
- **model** name of the car model
- **brand** name of the car brand
- **options** list of options ids, separated by commas
## Update order
```
update-order --id 1 --customer "New"
```
- **id** order identificator
- **customer** one of the parametr that will be changed (see all id ***add-order*** method)
## Delete order
```
delete-order 50
```
- **id** order identificator
## Get all orders
```
get-all-orders
```
## Get all orders by status and customer
```
get-all-orders-sc --sid 1 --cid 1 --cname "New"
```
- **sid** status identificator
- **scode** status code
- **cid** customer identificator
- **cname** customer name

## Get order by id
```
get-order 1
```
- **id** order identificator
