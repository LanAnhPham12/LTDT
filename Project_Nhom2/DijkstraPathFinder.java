package Project_Nhom2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class DijkstraPathFinder {
	private List<wayToPostOffice> postOffice;
	private List<wayToPostOffice> dijkstraPath;
	private boolean[] visited;
	private double[][] distance;
	private double totalDistance;
	private double[] dijkstraDistances;
	public DijkstraPathFinder(List<wayToPostOffice> postOffice) {
		super();
		this.postOffice = postOffice;
		int size = this.postOffice.size();
		this.dijkstraPath = new ArrayList<>();
		this.visited = new boolean[size];
		this.distance = new double[size][size];
		this.dijkstraDistances = new double[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				distance[i][j] = postOffice.get(i).distanceTo(postOffice.get(j));
				
			}
			dijkstraDistances[i] = Double.POSITIVE_INFINITY;
		}
	}
	public List<wayToPostOffice> getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(List<wayToPostOffice> postOffice) {
		this.postOffice = postOffice;
	}
	public List<wayToPostOffice> getDijkstraPath() {
		return dijkstraPath;
	}
	public void setDijkstraPath(List<wayToPostOffice> dijkstraPath) {
		this.dijkstraPath = dijkstraPath;
	}
	public boolean[] getVisited() {
		return visited;
	}
	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}
	public double[][] getDistance() {
		return distance;
	}
	public void setDistance(double[][] distance) {
		this.distance = distance;
	}
	public double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public double[] getDijkstraDistances() {
		return dijkstraDistances;
	}
	public void setDijkstraDistances(double[] dijkstraDistances) {
		this.dijkstraDistances = dijkstraDistances;
	}
	// them buu dien
	public void addPostOffice(wayToPostOffice post) {
		postOffice.add(post);
	}
	// tim duong di co buu dien
	public List<wayToPostOffice> findDijkstraPath() {
		dijkstraPath.clear();
		Arrays.fill(visited, false);
		totalDistance = 0;
		int currentVertex = 0;
		dijkstraPath.add(postOffice.get(currentVertex));
		visited[currentVertex] = true;
		while (dijkstraPath.size() < postOffice.size()){
			int nextVertex = getNextVertex(currentVertex);	
			if(nextVertex == -1) {
				return null; //khong tim thay duong di den buu dien 
			}
			dijkstraPath.add(postOffice.get(nextVertex));
			visited[nextVertex]= true;
			totalDistance += distance[currentVertex][nextVertex] ;
			currentVertex = nextVertex;					
		}
		dijkstraPath.add(postOffice.get(0));
		totalDistance += distance[currentVertex][0];
			
		return dijkstraPath;
		
	}
	private int getNextVertex(int currentVertex) {
		// TODO Auto-generated method stub
		int nextVertex = -1;
		double minDistance = Double.POSITIVE_INFINITY;
		for (int i = 0; i < postOffice.size(); i++) {
			if(!visited[i] && distance[currentVertex][i] > 0 && distance[currentVertex][i] < minDistance) {
				nextVertex = i;
				minDistance = distance[currentVertex][i];
				
			}
			
		}
		return nextVertex;
	}
	//them canh duong di
	public void addEdge(List<wayToPostOffice> postOffices, int maxDistance) {
		double weight;
		int size = postOffice.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				weight = distance[i][j] = postOffice.get(i).distanceTo(postOffice.get(j));
			}
		}
	}
	// in duong di
	public String printPath() {
		StringBuilder result = new StringBuilder();
		List<wayToPostOffice> dijkstraPath = findDijkstraPath();
		if (dijkstraPath != null) {
			result.append("Duong di ngan nhat: ");
			for (wayToPostOffice destination : dijkstraPath) {
				result.append(destination.getName()).append(" -> ");
			}
			result.setLength(result.length() - 4);
			result.append("Tong khoang cach den cac buu dien : " + getTotalDistance());
		} else {
			result.append("Khong co duong di ngan nhat");
		}
		return result.toString();		
	}
	public static void main(String[] args) {
		//Tao ds buu dien
		List<wayToPostOffice> postOffice = new ArrayList<>();
		   postOffice.add(new wayToPostOffice("Quan 9", 300.0, 212.1));
		   postOffice.add(new wayToPostOffice("Quan 8", 450.0, 475.9));
		   postOffice.add(new wayToPostOffice("Quan 7", 125.9, 546.2));
		   postOffice.add(new wayToPostOffice("Quan 6", 120.7, 251.5));
		   postOffice.add(new wayToPostOffice("Quan 5", 450.2, 452.1));
		   
		   // tao diem den
		   DijkstraPathFinder pathFinder = new DijkstraPathFinder(postOffice);
		   pathFinder.addEdge(Arrays.asList(postOffice.get(0), postOffice.get(1)), 5);
		   pathFinder.addEdge(Arrays.asList(postOffice.get(0), postOffice.get(2)), 3);
		   pathFinder.addEdge(Arrays.asList(postOffice.get(1), postOffice.get(2)), 2);
		   
		   // tim duong di ngan nhat
		List<wayToPostOffice> dijkstraPath = pathFinder.findDijkstraPath();
		   // In ket qua
			System.out.println(pathFinder.printPath());
			//System.out.println(pathFinder);
	}
}
