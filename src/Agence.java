import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
    }

    public Agence(String nom, ListVoitures vs, Map<Client, ListVoitures> clientVoitureLoue) {
        this.nom = nom;
        this.vs = vs;
        ClientVoitureLoue = clientVoitureLoue;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }
    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
        // Supprimer la voiture de la liste des voitures louées par les clients
        for (ListVoitures listVoitures : ClientVoitureLoue.values()) {
            listVoitures.supprimeVoiture(v);
        }
    }
    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (!ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.put(cl, new ListVoitures());
        }
        ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
        clientVoitures.ajoutVoiture(v);
    }
    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (ClientVoitureLoue.containsKey(cl)) {
            ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
            clientVoitures.supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSatisfaisantes = new ArrayList<>();
        for (Voiture voiture : vs.getVoitures()) {
            if (c.estSatisfaitPar(voiture)) {
                voituresSatisfaisantes.add(voiture);
            }
        }
        return voituresSatisfaisantes;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return ClientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return ClientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : ClientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey());
            System.out.println("Voitures loues: ");
            entry.getValue().affiche();
            System.out.println("_____");
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        TreeMap<Client, ListVoitures> trieeParCode = new TreeMap<>(Comparator.comparingInt(Client::getCode));
        trieeParCode.putAll(ClientVoitureLoue);
        return trieeParCode;
    }
    public Map<Client, ListVoitures> triNomCroissant() {
        TreeMap<Client, ListVoitures> trieeParNom = new TreeMap<>(Comparator.comparing(Client::getNom));
        trieeParNom.putAll(ClientVoitureLoue);
        return trieeParNom;
    }
}
