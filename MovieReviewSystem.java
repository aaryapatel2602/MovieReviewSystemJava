import java.util.Scanner;

public class MovieReviewSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDatabase movieDatabase = new MovieDatabase();

        boolean isDone = false;
        while (!isDone) {
            System.out.println("\n1. Review a movie");
            System.out.println("2. See reviews of a movie");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nChoose a movie to review:");
                    movieDatabase.listMovies();
                    System.out.print("Enter movie number: ");
                    int movieNum = scanner.nextInt();

                    if (movieDatabase.isValidMovie(movieNum)) {
                        System.out.print("Enter rating (1-10): ");
                        int rating = scanner.nextInt();
                        movieDatabase.addReview(movieNum, rating);
                        System.out.println("Review saved!");
                    } else {
                        System.out.println("Invalid movie number!");
                    }
                    break;
                case 2:
                    System.out.println("\nChoose a movie to see reviews:");
                    movieDatabase.listMovies();
                    System.out.print("Enter movie number: ");
                    int movieNum2 = scanner.nextInt();

                    if (movieDatabase.isValidMovie(movieNum2)) {
                        movieDatabase.getReviews(movieNum2);
                    } else {
                        System.out.println("Invalid movie number!");
                    }
                    break;
                case 3:
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        scanner.close();
    }
}

class MovieDatabase {
    private String[] movies;
    private int[][] reviews;

    public MovieDatabase() {
        this.movies = new String[] {"Hulk", "Yeh Jawani hai Diwani", "Dear Zindagi", "Zindagi na milegi dobara", "DDLJ",
                                    "Kabhie Khushi Kabhi Gum", "Sholay", "Jab we met", "Tamasha", "Namaste London"};
        this.reviews = new int[10][];
    }

    public void listMovies() {
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i+1) + ". " + movies[i]);
        }
    }

    public boolean isValidMovie(int movieNum) {
        return movieNum >= 1 && movieNum <= 10;
    }

    public void addReview(int movieNum, int rating) {
        if (reviews[movieNum-1] == null) {
            reviews[movieNum-1] = new int[] {rating};
        } else {
            int[] temp = new int[reviews[movieNum-1].length+1];
            for (int i = 0; i < reviews[movieNum-1].length; i++) {
                temp[i] = reviews[movieNum-1][i];
            }
            temp[temp.length-1] = rating;
            reviews[movieNum-1] = temp;
        }
    }

    public void getReviews(int movieNum) {
        if (reviews[movieNum-1] == null) {
            System.out.println("No reviews yet for " + movies[movieNum-1]);
        } else {
            System.out.println("Reviews for " + movies[movieNum-1] + ":");
            for (int i = 0; i < reviews[movieNum-1].length; i++) {
                System.out.println("- " + reviews[movieNum-1][i]);
            }
        }
       }
