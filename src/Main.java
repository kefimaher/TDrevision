import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        try {
            // Création d'une agence
            Agence agence = new Agence("MaAgence");
            // Ajout de quelques voitures à l'agence
            agence.ajoutVoiture(new Voiture(1, "Toyota", 50.0f));
            agence.ajoutVoiture(new Voiture(2, "Honda", 45.0f));
            agence.ajoutVoiture(new Voiture(3, "Ford", 55.0f));

            // Création de clients
            Client client1 = new Client(101, "Dupont", "Jean");
            Client client2 = new Client(102, "Durand", "Marie");

            // Location de voitures par les clients
            agence.loueClientVoiture(client1, agence.selectVoitureSelonCritere(new CritereMarque("Toyota")).get(0));
            agence.loueClientVoiture(client2, agence.selectVoitureSelonCritere(new CriterePrix(50.0f)).get(0));

            // Affichage des clients et de leurs voitures louées
            agence.afficheLesClientsEtLeursListesVoitures();

            // Retour de voiture par les clients
            agence.retourClientVoiture(client1, client1.getVoituresLouees().get(0));

            // Affichage mis à jour des clients et de leurs voitures louées
            agence.afficheLesClientsEtLeursListesVoitures();

            // Tri des clients par code croissant
            Map<Client, ListVoitures> clientsTriesParCode = agence.triCodeCroissant();
            System.out.println("Clients triés par code croissant :");
            for (Map.Entry<Client, ListVoitures> entry : clientsTriesParCode.entrySet()) {
                System.out.println("Client: " + entry.getKey() + ", Voitures louées: " + entry.getValue());
            }

            // Tri des clients par nom croissant
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
