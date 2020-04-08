# Design patterns:

## MVC Design pattern
Our whole project uses **MVC** design pattern. And we seperated them into different packages which can be seen in our UML diagram.

## The "Option" class uses builder
For the **Option** class, I used builder pattern as it contains a lot of fields, and most of them are optional. Therefore, I applied builder pattern to create a Option.

## The "comparators" use "Factory pattern".

Reasoning: 
* The "sort" method have to use different "comparators" to do different comparision.
* According to SOLID principle, sort doesn't need to know about what kind of comparator is passed
in. It's job is just to sort.
* Therefore, a factory pattern will generate a comparator according to the parameters that we pass
in. 
* Even though now we only have two comparators, factory pattern makes sure the efficiency of adding
new comparators in the future. 

## The "filter" uses "Factory pattern & Observer pattern".

Reasoning:
* In order to build filters, we use factory design pattern. Filter() does not need to know which 
concrete filters would be used, but only make filters according to the command line arguments.
* Using polymorphism to implement different concrete filters and store them in a filter stash.
* Then we use Observer design pattern on a list of filters. For each filter, we invoke filter()
and modify the same to-do List regardless of the order. 
    
