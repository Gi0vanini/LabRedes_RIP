import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Node {

    private static final int N = 4;

    private int id;
    private List<Integer> neighbours = new ArrayList<Integer>();
    private int[][] distances = new int[N][N];

    public Node(int id) {
        this.id = id;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distances[i][j] = 999;
            }
        }
        distances[id][id] = 0;
    }

    private void addNeighbour(int neighbour, int distance) {
        neighbours.add(neighbour);
        distances[id][neighbour] = distance;
    }

    public void rtinit0() {
        addNeighbour(1, 1);
        addNeighbour(2, 3);
        addNeighbour(3, 7);
        for (int neighbour : neighbours) {
            Ambiente.toLayer2(new Rtpkt(id, neighbour, distances[id]));
        }

    }

    public void rtinit1() {
        addNeighbour(0, 1);
        addNeighbour(2, 1);
        for (int neighbour : neighbours) {
            Ambiente.toLayer2(new Rtpkt(id, neighbour, distances[id]));
        }
    }

    public void rtinit2() {
        addNeighbour(0, 3);
        addNeighbour(1, 1);
        addNeighbour(3, 2);
        for (int neighbour : neighbours) {
            Ambiente.toLayer2(new Rtpkt(id, neighbour, distances[id]));
        }
    }

    public void rtinit3() {
        addNeighbour(0, 7);
        addNeighbour(2, 2);
        for (int neighbour : neighbours) {
            Ambiente.toLayer2(new Rtpkt(id, neighbour, distances[id]));
        }
    }

    public void rtupdate(Rtpkt packet) {

        int current_min[] = distances[id];

        distances[packet.sourceId] = packet.mincost;

        for (int i = 0; i < N; i++) {
            if (i == id)
                continue;
            distances[id][i] = Math.min(current_min[i], current_min[i] + distances[packet.sourceId][i]);
        }

        if (!Arrays.equals(current_min, distances[id])) {
            for (int neighbour : neighbours) {
                Ambiente.toLayer2(new Rtpkt(id, neighbour, distances[id]));
            }
        }

    }

    public void printdt0() {
        System.out.println("             Via        ");
        System.out.println("   D0 |    1     2    3 ");
        System.out.println("  ----|-----------------");
        System.out.println("     1|  " + distances[1][1] + "   " + distances[1][2] + "   " + distances[1][3]);
        System.out.println("dest 2|  " + distances[2][1] + "   " + distances[2][2] + "   " + distances[2][3]);
        System.out.println("     3|  " + distances[3][1] + "   " + distances[3][2] + "   " + distances[3][3]);
    }

    public void printdt1() {
        System.out.println("             Via        ");
        System.out.println("   D1 |    0     2    3 ");
        System.out.println("  ----|-----------------");
        System.out.println("     0|  " + distances[0][0] + "   " + distances[0][2] + "   " + distances[0][3]);
        System.out.println("dest 2|  " + distances[2][0] + "   " + distances[2][2] + "   " + distances[2][3]);
        System.out.println("     3|  " + distances[3][0] + "   " + distances[3][2] + "   " + distances[3][3]);
    }

    public void printdt2() {
        System.out.println("             Via        ");
        System.out.println("   D2 |    0     1    3 ");
        System.out.println("  ----|-----------------");
        System.out.println("     0|  " + distances[0][0] + "   " + distances[0][1] + "   " + distances[0][3]);
        System.out.println("dest 1|  " + distances[1][0] + "   " + distances[1][1] + "   " + distances[1][3]);
        System.out.println("     3|  " + distances[3][0] + "   " + distances[3][1] + "   " + distances[3][3]);
    }

    public void printdt3() {
        System.out.println("             Via        ");
        System.out.println("   D3 |    0     1    2 ");
        System.out.println("  ----|-----------------");
        System.out.println("     0|  " + distances[0][0] + "   " + distances[0][1] + "   " + distances[0][2]);
        System.out.println("dest 1|  " + distances[1][0] + "   " + distances[1][1] + "   " + distances[1][2]);
        System.out.println("     2|  " + distances[2][0] + "   " + distances[2][1] + "   " + distances[2][2]);
    }

}