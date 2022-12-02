import com.google.common.graph.*; 
/*The map class holds the struture of the game and allows the person to move through it */
public class Map {
    Location lakeOne;
    Location sawCamp; 
    Location butterCamp; 
    Location flourCamp;
    Location portage; 
    Location mooseLake;
    Location sugarCamp;
    Location emptyCamp1;
    Location finalCamp;
    Location panCamp;
    Location cinnamonCamp;
    Location emptyCamp2;  

    public ImmutableGraph<Location> graph;
   
    public Map(Location start, 
    Location lakeOne, 
    Location sawCamp, 
    Location butterCamp, 
    Location flourCamp, 
    Location portage, 
    Location mooseLake,
    Location sugarCamp,
    Location emptyCamp1,
    Location finalCamp,
    Location panCamp,
    Location cinnamonCamp,
    Location emptyCamp2 ) {

        this.graph = GraphBuilder.undirected()
        .<Location>immutable()
        .putEdge(start, lakeOne)
        .putEdge(lakeOne, sawCamp)
        .putEdge(lakeOne, butterCamp)
        .putEdge(lakeOne, flourCamp)
        .putEdge(lakeOne, portage)
        .putEdge(portage, mooseLake)
        .putEdge(mooseLake, sugarCamp)
        .putEdge(mooseLake, emptyCamp1)
        .putEdge(mooseLake, finalCamp)
        .putEdge(mooseLake, panCamp)
        .putEdge(mooseLake, cinnamonCamp)
        .putEdge(mooseLake, emptyCamp2)
        .build();
    }

    public boolean canMove(Location current, Location want) {
        //if (current.name.equals("Portage" && ) ) {

        //}
        return (graph.hasEdgeConnecting(current, want));
    }

    public static void main(String[] args) {
       
    }
}
