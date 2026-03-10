import java.io.*;

// git update-index --skip-worktree src/Main.java
// 문제명(https://www.acmicpc.net/problem/문제번호)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        bw.write(N);

        bw.flush();

        bw.close();
        br.close();
    }
}