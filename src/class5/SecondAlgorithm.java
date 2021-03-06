package class5;

import org.graphstream.algorithm.Kruskal;
import org.graphstream.algorithm.Prim;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

public class SecondAlgorithm {
    public static void main(String ... args) {

        Graph graph = new DefaultGraph("Kruskal Test");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        graph.addEdge("AB", "A", "B").addAttribute("custo", 280);
        graph.addEdge("BC", "B", "C").addAttribute("custo", 200);
        graph.addEdge("BD", "B", "D").addAttribute("custo", 400);
        graph.addEdge("CD", "C", "D").addAttribute("custo", 650);
        graph.addEdge("DE", "D", "E").addAttribute("custo", 300);
        graph.addEdge("DF", "D", "F").addAttribute("custo", 350);
        graph.addEdge("FG", "F", "G").addAttribute("custo", 250);
        graph.addEdge("DG", "D", "G").addAttribute("custo", 600);

        for (Node n : graph)
            n.addAttribute("label", n.getId());

        String css = "edge .notintree {size:5px;fill-color:gray;} " +
                "edge .intree {size:8px;fill-color:black;} ";

        graph.addAttribute("ui.stylesheet", css);
        graph.display();

//        Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");
//
//        kruskal.init(graph);
//        kruskal.compute();

        Prim prim = new Prim("ui.class", "intree", "notintree");

        prim.init(graph);
        prim.compute();
    }
}
