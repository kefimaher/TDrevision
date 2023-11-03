
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private int code;
    private String nom;
    private String prenom;
    private List<Voiture> voituresLouees;

    public Client(int code, String nom, String prenom) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.voituresLouees = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Voiture> getVoituresLouees() {
        return voituresLouees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return getCode() == client.getCode() && Objects.equals(getNom(), client.getNom()) && Objects.equals(getPrenom(), client.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getNom(), getPrenom());
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", voituresLouees=" + voituresLouees +
                '}';
    }
}

