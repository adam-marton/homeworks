curl --verbose --write-out "\n" --request POST --data @02-addMovie.json --header "Content-Type: application/json" --cookie-jar cart-cookies.txt --cookie cart-cookies.txt "http://localhost:8080/movie-adam.marton-web/rest/movie"
