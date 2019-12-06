public class ambiente {

    public static node0 n0 = new node0();
    public static node1 n1 = new node1();
    public static node2 n2 = new node2();
    public static node3 n3 = new node3();

    public static void toLayer2(rtpkt pacote){
        
        if(pacote.destid == 0){
            n0.rtupdate0(pacote);
        }else if(pacote.destid == 1){
            n1.rtupdate1(pacote);
        }else if(pacote.destid == 2){
            n2.rtupdate2(pacote);
        }else{
            n3.rtupdate3(pacote);
        }
    }

    public static void main(String[] args) {
        System.out.println("Iniciou");
        n0.rtinit0();
        n1.rtinit1();
        n2.rtinit2();
        n3.rtinit3();
        
        /* Print dos vetores de custos do roteador 0 */
        for(int i = 0; i < 4; i++){
            System.out.print(i + " - ");
            System.out.print(n0.cost[i][0] + " " + n0.cost[i][1] + " " + n0.cost[i][2] + " " + n0.cost[i][3] + "\n");
        }
    }
}