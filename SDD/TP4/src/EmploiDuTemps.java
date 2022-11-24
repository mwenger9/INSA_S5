import java.security.KeyException;
import java.util.*;

public class EmploiDuTemps {

    private Map<Enseignant,Map<Horaire,String>> tableCours;

    public EmploiDuTemps(Collection<Enseignant> listeEnseignants){
        this.tableCours = new HashMap<>();

        for (Enseignant e : listeEnseignants) {
            tableCours.put(e,new HashMap<>());
        }

    }

    public void ajouterCours(Enseignant e, Horaire h,String matiere) throws Exception{
        if(e == null){ // Check is Enseignant is not null, else throw exception
            throw new Exception("valeur null passée en paramère");
        }
        if(!this.tableCours.containsKey(e)){ // Check if the key of that Enseignant is in the Map, else throw exception
            throw new KeyException("L'enseignant n'est pas renseigné dans la base");
        }
        if(this.tableCours.get(e).containsKey(h)){ // Check if the Enseignant is available at the specified day/time
            throw new Exception("L'enseignant est indisponible a cet horaire");
        }

        this.tableCours.get(e).put(h,matiere);
    }

    public Map<Horaire, String> getEmploiDuTemps(Enseignant e ) throws Exception{
        if(e == null){ // Check is Enseignant is not null, else throw exception
            throw new Exception("valeur null passée en paramère");
        }
        if(!this.tableCours.containsKey(e)){ // Check if the key of that Enseignant is in the Map, else throw exception
            throw new KeyException("L'enseignant n'est pas renseigné dans la base");
        }

        return this.tableCours.get(e);

    }

    public int nbreCoursLundi10H(){
        int res = 0; // Initialize the variable that will store the result
        for (Map<Horaire,String> edt : this.tableCours.values()) { // Iterate over the list of values : Map<Horaire,String>
            for ( Horaire h : edt.keySet()) { // Iterate over the keys of those values (Horaire) to get day and time
                if(h.getJour().toLowerCase() == "lundi" || h.getHeure() == 10){  // Check if day is monday and time is 10
                    res ++;
                }
            }
        }

        return res;
    }

    public int nbreCoursLundi(){
        int res = 0; // Initialize the variable that will store the result
        for (Map<Horaire,String> edt : this.tableCours.values()) { // Iterate over the list of values of the main Map
            //Type of those values : Map<Horaire,String>
            for ( Horaire h : edt.keySet()) { // Iterate over the keys of those values (Horaire) to get day and time
                if(h.getJour().toLowerCase() == "lundi" || h.getHeure() == 10){  // Check if day is monday
                    res ++;
                }
            }
        }
        return res;

    }

    public Enseignant enseignantPlusMatinal() throws Exception{
        if(this.tableCours.isEmpty()){ // Check if there is at least one Enseignant in map
            throw new Exception("La base est vide");
        }
        int maxi = -1; // To compare the amount of morning classes and get the max
        Enseignant maxiEnseignant = null; // To store the Enseignant that has the most morning classes

        for(Enseignant e : this.tableCours.keySet()){ // Loop over the keys (Enseignant)
            int nbreCoursMatinTmp = 0; // Temporary variable to store the amount of morning classes of that current Enseignant
            for(Horaire h : this.getEmploiDuTemps(e).keySet()){ // Iterate over the Horaires associated to that Enseignant
                if(h.getHeure() < 12){ // Check if the current class takes place in the morning
                    nbreCoursMatinTmp ++;
                }
            }

            if (nbreCoursMatinTmp > maxi){ // If that Enseignant has more morning class, we set our max to that new Enseignant
                // If they share the same amount, we keep the first one
                maxi = nbreCoursMatinTmp;
                maxiEnseignant = e;
            }
        }

        return maxiEnseignant;
    }

    public Enseignant enseignantChampion() throws Exception{
        if(this.tableCours.isEmpty()){ // Check if there is at least one Enseignant in map
            throw new Exception("La base est vide");
        }
        int maxi = -1; // To compare the amount of morning classes and get the max
        Enseignant maxiEnseignant = null; // To store the Enseignant that has the most morning classes

        for(Enseignant e : this.tableCours.keySet()){ // Loop over the keys (Enseignant){
            Set<String> tmpClassSet = new HashSet<String>(); // We create a set to store all the uniques types of class
            for(String matiere : this.getEmploiDuTemps(e).values()){ // Iterate over the types of class associated to that Enseignant
                tmpClassSet.add(matiere);
            }

            if ( tmpClassSet.size() > maxi){ // If that Enseignant has types of class, we set our max to that new Enseignant
                // If they share the same amount, we keep the first one
                maxi = tmpClassSet.size();
                maxiEnseignant = e;
            }
        }

        return maxiEnseignant;

    }

    public Map<Horaire,Map<Enseignant,String>> aucuneStructuration() throws Exception {
        Map <Horaire,Map<Enseignant,String>> res = new HashMap<Horaire,Map<Enseignant,String>>();

        for (Enseignant e : this.tableCours.keySet()){
            for(Horaire h : this.getEmploiDuTemps(e).keySet()){
                res.putIfAbsent(h,new HashMap<Enseignant,String>());
                res.get(h).put(e,this.tableCours.get(e).get(h));
            }
        }
        return res;
    }

    public int nbSallesNecessaires() throws Exception {
        int maxi = 0;
        Map <Horaire,Map<Enseignant,String>> aucuneStruct = this.aucuneStructuration();
        for(Horaire h : aucuneStruct.keySet()){
            int tmpSize = aucuneStruct.get(h).keySet().size();
            if(tmpSize > maxi){
                maxi = tmpSize;
            }
        }
        return maxi;
    }


}
