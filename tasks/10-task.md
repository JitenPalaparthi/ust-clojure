
Take a list and a set of same size 


list1 = 100, 200, nil, 400 , nil , 1 , nil 
set1 = 100 ,200 , 300 , nil, 400, nil, 500 , 600

- write a function to accept list and set as input parameters and return the another list with the sum of list1 and set1 at each element level
- where ever there is nil, consider it as 0
- if both the list and set are nil, then return list with 0 (0)
- if any of the list or set is nil then return only the list with values and also if there are any nils in the values of list or set , replace with 0 
- make sure that the length of list and set are same. If not the remaining should be considerd as 0s. Example if list is 4 elements and set is 2 elements, then the remaining 2 elements to be added as 0

- return list is : 200, 400  , 300,  400, 400, 1, 500 , 600

(defn sum-list-set [list1 set1]
;; the logic to add both the lists.
list2
)

- to add new elements to the list (conj list elem)