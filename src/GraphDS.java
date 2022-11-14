import java.util.ArrayList;

public class GraphDS {
    public static class Graph{

        private ArrayList<Vertex> vertices;
        private boolean isWeighted;
        private boolean isDirected;

        public Graph(boolean inputisWeighted, boolean inputIsDirected){
            this.vertices = new ArrayList<Vertex>();
            this.isWeighted = inputisWeighted;
            this.isDirected = inputIsDirected;
        }

        public Vertex addVertex(String data){
            Vertex newVertex = new Vertex(data);
            this.vertices.add(newVertex);
            return newVertex;
        }
        public void addEdge(Vertex vertex1,Vertex vertex2,Integer weight){
            if(!this.isWeighted){
                weight = null;
            }
            vertex1.addEdge(vertex1,weight);
            if(!this.isDirected){
                vertex2.addEdge(vertex1,weight);
            }
        }

        public void removeEdge(Vertex vertex1, Vertex vertex2){
            vertex1.removeEdge(vertex2);
            if(!this.isDirected){
                vertex2.removeEdge(vertex1);
            }
        }
        public void removeVertex(Vertex vertex){
            this.vertices.remove(vertex);
        }
        public Vertex getVertexByValue(String value){
            for(Vertex v : this.vertices){
                if(v.getData() == value){
                    return v;
                }
            }
            return null;
        }
        public void print() {

            for(Vertex v : this.vertices){
                v.print(isWeighted);
            }
        }
    }
    public static class Edge {
        private Vertex start;
        private Vertex end;
        private Integer weight;

        public Edge(Vertex startV, Vertex endV, Integer inputWeight){
            this.start = startV;
            this.end = endV;
            this.weight = inputWeight;

        }

        public Vertex getStart(){
            return this.start;
        }

        public Integer getWeight(){
            return this.weight;
        }

        public Vertex getEnd(){
            return this.end;
        }

    }
    public static class Vertex {
        private String data;
        private ArrayList<Edge> edges;

        public Vertex(String inputData){
            this.data = inputData;
            this.edges = new ArrayList<Edge>();
        }

        public void addEdge(Vertex endVertex, Integer weight){
            this.edges.add(new Edge(this,endVertex,weight));
        }

        public void removeEdge(Vertex endVertex){
            this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
        }

        public String getData(){ return this.data; }

        public void print(boolean showWeight){

            StringBuilder message = new StringBuilder();
            if(this.edges.size() == 0){
                System.out.println(this.data + " -->");
                return;
            }

            for(int i = 0 ; i < this.edges.size() ; i++){
                if(i == 0){
                    message.append(this.edges.get(i).getStart().data).append("--> ");
                }

                message.append(this.edges.get(i).getEnd().data);

                if(showWeight){
                    message.append(" {").append(
                            this.edges.get(i).getWeight()
                    ).append("}");
                }

                if(i != this.edges.size() - 1){
                    message.append(", ");
                }

            }
            System.out.println(message);
        }


    }

    public static void main(String... args){

        Graph busNetwork = new Graph(true,true);
        Vertex cliftonStation = busNetwork.addVertex("Clifton");
        Vertex capeMayStation = busNetwork.addVertex("Cape May");

        busNetwork.addEdge(cliftonStation,capeMayStation,1000);

        busNetwork.print();

    }
}
