package ru.job4j.generics;

public class Animal {
    String name;
    int population;

    public Animal(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
