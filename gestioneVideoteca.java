import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class gestioneVideoteca {
    // inizializzo scanner.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // variabile per il controllo uscita dal while.
        boolean exit = true;

        // Creo un'istanza di Videoteca
        Videoteca videoteca = null;
        try {
            videoteca = new Videoteca(); // Inizializzazione della Videoteca
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Impossibile connettersi al database.");
            return; // Se c'è un errore nella connessione al database, fermo l'applicazione
        }

        while (exit) {
            System.out.println("+++++++ BENVENUTO! ++++++++++");
            System.out.println(".che operazione vuoi fare?");
            System.out.println("premi 1 per aggiungere un utente: ");
            System.out.println("premi 2 per aggiungere un film: ");
            System.out.println("premi 3 per rimuovere un film: ");
            System.out.println("premi 4 per vedere i film disponibili: ");
            System.out.println("premi 5 per noleggiare un film tra i disponibili: ");
            System.out.println("premi 6 per uscire.");
            // variabile per la scelta del nello switch.
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    scanner.nextLine();
                    System.out.println("hai scelto di aggiungere un utente.");
                    System.out.print("inserisci il tuo id: ");
                    String userId = scanner.nextLine();
                    System.out.print("adesso inserisci il tuo nome: ");
                    String userName = scanner.nextLine();
                    Utente nuovoUtente = new Utente(userId, userName);
                    try {
                        videoteca.addUser(nuovoUtente); // Aggiungi l'utente alla videoteca
                        System.out.println("Utente correttamente aggiunto");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    scanner.nextLine();// pulisco lo scanner
                    System.out.println("Hai deciso di aggiungere un film\nDimmi il titolo");
                    String filmAggiunto = scanner.nextLine();
                    System.out.println("dimmi l'anno di uscita.");
                    int annoFilm = scanner.nextInt();
                    Film film = new Film(filmAggiunto, annoFilm);
                    try {
                        videoteca.addFilm(film);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    scanner.nextLine();// pulisco lo scanner
                    System.out.println("Hai deciso di rimuovere un film.\ndimmi il titolo che vuoi rimuovere: ");
                    String nomeTitolo = scanner.nextLine();
                    try {
                        videoteca.removeFilm(nomeTitolo);
                        System.out.println("Hai rimosso " + nomeTitolo + " dal database.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Dimmi il titolo del film che stai cercando.");
                    scanner.nextLine();
                    String nomeFilm = scanner.nextLine();

                    // Recupera il film
                    Film film3 = videoteca.getFilm(nomeFilm);

                    // Verifica se il film è presente
                    if (film3 != null) {
                        System.out.println("Il film è disponibile.");
                    } else {
                        System.out.println("Il film non è presente nei nostri archivi.");
                    }
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.println("Hai deciso di noleggiare un film\nDimmi il tuo ID");
                    String UserID = scanner.nextLine(); // Ottieni l'ID dell'utente

                    System.out.println("Dimmi il film che vuoi noleggiare.");
                    String film_title = scanner.nextLine();
                    try {
                        videoteca.rentFilm(UserID, film_title);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Hai deciso di uscire.");
                    exit = false;
                    System.out.println("+++++Buona giornata :).++++++");
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}

// #region classe film.
class Film {
    private String title;
    private int annoUscita;

    public Film(String title, int annoUscita) {
        this.title = title;
        this.annoUscita = annoUscita;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return annoUscita;
    }

    public void setReleaseYear(int annoUscita) {
        this.annoUscita = annoUscita;
    }
}
// #endregion

// #region classe utente
class Utente {
    private String userId;
    private String name;
    private ArrayList<Film> rentedFilms;

    public Utente(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.rentedFilms = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Film> getRentedFilms() {
        return rentedFilms;
    }

    public void rentFilm(Film film) {
        rentedFilms.add(film);
    }

    public void listRentedFilms() {
        System.out.println("Films noleggiati by " + name + ":");
        for (Film film : rentedFilms) {
            System.out.println(film.getTitle() + " (" + film.getReleaseYear() + ")");
        }
    }
}
// #endregion

// #region classe videoteca
class Videoteca {
    // variabile che utilizzo per connettere il db
    private Connection connection;

    // connetto il driver.
    public Videoteca() throws SQLException {
        // Connessione al database
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/videoteca", "User", "Password");
    }

    // metodo per l aggiunta dei film nel db.
    public void addFilm(Film film) throws SQLException {
        String query = "INSERT INTO Films (title, release_year) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, film.getTitle());
            stmt.setInt(2, film.getReleaseYear());
            stmt.executeUpdate();
        }
    }

    // metodo per rimuovere film da db.
    public void removeFilm(String title) throws SQLException {
        // 1. Trova l'ID del film dal titolo
        String TrovaIdQuery = "SELECT id FROM films WHERE title = ?";
        int filmId = -1; // Impostiamo un valore di default, nel caso il film non venga trovato.
        try (PreparedStatement stmt = connection.prepareStatement(TrovaIdQuery)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                filmId = rs.getInt("id");
            }
        }

        if (filmId == -1) {
            System.out.println("Film non trovato!");
            return; // Esci dal metodo se il film non esiste
        }

        // 2. Elimina i noleggi associati al film (usando l'ID)
        String deleteRentalsQuery = "DELETE FROM rentals WHERE film_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteRentalsQuery)) {
            stmt.setInt(1, filmId);
            stmt.executeUpdate();
        }

        // 3. Elimina il film dalla tabella films (usando l'ID)
        String deleteFilmQuery = "DELETE FROM films WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteFilmQuery)) {
            stmt.setInt(1, filmId);
            stmt.executeUpdate();
        }

        System.out.println("Film rimosso con successo.\n\n");
    }

    // metodo per rimuovere dal db.
    public Film getFilm(String title) throws SQLException {
        String query = "SELECT * FROM Films WHERE title =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Film(rs.getString("title"), rs.getInt("release_year"));
            }
        }
        return null;
    }

    // metodo per l aggiunta degli user.
    public void addUser(Utente utente) throws SQLException {
        String query = "INSERT INTO Users (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, utente.getUserId());
            stmt.setString(2, utente.getName());
            stmt.executeUpdate();
        }
    }

    public void rentFilm(String userID, String film_title) throws SQLException {
        String TrovaIdQuery = "SELECT id FROM films WHERE title = ?";
        int filmId = -1; // Impostiamo un valore di default, nel caso il film non venga trovato.
        try (PreparedStatement stmt = connection.prepareStatement(TrovaIdQuery)) {
            stmt.setString(1, film_title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                filmId = rs.getInt("id");
            }
        }

        String query = "INSERT INTO Rentals (user_id, film_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userID); // Imposta l'ID dell'utente
            stmt.setInt(2, filmId); // Imposta l'ID del film

            // Eseguiamo la query per inserire il noleggio
            stmt.executeUpdate();
        }
    }

}
// #endregion