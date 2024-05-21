import java.util.*;

class PGM_L2_EMOTICON {
    private int[] discounts;
    private int[] combi;
    private List<Result> results;

    static class Result implements Comparable<Result> {

        int plusCount;
        int totalPrice;

        public Result(int plusCount, int totalPrice) {
            this.plusCount = plusCount;
            this.totalPrice = totalPrice;
        }

        @Override
        public int compareTo(Result r) {
            if (this.plusCount != r.plusCount) {
                return r.plusCount - this.plusCount;
            }

            return r.totalPrice - this.totalPrice;
        }

    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        discounts = new int[]{0 ,10, 20, 30, 40};
        combi = new int[emoticons.length];
        results = new ArrayList<>();
        recursiveSolve(0,emoticons.length,users,emoticons);
        Collections.sort(results);
        Result result = results.get(0);
        answer[0] = result.plusCount;
        answer[1] = result.totalPrice;

        return answer;
    }

    private void recursiveSolve(int depth, int limit, int[][] users, int[] emoticons) {

        if (depth == limit) {
            results.add(getResult(users, emoticons));
            return;
        }

        for (int i = 0; i < discounts.length; i++) {
            combi[depth] = i;
            recursiveSolve(depth + 1, limit, users, emoticons);
        }

    }

    private Result getResult(int[][] users, int[] emoticons) {

        int totalPrice = 0;
        int plusCount = 0;
        for (int[] user : users) {
            int price = 0;
            for (int i = 0; i < combi.length; i++) {
                int discount = discounts[combi[i]];
                if (user[0] <= discount) {
                    price += emoticons[i] * (100.0 - discount) / 100;
                }

                if (price >= user[1]) {
                    plusCount++;
                    price = 0;
                    break;
                }
            }
            totalPrice += price;
        }

        return new Result(plusCount, totalPrice);

    }
}

