
public class SubsetSum {
    static int x[], w[], count, d;
    static String[] categories;

    static void sum_of_subsets(int s, int k, int rem) {
        x[k] = 1;
        if (s + w[k] == d) {
            System.out.println("Subset/Event Planning = " + ++count);
            for (int i = 0; i <= k; i++)
                if (x[i] == 1)
                    System.out.println(categories[i] + " : " + w[i]);
            System.out.println();
        } else if (k + 1 < w.length && s + w[k] + w[k + 1] <= d) 
            sum_of_subsets(s + w[k], k + 1, rem - w[k]);
        if (k + 1 < w.length && (s + rem - w[k] >= d) && (s + w[k + 1]) <= d) { 
            x[k] = 0;
            sum_of_subsets(s, k + 1, rem - w[k]);
        }
    }

    public static void main(String[] args) {
        // Static predefined input
        int sum = 0;
        int n = 3;
        categories = new String[] { "Food", "Music", "Decor" };
        w = new int[] { 100, 200, 300 };
        x = new int[n];
        d = 400;

        for (int i = 0; i < n; i++) {
            sum += w[i];
        }

        System.out.println("Number of categories: " + n);
        System.out.println("Category names and budgets:");
        for (int i = 0; i < n; i++) {
            System.out.println(categories[i] + " : " + w[i]);
        }
        System.out.println("Event budget: " + d);

        if ((sum < d) || (w[0] > d))
            System.out.println("No subset possible - Unable to host the events");
        else
            sum_of_subsets(0, 0, sum);
    }
}
