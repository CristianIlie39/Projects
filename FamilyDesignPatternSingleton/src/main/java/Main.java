public class Main {

    //Sa se exemplifice folosirea design pattern-ului Singleton intr-un program care modeleaza o familie

    public static void main(String[] args) {

        Family family = Family.getInstance();
        Person dad = Dad.getInstance();
        Person mom = Mom.getInstance();
        Son son1 = new Son("Popescu", "Marius", 17);
        Son son2 = new Son("Popescu", "Adrian", 10);
        Daughter daughter = new Daughter("Popescu", "Veronica", 14);

        family.getFamilyMembers().add(dad);
        family.getFamilyMembers().add(mom);
        family.getFamilyMembers().add(son1);
        family.getFamilyMembers().add(daughter);
        family.getFamilyMembers().add(son2);

        System.out.println("We display family members");
        for (Person person : family.getFamilyMembers()) {
            System.out.println(person.toString());
        }
    }
}
