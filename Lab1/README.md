#Lab1's Assignment - Notes

##Compulsory
Write a Java application that implements the following operations:

1. Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
2. Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
3. Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
4. Compute the result obtained after performing the following calculations:
* multiply n by 3;
* add the binary number 10101 to the result;
* add the hexadecimal number FF to the result;
* multiply the result by 6;
5. Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
6. Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

After execution, the program displays the following output:
```
Hello World!
874406
2623218
2623239
2623494
15740964
9
Willy-nilly, this semester I will learn Java
```

##Optional
Let n be an integer given as a command line argument. Validate the argument!

1. Create a n x n matrix, representing the adjacency matrix of a random graph .
2. Display on the screen the generated matrix (you might want to use the geometric shapes from the Unicode chart to create a "pretty" representation of the matrix).
3. Verify if the generated graph is connected and display the connected components (if it is not).
4. Assuming that the generated graph is connected, implement an algorithm that creates a partial tree of the graph. Display the adjacency matrix of the tree. (X)
5. For larger n display the running time of the application in nanoseconds (DO NOT display the matrices). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G. (X)
6. Launch the application from the command line, for example: java Lab1 100.

After execution, on the case in which the graph is not connected, the program displays the following output:
```
Introduceti numarul n:
8
Numar de muchii:2

Muchia este: 4 3

Muchia este: 3 7

0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 1 
0 0 0 1 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 1 0 0 0 0 

Mai multe componente conexe
[0]
Mai multe componente conexe
[1]
Mai multe componente conexe
[2]
Mai multe componente conexe
[3, 4, 7]
Mai multe componente conexe
[5]
Mai multe componente conexe
[6]
```

After execution, on the case in which the graph is connected, the program displays the following output:
```
Introduceti numarul n:
5
Numar de muchii:8

Muchia este: 3 2

Muchia este: 1 3

Muchia este: 4 3

Muchia este: 2 1

Muchia este: 0 2

Muchia este: 3 0

Muchia este: 2 4

Muchia este: 4 1

0 0 1 1 0 
0 0 1 1 1 
1 1 0 1 1 
1 1 1 0 1 
0 1 1 1 0 
Graf conex :)
[0, 2, 3, 1, 4]

```
