public class node2{

    public int[][] cost = new int[4][4];

    public void rtinit2(){

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                this.cost[i][j] = 999;
            }
        }

        this.cost[2][0] = 3;
        this.cost[2][1] = 1;
        this.cost[2][2] = 0;
        this.cost[2][3] = 2;

        this.cost[3][0] = 999;
        this.cost[3][1] = 999;
        this.cost[3][2] = 999;
        this.cost[3][3] = 999;

        /* Enviando os pacotes */
        rtpkt pacote0 = new rtpkt(2, 0, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
        ambiente.toLayer2(pacote0);

        rtpkt pacote1 = new rtpkt(2, 1, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
        ambiente.toLayer2(pacote1);

        rtpkt pacote3 = new rtpkt(2, 3, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
        ambiente.toLayer2(pacote3);
    }

    public void rtupdate2(rtpkt pacote){
        int novo_min;
        int temp;

        temp = Math.min(this.cost[2][0] + pacote.mincost[0], this.cost[2][1] + pacote.mincost[1]);
        novo_min = Math.min(temp, this.cost[2][3] + pacote.mincost[3]);

        this.cost[pacote.sourceid][0] = pacote.mincost[0];
        this.cost[pacote.sourceid][1] = pacote.mincost[1];
        this.cost[pacote.sourceid][2] = pacote.mincost[2];
        this.cost[pacote.sourceid][3] = pacote.mincost[3];

        if(this.cost[2][pacote.sourceid] > novo_min){
            this.cost[2][pacote.sourceid] = novo_min;
            
            /* Enviando os pacotes */
            rtpkt pacote0 = new rtpkt(2, 0, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
            ambiente.toLayer2(pacote0);

            rtpkt pacote1 = new rtpkt(2, 1, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
            ambiente.toLayer2(pacote1);

            rtpkt pacote3 = new rtpkt(2, 3, this.cost[2][0], this.cost[2][1], this.cost[2][2], this.cost[2][3]);
            ambiente.toLayer2(pacote3);
        }
    }

    public void printdt2(){
        System.out.println("             Via        ");
        System.out.println("   D0 |    0     1    3 ");
        System.out.println("  ----|-----------------");
        System.out.println("     0|  " + this.cost[0][0] + "   " + this.cost[0][1] + "   " + this.cost[0][3]);
        System.out.println("dest 1|  " + this.cost[1][0] + "   " + this.cost[1][1] + "   " + this.cost[1][3]);
        System.out.println("     3|  " + this.cost[3][0] + "   " + this.cost[3][1] + "   " + this.cost[3][3]);
    }
}