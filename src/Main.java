import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Noeud n = new Noeud();
        Scanner input = new Scanner(System.in);
        int i;
        int j;

        while (!n.TestTerminaison()){
            n.Afficher();
            System.out.print("i : ");
            i = input.nextInt();
            System.out.println();
            System.out.print("j : ");
            j = input.nextInt();
            System.out.println();
            n.setO(i,j);
            n.setEtat(MINIMAX(n));
        }
    }
    static String[][] MINIMAX(Noeud noeud){

        Noeud MeilleurCoup = new Noeud();

        int maxi = (int)Double.NEGATIVE_INFINITY;
        List<Noeud> fils = noeud.successeur("X");
        for (Noeud f: fils) {
            int valeur_fils = ValeurMINI(f);
            if(valeur_fils > maxi){
                maxi = valeur_fils;
                MeilleurCoup.setEtat(f.getT());
            }
        }
        return MeilleurCoup.getT();
    }
    static int ValeurMINI(Noeud noeud){
        int utilite = noeud.utilite();
        if(utilite != -2) return utilite;

        List<Noeud> fils = noeud.successeur("O");

        int v_min = (int)Double.POSITIVE_INFINITY;
        for (Noeud f: fils) {
            int valeur_fils = ValeurMAX(f);
            v_min = Integer.min(v_min,valeur_fils);
        }
        return v_min;
    }

    static int ValeurMAX(Noeud noeud){
        int utilite = noeud.utilite();
        if(utilite != -2) return utilite;

        List<Noeud> fils = noeud.successeur("X");

        int v_max = (int)Double.NEGATIVE_INFINITY;
        for (Noeud f: fils) {
            int valeur_fils = ValeurMINI(f);
            v_max = Integer.max(v_max,valeur_fils);
        }
        return v_max;
    }
}