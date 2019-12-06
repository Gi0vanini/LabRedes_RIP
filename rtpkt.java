public class Rtpkt {
    public int sourceId; /* Id do cara que está mandando o pacote */
    public int destId; /* Id do destino */
    public int[] mincost; /* Vetor de custos do cara que está enviando o pacote */

    public Rtpkt(int sourceId, int destId, int mincost[]) {
        this.sourceId = sourceId;
        this.destId = destId;
        this.mincost = mincost;
    }

    @Override
    public String toString() {
        String s = sourceId + ", " + destId + ", [";

        for (int cost : mincost) {
            s += cost + ", ";
        }

        s += "]\n";

        return s;
    }
}