import java.io.*;
import java.util.*;

public class ParkingSpace {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		int minParkingSpaces = 0;

		// Sorting input array based on start time
		Arrays.sort(parkingStartEndTimes, new Comparator<int[]>() {
			@Override              
          	// Compare values according to columns 
          	public int compare(final int[] element1,  
                             final int[] element2) { 
            	if (element1[0] > element2[0]) {
					return 1;
				} else {
                	return -1; 
				}
          	} 
		});

        for (int i = 0; i < parkingStartEndTimes.length-1; i++) {
			if (parkingStartEndTimes[i][1] > parkingStartEndTimes[i+1][0]) {
				minParkingSpaces++;
			}
			for (int j=0; j<i ; j++) {
				if (parkingStartEndTimes[j][1] > parkingStartEndTimes[i][0]) {
					minParkingSpaces++;
				}
			}
        } 

		return minParkingSpaces;
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
