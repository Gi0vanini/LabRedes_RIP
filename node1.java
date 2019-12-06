public class node1{

    public int[][] cost = new int[4][4];

    public void rtinit1(){
        this.cost[1][0] = 1;
        this.cost[1][1] = 0;
        this.cost[1][2] = 1;
        this.cost[1][3] = 999;
        
        this.cost[0][0] = 999;
        this.cost[0][1] = 999;
        this.cost[0][2] = 999;
        this.cost[0][3] = 999;

        for(int i = 2; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.cost[i][j] = 999;
            }
        }

        /* Enviando os pacotes */
        rtpkt pacote0 = new rtpkt(1, 0, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
        ambiente.toLayer2(pacote0);

        rtpkt pacote2 = new rtpkt(1, 2, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
        ambiente.toLayer2(pacote2);

        rtpkt pacote3 = new rtpkt(1, 3, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
        ambiente.toLayer2(pacote3);
    }

    public void rtupdate1(rtpkt pacote){
        int novo_min;
        int temp;

        temp = Math.min(this.cost[1][0] + pacote.mincost[0], this.cost[1][2] + pacote.mincost[2]);
        novo_min = Math.min(temp, this.cost[1][3] + pacote.mincost[3]);

        this.cost[pacote.sourceid][0] = pacote.mincost[0];
        this.cost[pacote.sourceid][1] = pacote.mincost[1];
        this.cost[pacote.sourceid][2] = pacote.mincost[2];
        this.cost[pacote.sourceid][3] = pacote.mincost[3];

        if(this.cost[1][pacote.sourceid] > novo_min){
            this.cost[1][pacote.sourceid] = novo_min;
            
            /* Enviando os pacotes */
            rtpkt pacote0 = new rtpkt(1, 0, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
            ambiente.toLayer2(pacote0);

            rtpkt pacote2 = new rtpkt(1, 2, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
            ambiente.toLayer2(pacote2);

            rtpkt pacote3 = new rtpkt(1, 3, this.cost[1][0], this.cost[1][1], this.cost[1][2], this.cost[1][3]);
            ambiente.toLayer2(pacote3);
        }
    }

    public void printdt1(){
        System.out.println("             Via        ");
        System.out.println("   D0 |    0     2    3 ");
        System.out.println("  ----|-----------------");
        System.out.println("     0|  " + this.cost[0][0] + "   " + this.cost[0][2] + "   " + this.cost[0][3]);
        System.out.println("dest 2|  " + this.cost[2][0] + "   " + this.cost[2][2] + "   " + this.cost[2][3]);
        System.out.println("     3|  " + this.cost[3][0] + "   " + this.cost[3][2] + "   " + this.cost[3][3]);
    }
}