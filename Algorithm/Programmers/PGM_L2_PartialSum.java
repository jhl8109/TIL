import java.util.*;

class Candidate implements Comparable<Candidate> {
    public int left;
    public int right;
    public int length;
    
    Candidate(int left, int right, int length) {
        this.left = left;
        this.right = right;
        this.length = length;
    }
    
    @Override
    public int compareTo(Candidate o) {
        if(this.length == o.length) {
            return this.left - o.left;
        } else {
            return this.length - o.length;
        }
    }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int lt = 0, rt = 0;
        int sum = 0;
        ArrayList<Candidate> cand = new ArrayList<>();
        while(lt <= rt) {
            // System.out.println(lt + " " + rt + " " + sum);
            if (sum < k) {
                if (rt == sequence.length) break;
                sum += sequence[rt];
                rt++;
            } else if (sum >= k) {
                if(sum == k) {
                    cand.add(new Candidate(lt, rt-1, rt-lt));
                    // System.out.println(lt + "ans " + rt + " " + sum);
                }
                if(lt == sequence.length) break;
                sum -= sequence[lt];
                lt++;
                
            }       
            
        }
    
        Collections.sort(cand);
        Candidate ans = cand.get(0);
        answer = new int[2];
        answer[0] = ans.left;
        answer[1] = ans.right;
        return answer;
    }
}


