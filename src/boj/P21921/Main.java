package boj.P21921;

import java.io.*;

// 블로그(https://www.acmicpc.net/problem/21921)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NX = (br.readLine()).split(" ");
        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);

        String[] stringArray = (br.readLine()).split(" ");

        int index = 0;
        int result = 0;

        for (int i = 0; i < X; i++) {
            result += Integer.parseInt(stringArray[i]);
        }

        int maxValue = result;
        int maxCount = 1;

        // 끝 값을 담을 수 없을때까지 i를 밀면서 반복
        while (index + X < N) {
            // 오른쪽으로 이동
            index++;
            // 왼쪽 값 윈도우에서 제거
            result -= Integer.parseInt(stringArray[index-1]);
            // 오른쪽 값 윈도우에 추가
            result += Integer.parseInt(stringArray[index + X - 1]);

            // 최대값 갱신
            if (result > maxValue) {
                maxCount = 1;
                maxValue = result;
            } else if (result == maxValue) { // 최대값과 동일
                maxCount++;
            }

        }

        if(maxValue == 0){
            bw.write("SAD");
        }else{
            bw.write(maxValue+"\n");
            bw.write(maxCount+"");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}