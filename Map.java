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
    
    /*Constructor of the map
     * @param all of the lcoations (lakeOne, sawCamp, flourCamp, butterCamp, etc that are in the game)
     */
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

    /*Checks to see if a player can phsycially move between two nodes of a graph
     * @param the location of the user currently
     * @param the location they want to move to
     * @return true/false whether the user can move between two nodes
     */
    public boolean canMove(Location current, Location want) {
        return (graph.hasEdgeConnecting(current, want));
    }

    /*Checks to see if a user can portage and gives back the location that they would end at if they are able to portage
     * @param current location of user
     * @param the location of the start of the portage
     * @param the location of the end of the portage or null if they haven't med the qualifications
    */
    public Location canPortage(Location current, Location portageStart, Location portageEnd) {
        if (current.name.equals(portageStart.name)) {
            return portageEnd;
        }
        else if (current.name.equals(portageEnd.name)) {
            return portageStart;
        }
        else {
            return null;
        }
            
    }

    /*Takes the user's string and returns a location 
     * @param string name that the user inputs
     * @return the location that the user means orrr null if they don't enter a valid location
    */
    public Location stringtoLocation(String name) {
        for(Location loc : this.graph.nodes()) {
            if (name.equals(loc.name.toLowerCase())) {
                return loc;
            }
        }
        return null;
    }

}
