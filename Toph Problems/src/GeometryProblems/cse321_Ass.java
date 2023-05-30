package GeometryProblems;

public class cse321_Ass {

	public static void main(String[] args) {
		int al[][]= new int[13][6];
		for (int i=1; i<13; i++) {
			System.out.print(i + " ");
			for(int j=1; j<6; j++) {
				al[i][j] = (2i *( j+1 ) % 7);
				System.out.print(al[i][j]);
			}
			System.out.println(" ");
		}		
		
	}
}
