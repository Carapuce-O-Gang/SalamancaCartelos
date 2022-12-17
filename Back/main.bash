docker build -t mysql:salamanca .
docker run --name salamanca-db -d -p 3306:3306 mysql:salamanca