package boj.P1904;

import java.io.*;

// 01타일(https://www.acmicpc.net/problem/1904)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N <= 2){
            bw.write(N+"");
        }else{
            int[] table = new int[N+1];
            table[1] = 1;
            table[2] = 2;
            for(int i = 3; i <= N; i++){
                table[i] = (table[i-1]%15746 + table[i-2]%15746)%15746;
            }
            bw.write(table[N]+"");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}