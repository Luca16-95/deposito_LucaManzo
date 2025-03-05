import java.util.ArrayList;
import java.util.Scanner;

//#region Classe biblioteca
public class Biblioteca {
    private ArrayList<Libro> libri;

    public Biblioteca() {
        this.libri = new ArrayList<Libro>();
    }

    // agg libro
    public void addLibro(Libro libro) {
        libri.add(libro);
        System.out.println("Hai aggiunto " + libro + " nella biblioteca.");
    }

    // metodo getLibri
    public void getLibri() {
        System.out.println("");
        if (libri.isEmpty()) {
            System.out.println("Non hai aggiunto nessun libro.");
        } else {
            for (Libro libro : libri) {
                System.out.println("- " + libro);
            }
        }
    }

    // rimozione di un libro.
    public void removeLibro(Libro libro) {
        libri.remove(libro);
        System.out.println("libro rimosso correttamente.");

    }

    public Libro trovaLibro(String titolo) {
        for (Libro libro : libri) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                return libro;
            }
        }
        return null; // Se il libro non è trovato
    }

    public void prestaLibro(String titolo) {
        Libro libro = trovaLibro(titolo);
        if (libro != null) {
            libro.prestaLibro();
        } else {
            System.out.println("Il libro " + titolo + " non è presente in biblioteca.");
        }
    }

    public void restituisciLibro(String titolo) {
        Libro libro = trovaLibro(titolo);
        if (libro != null) {
            libro.restituisciLibro();
        } else {
            System.out.println("Il libro " + titolo + " non è presente in biblioteca.");
        }
    }
}
// #endregion

// #region Classe libro.
class Libro {
    private String titolo;
    private int annoUscita;
    private int copieDisponibili;
    private int copieInPrestito;
    GenereLibro genere;

    Libro() {
    };

    Libro(String titolo, GenereLibro genere, int annoUscita, int copieDisponibili) {
        this.titolo = titolo;
        this.genere = genere;
        this.annoUscita = annoUscita;
        this.copieDisponibili = copieDisponibili;
        this.copieInPrestito = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public int getCopieInPrestito() {
        return copieInPrestito;
    }

    public GenereLibro getGenere() {
        return genere; // Restituisce il genere del libro
    }

    public void setGenere(GenereLibro genere) {
        this.genere = genere;
    }

    public void prestaLibro() {
        if (copieDisponibili > 0) {
            copieDisponibili--;
            copieInPrestito++;
        } else {
            System.out.println("Non ci sono copie disponibili per il libro: " + titolo);
        }
    }

    public void restituisciLibro() {
        if (copieInPrestito > 0) {
            copieDisponibili++;
            copieInPrestito--;
        } else {
            System.out.println("Non hai preso in prestito questo libro: " + titolo);
        }
    }

    public void aggiungiCopie(int numeroCopie) {
        copieDisponibili += numeroCopie;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + ", " + genere + ", annoUscita: " + annoUscita
                + ", copie Disponibili: " + copieDisponibili + ", copie in prestito: " + copieInPrestito;
    }

}
// #endregion

class GenereLibro extends Libro {
    protected String nomeGenere;

    public GenereLibro(String nomeGenere) {
        this.nomeGenere = nomeGenere;
    }

    public String getNomeGenere() {
        return nomeGenere;
    }

    @Override
    public String toString() {
        return "GenereLibro: " + nomeGenere;
    }

}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro();
        System.out.println("++++Benvenuto+++++");
        boolean uscita = true;
        while (uscita) {
            System.out.println("che operazione vuoi fare?");
            System.out.println("Premi 1 per inserire un libro");
            System.out.println("premi 2 per vedere la lista dei libri");
            System.out.println("premi 3 pre eliminare un libro.");
            System.out.println("premi 4 per prestare un libro.");
            System.out.println("premi 5 per restituire un libro.");
            System.out.println("premi 6 per uscire.");

            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    scanner.nextLine();
                    System.out.print("insersci il titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("inserisci il genere: ");
                    String genereScelto = scanner.nextLine();
                    GenereLibro genere = new GenereLibro(genereScelto);
                    System.out.print("insersci l'anno: ");
                    int annoUscita = scanner.nextInt();
                    System.out.print("quante copie stai inserendo: ");
                    int copieDisponibili = scanner.nextInt();

                    libro = new Libro(titolo, genere, annoUscita, copieDisponibili);

                    biblioteca.addLibro(libro);
                    break;
                case 2:
                    System.out
                            .println("Questa è la lista di tutti i libri presenti in questa fornitissima biblioteca.");
                    biblioteca.getLibri();
                    break;
                case 3:
                    System.out.print("Dimmi il titolo del libro che vuoi eliminare: ");
                    String titolo1 = scanner.nextLine();
                    libro = biblioteca.trovaLibro(titolo1);
                    biblioteca.removeLibro(libro);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Dimmi il titolo che vuoi prestare.");
                    String titolo2 = scanner.nextLine();
                    biblioteca.prestaLibro(titolo2);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Dimmi il titolo del libro che vuoi restituire");
                    String titolo3 = scanner.nextLine();
                    biblioteca.restituisciLibro(titolo3);
                    break;
                case 6:
                    System.out.println("BUONAGIORNATA...");
                    uscita = false;
                    break;

                default:
                    break;
            }

        }
        scanner.close();
    }
}