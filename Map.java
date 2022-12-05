import com.google.common.graph.*; 

/*The map class holds the struture of the game and allows the person to move through it */
public class Map {

    Location start; 
    Location lakeOne; 
    Location sawCamp; 
    Location butterCamp; 
    Location flourCamp; 
    Location portageStart; 
    Location portageEnd;
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
    Location portageStart, 
    Location portageEnd,
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
        .putEdge(lakeOne, portageStart)
        .putEdge(portageStart, portageEnd)
        .putEdge(portageEnd, mooseLake)
        .putEdge(mooseLake, sugarCamp)
        .putEdge(mooseLake, emptyCamp1)
        .putEdge(mooseLake, finalCamp)
        .putEdge(mooseLake, panCamp)
        .putEdge(mooseLake, cinnamonCamp)
        .putEdge(mooseLake, emptyCamp2)     
        .build();
    }

    public boolean canMove(Location current, Location want) {
        return (graph.hasEdgeConnecting(current, want));
    }

    public Location canPortage(Location current) {
        if (current.equals(this.portageStart) == true) {
            return this.portageEnd;
        }
        else if (current.equals(this.portageEnd)) {
            return this.portageStart;
        }
            return null;
    }


    public Location stringtoLocation(String name) {
        for(Location loc : this.graph.nodes()) {
            if (name.equals(loc.name.toLowerCase())) {
                return loc;
            }
        }
        return null;
    }

    /*public void addItem(item toAdd) {
        for(Location loc : this.graph.nodes()) {
            if (loc.items.contains(toAdd)) {
                
            }
        } 
    }/* */

    public static void main(String[] args) {
       
    }
}
