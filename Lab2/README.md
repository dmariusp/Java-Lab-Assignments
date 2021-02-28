#Lab2's Assignment - Notes

##Compulsory

1. Create an object-oriented model of the problem. You should have (at least) the following classes: Source, Destination, Problem. 
   The sources and the destinations have names. The sources will also have the property type. The available types will be implemented as an enum . For example:
```
public enum SourceType {
WAREHOUSE, FACTORY;
}
```
Assume S1 is a factory and S2, S3 are warehouses.
2. Each class should have appropriate constructors, getters and setters. 
   Use the IDE features for code generation, such as generating getters and setters.
3. The toString method form the Object class must be properly overridden for all the classes. 
   Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
4. Create and print on the screen the instance of the problem described in the example.
   
After execution, the program displays the following output:
```
Problem{
 sources=[Source{SourceType=FACTORY, names='S1'}, Source{SourceType=WAREHOUSE, names='S2'}, Source{SourceType=WAREHOUSE, names='S3'}]
 destinations=[Destination{names='D1'}, Destination{names='D2'}, Destination{names='D3'}]
 supply=[10, 35, 25]
 demands=[20, 25, 25]
 costMatrix=[[2, 3, 1], [5, 4, 8], [5, 6, 8]]
 }
```
