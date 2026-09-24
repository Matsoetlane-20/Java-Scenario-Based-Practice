public class GreenCity {

    public static void main(String[] args) {

        String[] names = {
            "Mpho",
            "Thabo",
            "Lerato",
            "Kabelo",
            "Palesa",
            "Neo",
            "Teboho",
            "Masechaba",
            "Lebohang",
            "Karabo",
            "Lineo",
            "Mokete",
            "Refiloe",
            "Nthabiseng",
            "Boitumelo"
        };

        int[] scores = {
            99,
            72,
            64,
            91,
            55,
            78,
            68,
            82,
            49,
            73,
            88,
            59,
            76,
            66,
            94
        };

        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total = total + scores[i];
        }

        double average = (double) total / scores.length;

        System.out.printf("Class Average: %.2f%n", average);

        System.out.println();
        System.out.println("===== STUDENT GRADE REPORT =====");

        for (int i = 0; i < names.length; i++) {

            char grade;

            if (scores[i] >= 80) {
                grade = 'A';
            } else if (scores[i] >= 70) {
                grade = 'B';
            } else if (scores[i] >= 60) {
                grade = 'C';
            } else if (scores[i] >= 50) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.printf("%-15s Score: %3d  Grade: %c%n",
                    names[i], scores[i], grade);
        }

        System.out.println();
        System.out.println("===== STUDENTS BELOW AVERAGE =====");

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] < average) {
                System.out.printf("%s - %d%n", names[i], scores[i]);
            }
        }

        System.out.println("==================================");
    }
}
