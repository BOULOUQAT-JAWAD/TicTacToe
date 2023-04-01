import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Noeud {

    private String[][] T;

    public Noeud() {
        T = new String[3][3];
        for (int i = 0 ; i < 3; i++)
            for (int j = 0 ; j < 3; j++)
                T[i][j] = "";
    }

    public String[][] getT() {
        return T;
    }
    public Boolean setO(int i, int j){
        if (i < 3 && j < 3 && i >= 0 && j >= 0){
            if(T[i][j] == ""){
                T[i][j]="O";
                return true;
            }
        }
        return false;
    }
    public Noeud setEtat(String[][] tableau){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                T[i][j] = tableau[i][j];
        return this;
    }

    public int TestTerminaison(){
        // diagonal
        if(T[0][0] == T[1][1] && T[1][1] == T[2][2] && T[0][0] != ""){
            System.out.println("winner : "+T[1][1]);
            return 1;
        }
        if(T[0][2] == T[1][1] && T[1][1] == T[2][0] && T[1][1] != ""){
            System.out.println("winner : "+T[1][1]);
            return 1;
        }
        // lignes
        for (int i = 0; i < 3; i++){
            if(T[i][0] == T[i][1] && T[i][1] == T[i][2] && T[i][2] != ""){
                System.out.println("winner : "+T[0][0]);
                return 1;
            }
        }
        // collones
        for (int i = 0; i < 3; i++){
            if(T[0][i] == T[1][i] && T[1][i] == T[2][i] && T[2][i] != ""){
                System.out.println("winner : "+T[0][0]);
                return 1;
            }
        }
        if (Remplie()){
            System.out.println("Egalité");
            return 0;
        }
        return -1;
    }

    public List<Noeud> successeur(String str){
        List<Noeud> fils = new ArrayList<>();

        Noeud n = new Noeud();
        n.setEtat(this.getT());

        for (int k = 0 ; k < 9; k++){
            outerloop:
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    if (n.T[i][j] == ""){
                        n.T[i][j] = str;

                        Noeud child = new Noeud();
                        child.setEtat(this.getT());
                        child.T[i][j] = str;

                        int check = 0;
                        for (Noeud f: fils) {
                            if (stringEqual(f.getT(),child.getT()))
                                check = 1;
                        }
                        Noeud nouveau = new Noeud();
                        nouveau.setEtat(child.getT());
                        if (check == 0) fils.add(nouveau);

                        break outerloop;
                    }
                }
            }
        }
        return fils;
    }
    public boolean Remplie(){
        for (int i = 0 ; i < 3; i++)
            for (int j = 0 ; j < 3; j++)
                if(T[i][j] == "")
                    return false;
        return true;
    }

    public int utilite(){
        // diagonal
        if(T[0][0] == T[1][1] && T[1][1] == T[2][2] && T[0][0] != ""){
            if(T[0][0] == "X") return 1;
            return -1;
        }
        if(T[0][2] == T[1][1] && T[1][1] == T[2][0] && T[1][1] != ""){
            if(T[0][2] == "X") return 1;
            return -1;
        }
        // lignes
        for (int i = 0; i < 3; i++){
            if(T[i][0] == T[i][1] && T[i][1] == T[i][2] && T[i][2] != ""){
                if(T[i][0] == "X") return 1;
                return -1;
            }
        }
        // collones
        for (int i = 0; i < 3; i++){
            if(T[0][i] == T[1][i] && T[1][i] == T[2][i] && T[2][i] != ""){
                if(T[0][i] == "X") return 1;
                return -1;
            }
        }
        if(Remplie()) return 0;
        // feuille
        return -2;
    }

    public void Afficher(){
        for (int i = 0 ; i < 3; i++){
            System.out.println("------------");
            for (int j = 0 ; j < 3; j++) {
                System.out.print("|"+T[i][j]+"|  ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return ""+T[0][0];
    }

    private boolean stringEqual(String[][] array1, String[][] array2){
        boolean equal = true;

        if (array1.length != array2.length) {
            equal = false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (!Arrays.equals(array1[i], array2[i])) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }
}
