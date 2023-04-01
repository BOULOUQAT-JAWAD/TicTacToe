public class Noeud {

    private String[][] T;

    public Noeud() {
        T = new String[3][3];
        for (int i = 0 ; i < 3; i++)
            for (int j = 0 ; j < 3; j++)
                T[i][j] = "";
    }

    public void setX(int i, int j){
        T[i][j] = "X";
    }

    public String[][] getT() {
        return T;
    }

    public void setEtat(String[][] tableau){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                T[i][j] = tableau[i][j];
    }

    public boolean TestTerminaison(){
        // diagonal
        if(T[0][0] == T[1][1] && T[1][1] == T[2][2] && T[0][0] != ""){
            System.out.println("winner : "+T[1][1]);
            return true;
        }
        if(T[0][2] == T[1][1] && T[1][1] == T[2][0] && T[1][1] != ""){
            System.out.println("winner : "+T[1][1]);
            return true;
        }
        // lignes
        for (int i = 0; i < 3; i++){
            if(T[i][0] == T[i][1] && T[i][1] == T[i][2] && T[i][2] != ""){
                System.out.println("winner : "+T[0][0]);
                return true;
            }
        }
        // collones
        for (int i = 0; i < 3; i++){
            if(T[0][i] == T[1][i] && T[1][i] == T[2][i] && T[2][i] != ""){
                System.out.println("winner : "+T[0][0]);
                return true;
            }
        }
        return false;
    }

    public int utilite(){
        int value = 0;
        
        return value;
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
}
