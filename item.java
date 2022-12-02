public class item {
    public String name;
    private String use;
    private Location location;

    public item(String name, String use, Location location) {
        this.name = name;
        this.use = use;
        this.location = location;
    }

    public String getUse() {
        return this.use;
    }

    public String getLocation() {
        return this.location.name;
    }

    public static void main(String[] args) {
    
    }

}

//