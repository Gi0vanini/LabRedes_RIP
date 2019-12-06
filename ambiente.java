public class Ambiente {

    public static Node n0 = new Node(0);
    public static Node n1 = new Node(1);
    public static Node n2 = new Node(2);
    public static Node n3 = new Node(3);

    public static void toLayer2(Rtpkt pacote) {
        switch (pacote.destId) {
        case 0:
            n0.rtupdate(pacote);
            break;
        case 1:
            n1.rtupdate(pacote);
            break;
        case 2:
            n2.rtupdate(pacote);
            break;
        case 3:
            n3.rtupdate(pacote);
            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Iniciou");
        n0.rtinit0();
        n1.rtinit1();
        n2.rtinit2();
        n3.rtinit3();

        /* Print dos vetores de custos do roteador 0 */
        // for (int i = 0; i < 4; i++) {
        // System.out.print(i + " - ");
        // System.out.print(n0.distanceTable[i][0] + " " + n0.distanceTable[i][1] + " "
        // + n0.distanceTable[i][2] + " " + n0.distanceTable[i][3] + "\n");
        // }
        n0.printdt0();
        n1.printdt1();
        n2.printdt2();
        n3.printdt3();
    }
}