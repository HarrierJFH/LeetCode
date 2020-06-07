package leetcode;

public class Problem518 {

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        } else if (coins.length == 1) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int[] com = new int[amount + 1];
        com[0] = 1;
        int i;
        for (int coin : coins) {
            for (i = coin; i < com.length; i++) {
                com[i] += com[i - coin];
            }
        }
        return com[amount];
    }

    public static void main(String[] args) {
        Problem518 problem = new Problem518();
        System.out.println(problem.change(5, new int[]{1, 2, 5}));
        System.out.println(problem.change(3, new int[]{2}));
        System.out.println(problem.change(10, new int[]{10}));
    }

}
