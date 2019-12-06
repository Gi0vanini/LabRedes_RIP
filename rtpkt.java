public class rtpkt{
    public int sourceid;       /* Id do cara que está mandando o pacote */
    public int destid;         /* Id do destino */
    public int[] mincost = new int[4];    /* Vetor de custos do cara que está enviando o pacote */

    public rtpkt(int source, int dest, int a0, int a1, int a2, int a3){
        this.sourceid = source;
        this.destid = dest;
        this.mincost[0] = a0;
        this.mincost[1] = a1;
        this.mincost[2] = a2;
        this.mincost[3] = a3;
    }
}