package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Candy {
  private static String[][] str;
  private static int size = 0;
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int max = 0;
    size = Integer.parseInt(st.nextToken());
    str = new String[size][size];
    for(int i=0; i<size; i++) {
      str[i] = bf.readLine().split("");
      max = Math.max(max, checkRow(i));	// 문자열 교환전 최대값
    }
    for(int i=0; i<size; i++) {
      max = Math.max(max, checkCol(i));	// 문자열 교환전 최대값
    }
    for(int i=0; i<size; i++) {
      for(int k=0; k<size; k++) {
        if(k+1 < size) {
          swapArr(i, i, k, k+1);
          max = Math.max(max, checkRow(i));
          max = Math.max(max, checkCol(k));
          max = Math.max(max, checkCol(k+1));
          swapArr(i, i, k, k+1);

        }
        if(i+1 < size) {
          swapArr(i, i+1, k, k);
          max = Math.max(max, checkRow(i));
          max = Math.max(max, checkRow(i+1));
          max = Math.max(max, checkCol(k));
          swapArr(i, i+1, k, k);
        }
      }
    }
    System.out.println(max);
  }

  private static int checkRow(int row) {
    int count = 1;	// 최대값 카운트
    int temp = 1;	// 사탕 수
    String k = str[row][0];	// 행 고정
    for(int i = 1; i < size; i++) {
      if(!str[row][i].equals(k)) {
        k = str[row][i];
        count = Math.max(count, temp);	// 최대 사탕
        temp = 1;
      }
      else temp++;
    }
    return Math.max(count, temp);
  }

  private static int checkCol(int col) {
    int count = 1;	// 최대값 카운트
    int temp = 1;	// 사탕 수
    String k = str[0][col];	// 열 고정
    for(int i = 1; i < size; i++) {
      if(!str[i][col].equals(k)) {	// 연속되지 않을시
        k = str[i][col];
        count = Math.max(count, temp);
        temp = 1;
      }
      else temp++;
    }
    return Math.max(count, temp);
  }

  private static void swapArr(int row1, int row2, int col1, int col2) {
    String temp = new String(str[row1][col1]);
    str[row1][col1] = str[row2][col2];
    str[row2][col2] = temp;
  }
}
