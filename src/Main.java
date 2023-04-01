import java.util.List;

public class Main {
    public static void main(String[] args) {

        Noeud n = new Noeud();
        String[][] T = new String[3][3];
        for (int i = 0 ; i < 3; i++)
            for (int j = 0 ; j < 3; j++)
                T[i][j] = "";
        T[0][0] = "X";
        n.setEtat(T);
        int i = 0;
        while(i < 5){
            n.setEtat(MINIMAX(n));
            i++;
        }
    }
    static String[][] MINIMAX(Noeud noeud){

        Noeud MeilleurCoup = new Noeud();

        int maxi = (int)Double.NEGATIVE_INFINITY;
        List<Noeud> fils = noeud.successeur("O");
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