package boj.P1302;

import java.io.*;
import java.util.*;

// 베스트셀러(https://www.acmicpc.net/problem/1302)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> bookInfoMap = new HashMap<>();

        for(int i = 0; i < N; i++){
            String bookName = br.readLine();
            bookInfoMap.put(bookName, bookInfoMap.getOrDefault(bookName,0) + 1);
        }

        Set<String> bookInfoMapKeyset = bookInfoMap.keySet();

        List<String> answerList = new ArrayList<>();
        int maxCount = 0;

        for(String set : bookInfoMapKeyset){
            int bookCount = bookInfoMap.get(set);
            if(bookCount > maxCount){
                answerList.clear();
                answerList.add(set);
                maxCount = bookCount;
            }else if(bookCount == maxCount){
                answerList.add(set);
            }
        }

        Collections.sort(answerList);

        bw.write(answerList.get(0));
        bw.flush();

        bw.close();
        br.close();
    }
}