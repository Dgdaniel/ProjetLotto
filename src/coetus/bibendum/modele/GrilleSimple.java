
package coetus.bibendum.modele;

/**
 *
 * @author Daniel
 */
public class  GrilleSimple{
            String montantMise;
            String jeu ;
            String resultatjeu ;
            String ticket ;
            String datejeu;

    public GrilleSimple(String montantMise, String jeu, String resultatjeu, String ticket, String datejeu) {
        this.montantMise = montantMise;
        this.jeu = jeu;
        this.resultatjeu = resultatjeu;
        this.ticket = ticket;
        this.datejeu = datejeu;
    }

    public String getMontantMise() {
        return montantMise;
    }

    public void setMontantMise(String montantMise) {
        this.montantMise = montantMise;
    }

    public String getJeu() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu = jeu;
    }

    public String getResultatjeu() {
        return resultatjeu;
    }

    public void setResultatjeu(String resultatjeu) {
        this.resultatjeu = resultatjeu;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDatejeu() {
        return datejeu;
    }

    public void setDatejeu(String datejeu) {
        this.datejeu = datejeu;
    }

    @Override
    public String toString() {
        return "GrilleSimple{" + "montantMise=" + montantMise + ", jeu=" + jeu + ", resultatjeu=" + resultatjeu + ", ticket=" + ticket + ", datejeu=" + datejeu + '}';
    }
   
}
