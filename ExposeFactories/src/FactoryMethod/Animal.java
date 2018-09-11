package FactoryMethod;

public abstract class Animal 
{
	public static final int CAT = 1;
	public static final int DOG = 2;
	
	public static Animal makeAnimal(int flag)
	{
		switch(flag)
		{
			case CAT: return new Cat();
			case DOG: return new Dog();
			default:return null;
		}
	}
	
	public abstract void pet();
}
