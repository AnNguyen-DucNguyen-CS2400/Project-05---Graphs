public class GraphTesting {

	public static void main(String[] args) {
		DirectedGraph<Character> graph = new DirectedGraph();
		graph.addVertex('A'); graph.addVertex('B'); graph.addVertex('C');
		graph.addVertex('D'); graph.addVertex('E'); graph.addVertex('F');
		graph.addVertex('G'); graph.addVertex('H'); graph.addVertex('I');
		
		graph.addEdge('A','B'); graph.addEdge('A','D'); graph.addEdge('A','E');
		graph.addEdge('B','E');
		graph.addEdge('C','B');
		graph.addEdge('D','G');
		graph.addEdge('E','F'); graph.addEdge('E','H');
		graph.addEdge('F','C');
		graph.addEdge('F','H');
		graph.addEdge('G','H');
		graph.addEdge('H','I');
		graph.addEdge('I','F');
		
			
		QueueInterface<Character> bdf = graph.getBreadthFirstTraversal('A');
		Object[] bdfArray = bdf.toArray();
		System.out.print("Breadth-First Traveral: ");
		for (int i = 0; i < bdfArray.length; i++)
		{
			System.out.print(bdfArray[i] + " ");
		}
		System.out.println();
		
		QueueInterface<Character> dft = graph.getDepthFirstTraversal('A');
		Object[] dftArray = dft.toArray();
		System.out.print("Depth-First Traveral: ");
		for (int i = 0; i < dftArray.length; i++)
		{
			System.out.print(dftArray[i] + " ");
		}
		
	}

}
