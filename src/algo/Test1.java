package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Test1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String num = bf.readLine();
    StringTokenizer st = new StringTokenizer(num);
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    String[][] arr = new String[row][col];
    for(int i=0; i<row; i++) {
      arr[i] = bf.readLine().split("");
    }
    int rMin=10000;
    int min;
    for(int iRow=0; iRow<=row-8; iRow++) {
      for(int kCol=0; kCol<=col-8; kCol++) {
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<8; i++) {
          for(int k=0; k<8; k++) {
            switch((i+k)%2) {	// 기준 문자와 홀짝관계
              case 0:			// 짝일시
                if(!arr[iRow][kCol].equals(arr[iRow+i][kCol+k])) count1++;
                else count2++;
                break;
              case 1:
                if(arr[iRow][kCol].equals(arr[iRow+i][kCol+k])) count1++;
                else count2++;
                break;
            }
          }
        }
        min = Math.min(count1, count2);
        rMin = Math.min(rMin, min);
      }
    }
    System.out.println(rMin);
  }
}
