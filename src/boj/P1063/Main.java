package boj.P1063;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 킹 (https://www.acmicpc.net/problem/1036)

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] inputInfo = input.split(" ");

        String kingPosition = inputInfo[0];
        int kingRow = kingPosition.charAt(0) - 'A';
        int kingCol = '8' - kingPosition.charAt(1);

        String stonePosition = inputInfo[1];
        int stoneRow = stonePosition.charAt(0) - 'A';
        int stoneCol = '8' - stonePosition.charAt(1);

        int N = Integer.parseInt(inputInfo[2]);

        Map<String, int[]> map = new HashMap<>();
        map.put("R", new int[]{1, 0});
        map.put("L", new int[]{-1, 0});
        map.put("B", new int[]{0, 1});
        map.put("T", new int[]{0, -1});
        map.put("RT", new int[]{1, -1});
        map.put("LT", new int[]{-1, -1});
        map.put("RB", new int[]{1, 1});
        map.put("LB", new int[]{-1, 1});

        for (int i = 0; i < N; i++) {
            String move = br.readLine();

            int moveRow = map.get(move)[0];
            int moveCol = map.get(move)[1];

            if (kingRow + moveRow >= 0 && kingRow + moveRow <= 7
                    && kingCol + moveCol >= 0 && kingCol + moveCol <= 7) {
                kingRow += moveRow;
                kingCol += moveCol;
                if (kingRow == stoneRow && kingCol == stoneCol) {
                    stoneRow += moveRow;
                    stoneCol += moveCol;
                    if (stoneRow < 0 || stoneRow > 7 || stoneCol < 0 || stoneCol > 7) {
                        stoneRow -= moveRow;
                        stoneCol -= moveCol;
                        kingRow -= moveRow;
                        kingCol -= moveCol;
                    }
                }
            }
        }

        String resultKingPosition = "" + (char) ('A' + kingRow) + (char) ('8' - kingCol);
        String resultStonePosition = "" + (char) ('A' + stoneRow) + (char) ('8' - stoneCol);

        bw.write(resultKingPosition + "");
        bw.newLine();
        bw.write(resultStonePosition + "");

        bw.flush();

        bw.close();
        br.close();
    }
}
