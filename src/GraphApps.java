//Author: David Fernando Gamboa Salazar
//Date: 11/23/2018
class Vertex
{
    public char label; 		// label (e.g. ‘A’)
    public boolean wasVisited;

    public Vertex(char lab) 	// constructor
    {
        label = lab;
        wasVisited = false;
    }
} // end class Vertex
class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    
    // -----------------------------------------------------------
    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // set adjacency
            for(int k=0; k<MAX_VERTS; k++) // matrix to 0
                adjMat[j][k] = 0;
    } // end constructor
public void displayVertices() {
    	for(int i=0;i<nVerts;i++) {
    		System.out.print(vertexList[i].label);
    	}
    	//System.out.println();
    }
public void displayEdges() {
	for(int i=0; i<adjMat.length; i++) {
        for(int j=0; j<adjMat[i].length; j++) {
            if(adjMat[i][j]==1) {
            	displayVertex(i);
            	System.out.print("---");
            	displayVertex(j);
            	 System.out.println();
            }
        }
     
    }
	}
	//System.out.println();

    // -----------------------------------------------------------
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // -----------------------------------------------------------
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
    }
    // ------------------------------------------------------------
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    public void removeVertexEdges(int v)
    {
    for(int i=0;i<adjMat[v].length;i++) {
    	adjMat[v][i]=0;
    }
    }
    public int vertexOutDegree(int v) {
    	int ans=0;
    	for(int i=0; i<adjMat.length; i++) {
            for(int j=0; j<adjMat[i].length; j++) {
               if(adjMat[i]==adjMat[v]) {
            	   if(adjMat[i][j]!=0) {
            	   ans++;
            	   }
               }
            }
    	}
    	return ans;
    }
    public int vertexInDegree(int v) {
    	int ans=0;
    	for(int i=0; i<adjMat.length; i++) {
            for(int j=0; j<adjMat[i].length; j++) {
            	if(j==v) {
                	  if(adjMat[i][j]!=0) {
                		  
                   	   ans++;
                      }   }      
            }
    	}
    	return ans;
    }

    // ------------------------------------------------------------
} // end class Graph
public class GraphApps
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(3, 1); // DB
        theGraph.addEdge(3, 2); // DC
        theGraph.addEdge(3, 4); // DE
        theGraph.addEdge(4, 3); // ED
        theGraph.addEdge(2, 3); // CD
        System.out.print("Vertices: ");
        theGraph.displayVertices();
        System.out.println();
        System.out.println("Edges:");
       theGraph.displayEdges();
       //theGraph.removeVertexEdges(0); //removes the edges of A
       System.out.println("Edges:");
       theGraph.displayEdges(); //displays newly formed edges
       System.out.println("The vertex 3 has an out degree :"+theGraph.vertexOutDegree(3));
       System.out.println("The vertex 3 has an in degree :"+theGraph.vertexInDegree(3));
    } // end main()
    
} // end class GraphApp