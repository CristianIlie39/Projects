public class FabricaToppingPizza extends FabricaTopping {

    @Override
    public Sos produceSos() {
        return new SosTomat();
    }

    @Override
    public Branza produceBranza() {
        return new Mozzarella();
    }

}
