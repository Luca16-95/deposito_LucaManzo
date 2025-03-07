import java.util.ArrayList;
import java.util.Scanner;

public class intefacce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        GestioneProdotti<IProdotto> gestioneProdotti = new GestioneProdotti<>();

        while (continua) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Aggiungi Prodotto Elettronico");
            System.out.println("2. Aggiungi Prodotto Abbigliamento");
            System.out.println("3. Aggiungi Prodotto Alimentare");
            System.out.println("4. per eliminare un prodotto.");
            System.out.println("5. per visualizzare tutti i prodotti.");
            System.out.println("6 per uscire.");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    // Aggiungi Prodotto Elettronico
                    System.out.print("Inserisci codice: ");
                    String codiceElettronico = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nomeElettronico = scanner.nextLine();
                    System.out.print("Inserisci prezzo: ");
                    double prezzoElettronico = scanner.nextDouble();
                    System.out.print("Inserisci durata garanzia (mesi): ");
                    int durataGaranzia = scanner.nextInt();
                    System.out.print("Inserisci mesi dall'acquisto: ");
                    int mesiAcquisto = scanner.nextInt();
                    scanner.nextLine();

                    ProdottoElettronico prodottoElettronico = new ProdottoElettronico(codiceElettronico,
                            nomeElettronico, prezzoElettronico, durataGaranzia, mesiAcquisto);
                    gestioneProdotti.aggiungiProdotto(prodottoElettronico);
                    System.out.println(prodottoElettronico.getDettagli());
                    System.out.println("Garanzia valida: " + prodottoElettronico.verificaGaranzia());
                    break;

                case 2:
                    // Aggiungi Prodotto Abbigliamento
                    System.out.print("Inserisci codice: ");
                    String codiceAbbigliamento = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nomeAbbigliamento = scanner.nextLine();
                    System.out.print("Inserisci prezzo: ");
                    double prezzoAbbigliamento = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Inserisci taglia: ");
                    String taglia = scanner.nextLine();
                    System.out.print("Inserisci materiale: ");
                    String materiale = scanner.nextLine();
                    System.out.print("Inserisci giorni dall'acquisto: ");
                    int giorniDallAcquisto = scanner.nextInt();
                    scanner.nextLine();

                    ProdottoAbbigliamento prodottoAbbigliamento = new ProdottoAbbigliamento(codiceAbbigliamento,
                            nomeAbbigliamento, prezzoAbbigliamento, taglia, materiale, giorniDallAcquisto);
                    gestioneProdotti.aggiungiProdotto(prodottoAbbigliamento);
                    System.out.println(prodottoAbbigliamento.getDettagli());
                    System.out.println("Restituzione possibile: " + prodottoAbbigliamento.verificaRestituzione());
                    break;

                case 3:
                    // Aggiungi Prodotto Alimentare
                    System.out.print("Inserisci codice: ");
                    String codiceAlimentare = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nomeAlimentare = scanner.nextLine();
                    System.out.print("Inserisci prezzo: ");
                    double prezzoAlimentare = scanner.nextDouble();
                    System.out.print("Inserisci giorni alla scadenza: ");
                    int giorniAllaScadenza = scanner.nextInt();
                    scanner.nextLine();

                    ProdottoAlimentare prodottoAlimentare = new ProdottoAlimentare(codiceAlimentare, nomeAlimentare,
                            prezzoAlimentare, giorniAllaScadenza);
                    gestioneProdotti.aggiungiProdotto(prodottoAlimentare);
                    System.out.println(prodottoAlimentare.getDettagli());
                    System.out.println("Sconto applicato: " + prodottoAlimentare.calcolaSconto());
                    break;
                case 4:
                    System.out.println("Quale prodotto vuoi eliminare?: ");
                    String prodottoDaEliminare = scanner.nextLine();
                    gestioneProdotti.removeProdotto(prodottoDaEliminare);
                case 5:
                    System.out.println("\nEcco la lista di tutti i prodotti");
                    gestioneProdotti.mostraDettagli();
                    break;
                case 6:
                    // Esci
                    System.out.println("Grazie, Arrivederci.");
                    continua = false;
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }

        scanner.close();
    }
}

interface IProdotto {
    double getPrezzo();

    public String getCodice();

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

    public String getCodice() {
        return codice;
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

    public String getCodice() {
        return codice;
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

    public String getCodice() {
        return codice;
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

class GestioneProdotti<T> {
    private ArrayList<T> prodotti;

    public GestioneProdotti() {
        prodotti = new ArrayList<>();
    }

    // Metodo per aggiungere un prodotto all'ArrayList
    public void aggiungiProdotto(T prodotto) {
        prodotti.add(prodotto);
    }

    // Metodo per mostrare i dettagli di tutti i prodotti
    public void mostraDettagli() {
        for (T prodotto : prodotti) {
            System.out.println(prodotto.toString());
        }
    }

    public void removeProdotto(String codice) {
        for (T prodotto : prodotti) {
            if (((IProdotto) prodotto).getCodice().equals(codice)) {
                prodotti.remove(prodotto);
                System.out.println("Prodotto eliminato correttamente.");
            }
        }
        System.out.println("Prodotto rimosso correttamente.");
    }
}
