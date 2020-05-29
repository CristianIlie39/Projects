public class Masina implements Leasing, Comparable<Masina> {

    private String marca;
    private String model;
    private String culoare;
    private int pret;
    private String combustibil;
    private int anFabricatie;
    private boolean sold = false;

    public Masina(String marca, String model, String culoare, int pret, String combustibil, int anFabricatie) {
        this.marca = marca;
        this.model = model;
        this.culoare = culoare;
        this.pret = pret;
        this.combustibil = combustibil;
        this.anFabricatie = anFabricatie;
    }

    public Masina() {

    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getCuloare() {
        return culoare;
    }

    public int getPret() {
        return pret;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    @Override
    public int compareTo(Masina o) {
        if (this.anFabricatie < getAnFabricatie()) {
            return -1;
        } else if (this.anFabricatie > getAnFabricatie()) {
            return 1;
        }
        return 0;
    }

    public int numberOfPays() {
        return 24;
    }

    @Override
    public int advancePayment() {
        return this.pret * 25 / 100 ;
    }

    public int payRate() {
        return (this.pret - advancePayment())  / numberOfPays();
    }

    public boolean getSold() {
        if ((this.marca.equals("Audi") || this.marca.equals("BMW") || this.marca.equals("Mercedes") || this.marca.equals("Volkswagen")) && this.culoare.equals("negru") && this.combustibil.equals("benzina")) {
            return sold = true;
        } else {
            return sold = false;
        }
    }


}
