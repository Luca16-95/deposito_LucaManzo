import java.util.Scanner;

public class intefacce {
    public static void main(String[] args) {

    }
}

interface IProdotto {
    double getPrezzo();

    String getDettagli();
}

interface IScontabile {
    double calcolaSconto();
}

interface IGarantibile {
    boolean verificaGaranzia();
}

interface IRestituibile {
    boolean verificaRestituzione();
}

class ProdottoElettronico implements IProdotto, IGarantibile {
    private String codice;
    private String nome;
    private double prezzo;
    private int durataGaranziaMesi;
    private int mesiAcquisto;

    public ProdottoElettronico(String codice, String nome, double prezzo, int durataGaranziaMesi, int mesiAcquisto) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.durataGaranziaMesi = durataGaranziaMesi;
        this.mesiAcquisto = mesiAcquisto;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String getDettagli() {
        return "Prodotto Elettronico: " + nome + ", Codice: " + codice + ", Prezzo: " + prezzo + ", Garanzia: "
                + durataGaranziaMesi + " mesi";
    }

    @Override
    public boolean verificaGaranzia() {
        return mesiAcquisto <= durataGaranziaMesi;
    }
}

class ProdottoAbbigliamento implements IProdotto, IRestituibile {
    private String codice;
    private String nome;
    private double prezzo;
    private String taglia;
    private String materiale;
    private int giorniDallAcquisto;

    public ProdottoAbbigliamento(String codice, String nome, double prezzo, String taglia, String materiale,
            int giorniDallAcquisto) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.taglia = taglia;
        this.materiale = materiale;
        this.giorniDallAcquisto = giorniDallAcquisto;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String getDettagli() {
        return "Prodotto Abbigliamento: " + nome + ", Codice: " + codice + ", Prezzo: " + prezzo + ", Taglia: " + taglia
                + ", Materiale: " + materiale;
    }

    @Override
    public boolean verificaRestituzione() {
        return giorniDallAcquisto <= 30;
    }
}

class ProdottoAlimentare implements IProdotto, IScontabile {
    private String codice;
    private String nome;
    private double prezzo;
    private int giorniAllaScadenza;

    public ProdottoAlimentare(String codice, String nome, double prezzo, int giorniAllaScadenza) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.giorniAllaScadenza = giorniAllaScadenza;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String getDettagli() {
        return "Prodotto Alimentare: " + nome + ", Codice: " + codice + ", Prezzo: " + prezzo
                + ", Giorni alla scadenza: " + giorniAllaScadenza;
    }

    @Override
    public double calcolaSconto() {
        if (giorniAllaScadenza <= 3) {
            return prezzo * 0.2;
        }
        return 0;
    }
}
