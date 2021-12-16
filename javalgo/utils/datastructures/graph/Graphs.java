package datastructures.graph;

import java.util.ArrayList;

public class Graphs {
    public static void main(String args[]) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
         graph.addEdge(1, 2);
         graph.addEdge(1, 5);
         graph.addEdge(2, 5);
         graph.addEdge(1, 2);
         graph.addEdge(2, 3);
         graph.addEdge(3, 4);
         graph.addEdge(4, 1);
         graph.addEdge(2, 3);
        System.out.println(graph.toString());
      }
}

class AdjacencyListGraph<E extends Comparable<E>>{
    ArrayList<Vertex> verticies;

    public AdjacencyListGraph() {
        verticies = new ArrayList<>();
    }

    public class Vertex{
        E data;
        ArrayList<Vertex> adjacenctVerticies;

        public Vertex(E data){
            adjacenctVerticies=new ArrayList<>();
            this.data=data;
        }

        public boolean addAdjacentVertex(Vertex to){
            for(Vertex v: adjacenctVerticies){
                if(v.data.compareTo(to.data)==0){
                    return false; //이미 존재한다는 것
                }
            }
            return adjacenctVerticies.add(to);
        }

        public boolean removeAdjacentVertex(E to){
            for(int i=0; i<adjacenctVerticies.size(); i++){
                if(adjacenctVerticies.get(i).data.compareTo(to)==0){
                    adjacenctVerticies.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeEdge(E from,E to){
        Vertex fromV=null;
        for(Vertex v:verticies){
            if(from.compareTo(v.data)==0){
                fromV=v;
                break;
            }
        }
        if(fromV==null) return false;
        return fromV.removeAdjacentVertex(to);
    }

    public boolean addEdge(E from,E to){
        Vertex fromV=null, toV=null;
        for(Vertex v : verticies){
            if(from.compareTo(v.data)==0){
                fromV=v;
            }else if(to.compareTo(v.data)==0){
                toV=v;
            }
            if(fromV!=null && toV!=null) break;
        }
        if(fromV==null){
            fromV=new Vertex(from);
            verticies.add(fromV);
        }
        if(toV==null){
            toV=new Vertex(to);
            verticies.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(Vertex v:verticies){
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for(Vertex v2: v.adjacenctVerticies){
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
