import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;
    public Agence(String nom)
{
//à completer
}
    public void ajoutVoiture(Voiture v) throws VoitureException{
        vs.ajoutVoiture(v);
    }
    public void suppVoiture(Voiture v)throws VoitureException{
        vs.supprimeVoiture(v);
        // Supprimer la voiture de la liste des voitures louées par les clients
        for (ListVoitures listVoitures : ClientVoitureLoue.values()) {
            listVoitures.supprimeVoiture(v);
        }
    }
    public void loueClientVoiture(Client cl, Voiture v)throws VoitureException
    {
        if (!ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.put(cl, new ListVoitures());
        }
        ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
        clientVoitures.ajoutVoiture(v);
    }
    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException
    {
        if (ClientVoitureLoue.containsKey(cl)) {
            ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
            clientVoitures.supprimeVoiture(v);
        }
    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> voituresSatisfaisantes = new ArrayList<>();
        for (Voiture voiture : vs.getVoitures()) {
            if (c.estSatisfaitPar(voiture)) {
                voituresSatisfaisantes.add(voiture);
            }
        }
        return voituresSatisfaisantes;
    }
    public Set<Client> ensembleClientsLoueurs(){
        return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures> collectionVoituresLouees()
    {
        return ClientVoitureLoue.values();
    }
    public void
    afficheLesClientsEtLeursListesVoitures(){
//à compléter
    }
    public Map<Client, ListVoitures>
    triCodeCroissant(){

        6

// à completer
    }
    public Map<Client, ListVoitures>
    triNomCroissant(){
// à completer
    }
}
