package programmers.network;

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Computers coms = new Computers(n, computers);
        answer = coms.dfs();
        return answer;
    }
    public class Computers{
        private int n;
        private LinkedList<Integer> conn[];

        public Computers(int n, int[][] computers){
            this.n = n;
            this.conn = new LinkedList[n];
            for (int i=0; i<n; ++i) this.conn[i] = new LinkedList();
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    if(computers[i][j] == 1){
                        this.conn[i].add(j);
                    }
                }
            }
        }

        void find(int com, boolean visited[]) {
            visited[com] = true;
            Iterator<Integer> i = this.conn[com].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    find(n, visited);
            }
        }

        int dfs() {
            int result = 0;
            boolean visited[] = new boolean[this.n];
      
            for (int i=0; i<this.n; ++i) {
                if (visited[i] == false){
                    System.out.println("Start com : "+i);
                    find(i, visited);
                    result++;
                    System.out.println(Arrays.toString(visited));
                }
            }
            return result;
        }

    }


}