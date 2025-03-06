public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        Persona myPersona = new Pirata("Gold Roger");

        myPersona.saluta();
    }
}

class Persona {
    protected String nome;

    Persona(String nome) {
        this.nome = nome;
    }

    public void saluta() {
        System.out.println("Ciao Mondo, da classe persona");
    }
}

class Pirata extends Persona {

    Pirata(String nome) {
        super(nome);
    }

    public void saluta() {
        System.out.println("Ciao Mondo");
    }
}