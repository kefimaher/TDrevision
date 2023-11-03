import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        try {
            List<Voiture> listeVoitures = new ArrayList<>();
            agence.ajoutVoiture(new Voiture(1, "BMW", 150));
            agence.ajoutVoiture(new Voiture(2, "Renault", 120));
            agence.ajoutVoiture(new Voiture(3, "Ford", 100));
            Agence agence = new Agence("MaAgence", new ListVoitures(listeVoitures));
            Client client1 = new Client(101, "Kefi", "Maher");
            Client client2 = new Client(102, "Siwar", "Zwita");
            agence.loueClientVoiture(client1, agence.selectVoitureSelonCritere(new CritereMarque("BMW")).get(0));
            agence.loueClientVoiture(client2, agence.selectVoitureSelonCritere(new CriterePrix(150)).get(0));
            agence.afficheLesClientsEtLeursListesVoitures();
            agence.retourClientVoiture(client1, client1.getVoituresLouees().get(0));
            agence.afficheLesClientsEtLeursListesVoitures();
            Map<Client, ListVoitures> clientsTriesParCode = agence.triCodeCroissant();


            System.out.println("Clients triés par code croissant :");
            for (Map.Entry<Client, ListVoitures> entry : clientsTriesParCode.entrySet()) {
                System.out.println("Client: " + entry.getKey() + ", Voitures louées: " + entry.getValue());
            }

            Map<Client, ListVoitures> clientsTriesParNom = agence.triNomCroissant();
            System.out.println("Clients triés par nom croissant :");
            for (Map.Entry<Client, ListVoitures> entry : clientsTriesParNom.entrySet()) {
                System.out.println("Client: " + entry.getKey() + ", Voitures louées: " + entry.getValue());
            }

        } catch (VoitureException e) {
            e.printStackTrace();
        }
    }
}
