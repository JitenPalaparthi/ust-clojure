- create a matrix as below
[1 1250 3500]
[2 1400 3600]
[3 1100 3400]
[4 1200 3800]

- add all elements of each row and create a new element with the sum
- (add-rows-to-list) -> list (a new matrix with sum of rows as the last element as below)
[1 1250 3500 4751]
[2 1400 3600 5002]
[3 1100 3400 4503]
[4 1200 3800 5004]

- print the matrix with the sum

- create a function to return sum of row with index should return the sum of that row 

- (sum-of-row 1) -> 4751
- what if there is no row , return -1 ,  (sum-of-row 10) -> -1

- create a function to input the column and give the sum of that column
- (sum-of-column 1) -> 10
- if 1 is given it should return 10  (+ 1 2 3 4)
- if 2 is given it shoudl return 4950 (+ 1250 1400 1100 1200)

- if index is not avaialbe return -1 (later on can implement try catch way of exeception handling but now it should not give a runtime error)

