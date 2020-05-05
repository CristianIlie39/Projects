public class Main {
    public static void main(String[] args) {

    // vrem sa cream 2 animale, 2 animale terestre, 2 mamifere, 2 ierbivore, 2 carnivore, 2 animale acvatice, 2 animale de apa dulce, 2 animale de apa sarata, 2 animale aeriene, 2 animale aeriene pradatoare si 2 animale aeriene nepradatoare

    // cream 2 ANIMALE
        Animal ANIMAL1 = new Animal("maro", 4, "urs");
        Animal ANIMAL2 = new Animal("gri", 4, "elefant");

        // 2 Animale Terestre
        TerrestrialAnimal terrestrialAnimal1 = new TerrestrialAnimal("gri", 4, "sobolan", "merge", false);
        TerrestrialAnimal terrestrialAnimal2 = new TerrestrialAnimal("crem", 4, "leu", "alearga", true);

            // 2 Mamifere
            Mammal mammal1 = new Mammal("maro", 4, "caprioara", "alearga", false, 2);
            Mammal mammal2 = new Mammal("alb", 4, "porc", "merge", false, 10);

            // 2 Ierbivore
            HerbivorousAnimal herbivorousAnimal1 = new HerbivorousAnimal("alb", 4, "oaie", "merge", false, true);
            HerbivorousAnimal herbivorousAnimal2 = new HerbivorousAnimal("alb", 4, "iepure", "topaie", false, true);

            // 2 Carnivore
            CarnivorousAnimal carnivorousAnimal1 = new CarnivorousAnimal("negru", 4, "pantera", "alearga", true, true);
            CarnivorousAnimal carnivorousAnimal2 = new CarnivorousAnimal("roscat", 4, "vulpe", "merge", true, true) ;

        // 2 Animale Acvatice
            // 2 animale de apa dulce
            // 2 animale de apa sarata
        // 2 Animale Aeriene
            // 2 animale aeriene pradatoare
            // 2 animale aeriene nepradatoare

    // vrem sa vedem culoarea animalului ANIMAL1
    System.out.println("culoarea animalului ANIMAL1 este: " + ANIMAL1.getColor());
    // vrem sa vedem cate membre are animalul ANIMAL1
    System.out.println("numarul membrelor ANIMAL1 este: " + ANIMAL1.getMemberNumber());
    // vrem sa vedem specimenul animalului ANIMAL1
    System.out.println("specimenul animalului ANIMAL1 este: " + ANIMAL1.getSpecimen());
    // vrem sa vedem specimenul animalului ANIMAL2
    System.out.println("specimenul animalului ANIMAL2 este: " + ANIMAL2.getSpecimen());
    // vrem sa vedem cate membre are animalul terrestrialAnimal1
    System.out.println("terrestrialAnimal1 are " + terrestrialAnimal1.getMemberNumber() + " membre");
    // vrem sa stim cum se deplaseaza terrestrialAnimal2
    System.out.println("animalul terrestrialAnimal2 " + terrestrialAnimal2.getMove());
    // vrem sa vedem cati pui naste mamiferul 1
    System.out.println("mamiferul mammal1 naste " + mammal1.getMaxBreeding() + " pui");
    // vrem sa vedem daca mamiferul 2 vaneaza
    System.out.println("mamiferul mammal2 vaneaza: " + mammal2.getHunt());
    // vrem sa vedem cum se deplaseaza ierbivorul 1
    System.out.println("ierbivorul 1: " + herbivorousAnimal1.getMove());
    // vrem sa vedem ce specie este ierbivorul 2 si ce culoare are
    System.out.println("ierbivorul 2 este " + herbivorousAnimal2.getSpecimen() + " si are culoarea " + herbivorousAnimal2.getColor());
    // vrem sa vedem ce specie este carnivorul 1 si cate membre are
    System.out.println("carnivorul 1 este " + carnivorousAnimal1.getSpecimen() + " si are " + carnivorousAnimal1.getMemberNumber() + " membre");
    // vrem sa vedem ce culoare are carnivorul 2, cum se deplaseaza si ce specie este
    System.out.println("carnivorul 2 este " + carnivorousAnimal2.getSpecimen() + ", " + carnivorousAnimal2.getMove() + " si este " + carnivorousAnimal2.getSpecimen());
    System.out.println(mammal1.bites());
    System.out.println(terrestrialAnimal1.bites());
    System.out.println(ANIMAL1.bites());







    }
}
