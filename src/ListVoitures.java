import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ListVoitures {
    private List<Voiture> voitures;
    public ListVoitures(List<Voiture> voitures)
    {
        this.voitures = voitures;
    }
    public ListVoitures() {
//à compléter
    }
    public List<Voiture> getVoitures()
    {
        return voitures;
    }
    public void setVoitures(List<Voiture> voitures)
    {
    this.voitures = voitures;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (!voitures.contains(v)) {
            voitures.add(v);
        } else {
            throw new VoitureException("La voiture existe déjà dans la liste et merci");
        }
    }
    public void
    supprimeVoiture(Voiture v) throws
            VoitureException{
        if (!voitures.contains(v)) {
            voitures.remove(v);
        } else {
            throw new VoitureException("La voiture  n'existe pas  déjà dans la liste est merci ");
        }

    }
    public Iterator<Voiture>
    iterateur(){ return voitures.iterator();
    }
    public int size(){
        return voitures.size();
    }
    public void affiche(){
// à completer

    }
}
