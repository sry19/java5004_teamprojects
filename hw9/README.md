#Design patterns:

##The "comparators" use "Factory pattern".

Reasoning: 
* The "sort" method have to use different "comparators" to do different comparision.
* According to SOLID principle, sort doesn't need to know about what kind of comparator is passed
in. It's job is just to sort.
* Therefore, a factory pattern will generate a comparator according to the parameters that we pass
in. 
* Even though now we only have two comparators, factory pattern makes sure the efficiency of adding
new comparators in the future. 
    