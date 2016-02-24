package livre;

/**
 * Created by xfnix on 24/02/2016.
 */
public class Livre {
    String nom;
    String auteur;
    String date_parution;
    String numero_etu;
    String date_retour;

    public Livre() {
    }

    public String getNom() {
        return nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getDate_parution() {
        return date_parution;
    }

    public String getNumero_etu() {
        return numero_etu;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDate_parution(String date_parution) {
        this.date_parution = date_parution;
    }

    public void setNumero_etu(String numero_etu) {
        this.numero_etu = numero_etu;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    @Override
    public String toString() {
        return nom + " de " +
                ", auteur='" + auteur + '\'' +
                ", date_parution='" + date_parution + '\'' +
                ", numero_etu='" + numero_etu + '\'' +
                ", date_retour='" + date_retour + '\'' +
                '}';
    }
}
