public class Main {
    public static void main(String[] args) {

        Noeud n = new Noeud();
        System.out.println(n.TestTerminaison());
        n.setX(0,0);
        n.setX(1,0);
        n.setX(2,0);
        n.Afficher();
        System.out.println(n.TestTerminaison());
    }
}