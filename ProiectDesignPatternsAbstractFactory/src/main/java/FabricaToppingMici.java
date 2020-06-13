public class FabricaToppingMici extends FabricaTopping {

    @Override
    public Sos produceSos() {
        return new SosMustar();
    }

    @Override
    public Branza produceBranza() {
        return new BranzaCapra();
    }

}
