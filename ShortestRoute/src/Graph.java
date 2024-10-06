import java.io.*;
import java.util.*;

public class Graph {
    public int numberOfStops;
    public ArrayList<Stop> stops;
    public ArrayList<ArrayList<Edge>> adjEdges;

    public Graph(String stopsFile, String stopTimesFile, String transfersFile) {
        stops = new ArrayList<>();
        addStops(stopsFile);
        adjEdges = new ArrayList<>(stops.size());
        numberOfStops = stops.size();
        for (int i = 0; i < stops.size(); i++) {
            adjEdges.add(new ArrayList<>());
        }
        addStopEdges(stopTimesFile);
        addTransferEdges(transfersFile);
        System.out.println("success");
    }

    private void addStops(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            scanner.nextLine();
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    stops.add(new Stop(scanner.nextInt()));
                    scanner.nextLine();
                }
            }
            scanner.close();
        } catch (IOException e) {
            stops = null;
        }
    }

    private void addStopEdges(String filename) {
        try {
            int lastRoute, currRoute, lastStop, currStop;
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            scanner.nextLine();
            lastRoute = scanner.nextInt();
            scanner.next();
            scanner.next();
            lastStop = scanner.nextInt();
            scanner.nextLine();
            while (scanner.hasNext()) {
                currRoute = scanner.nextInt();
                scanner.next();
                scanner.next();
                if (lastRoute == currRoute) {
                    currStop = scanner.nextInt();
                    adjEdges.get(findStop(lastStop)).add(new Edge(lastStop, currStop, 1));
                    scanner.nextLine();
                } else {
                    lastRoute = scanner.nextInt();
                    scanner.next();
                    scanner.next();
                    lastStop = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            scanner.close();
        } catch (IOException e) {
            adjEdges = null;
        }
    }

    private void addTransferEdges(String filename) {
        try {
            int fromStop, destStop;
            double weight;
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",|\\n");
            scanner.nextLine();
            while (scanner.hasNext()) {
                fromStop = scanner.nextInt();
                destStop = scanner.nextInt();
                if (scanner.nextInt() == 2){
                    weight = (scanner.nextInt() / 100);
                    scanner.nextLine();
                }
                else {
                    weight = 2;
                    scanner.nextLine();
                }
                if (adjEdges.get(findStop(fromStop)).isEmpty()){
                    ArrayList<Edge> edges = new ArrayList<Edge>();
                    edges.add(new Edge(fromStop, destStop, weight));
                    adjEdges.add(edges);
                }
                else adjEdges.get(findStop(fromStop)).add(new Edge(fromStop, destStop, weight));
            }
            scanner.close();
        } catch (IOException e) {
            adjEdges = null;
        }
    }

    public int findStop(int stopNumber) {
        for (int i = 0; i < stops.size(); i++) {
            if (stops.get(i).stopNumber == stopNumber) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	
    	Graph g = new Graph("stops.txt", "stop_times.txt", "transfers.txt");
    	
    	System.out.println(g.adjEdges.size());
    }
}