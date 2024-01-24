class Marathon {

    public static int first(int[] time) {
        int first = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] < time[first]) {
                first = i;
            }
        }
        return first;
    }

    public static int second(int[] time, int first) {
        int second = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[first] < time[i] && time[i] < time[second]) {
                second = i;
            }
        }
        return second;
    }

    public static void main(String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };
        int first = first(times);
        int second = second(times, first);

        System.out.printf("The first runner among the list above is %s with the time of %d minutes of marathon time.\n", names[first], times[first]);
        System.out.printf("The second runner among the list above is %s with the time of %d minutes of marathon time.", names[second], times[second]);

    }
}