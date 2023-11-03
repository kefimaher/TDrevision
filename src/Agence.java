public class Agence {
    private String nom; private ListVoitures
        vs; private Map<Client, ListVoitures>
        ClientVoitureLoue; public Agence(String nom)
{
//à completer
}
    public void ajoutVoiture(Voiture v)
            throws VoitureException{
// à completer
    }
    public void suppVoiture(Voiture
                                    v)throws VoitureException{
//à completer
    }
    public void loueClientVoiture(Client cl,
                                  Voiture
                                          v)throws
            VoitureException{
// à completer
    }
    public void retourClientVoiture(Client
                                            cl , Voiture v) throws
            VoitureException{
// à completer
    }
    public List<Voiture>
    selectVoitureSelonCritere(Critere c){
//à completer
    }
    public Set<Client>
    ensembleClientsLoueurs(){
// à completer
    }
    public Collection<ListVoitures>
    collectionVoituresLouees(){
// à completer
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
