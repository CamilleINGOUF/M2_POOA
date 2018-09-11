package FactoryMethod;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(Animal.makeAnimal(Animal.CAT));
		animals.add(Animal.makeAnimal(Animal.DOG));
		
		for(Animal a : animals)
			a.pet();
	}

}
