Use ring and compojure framework

Create endpoints

1. POST request: /books --> Send json data with {"id":101,"name":"My book", "author":"UST Publications"}
    - The data has to be serialized, validated that name and author must be there in the data
    - once validated, it has to be stored as a file in a directory called books in the local system.
    - Store the book name with the id from the above json
    - Make sure that the id already does not exist.If filename with the id already there, say id exists, use another id.

2. GET /books/:id -> Read the file which has the name of the book.
    - if the file does not exists , say not found.
