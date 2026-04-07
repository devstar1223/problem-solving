package boj.P11060;

import java.io.*;
import java.util.*;

// 점프 점프(https://www.acmicpc.net/problem/11060)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        String[] arrayString = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(arrayString[i]);
        }

        int[] answer = new int[N];
        Arrays.fill(answer,-1);
        answer[0] = 0;

        for(int i = 0; i < N; i++){
            int jumpAble = array[i];
            if(answer[i] == -1){
                continue;
            }
            for(int j = 1; j <= jumpAble; j++){
                if(i+j < N && answer[i+j] == -1){
                    answer[i+j] = answer[i]+1;
                }
            }
        }

        bw.write(answer[N-1]+"");

        bw.flush();

        bw.close();
        br.close();
    }
}