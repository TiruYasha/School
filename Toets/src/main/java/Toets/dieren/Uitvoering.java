package Toets.dieren;

import static java.lang.System.out;

public class Uitvoering {

    public static void main(String[] args) {
        // A/B
        IdentificationKey<Animal> key = new IdentificationKey<>();

        IdentificationNode<Animal> question = new IdentificationNode<>("Leeft het op het land?");

        IdentificationNode<Animal> question2 = new IdentificationNode<>("Eet het fruit?");
        IdentificationNode<Animal> dolphin = new IdentificationNode<>(new Animal("Dolfijn"));
        IdentificationNode<Animal> elephant = new IdentificationNode<>(new Animal("Olifant"));
        IdentificationNode<Animal> monkey = new IdentificationNode<>(new Animal("Aap"));

        question2.setLeft(elephant);
        question2.setRight(monkey);
        question.setLeft(dolphin);
        question.setRight(question2);

        key.addNode(question);

        key.start();
        out.println(key.getQuestion());
        key.navigate(true);
        out.println(key.getQuestion());
        key.navigate(false);

        if(key.found()){
            out.println(key.getSpecies().name);
        }


        // C
        key.start();
        out.println(key.getQuestion());
        key.navigate(false);
        key.extend("Heeft het kieuwen?", new Animal("Tonijn"));
        out.println(key.getQuestion());
        key.navigate(true);
        out.println(key.getSpecies().name);

    }
}
