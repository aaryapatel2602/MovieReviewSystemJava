import java.util.*;

public class finalproject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> movieRatings = new HashMap<>();
        Map<String, List<String>> movieReviews = new HashMap<>();

        // Add some initial movie ratings and reviews
        movieRatings.put("Dilwale Dulhania Le Jayenge", 4.5);
        movieReviews.put("Dilwale Dulhania Le Jayenge", Arrays.asList(
            "Great movie, highly recommended!",
            "One of my all-time favorites"
        ));

        movieRatings.put("3 Idiots", 4.3);
        movieReviews.put("3 Idiots", Arrays.asList(
            "Amazing movie with a great message",
            "The performances were fantastic"
        ));

        movieRatings.put("Lagaan", 4.1);
        movieReviews.put("Lagaan", Collections.singletonList(
            "An epic sports drama with an excellent soundtrack"
        ));

        movieRatings.put("Kabhi Khushi Kabhie Gham", 3.9);
        movieReviews.put("Kabhi Khushi Kabhie Gham", Collections.singletonList(
            "A classic Bollywood family drama with great music"
        ));

        movieRatings.put("Kuch Kuch Hota Hai", 3.7);
        movieReviews.put("Kuch Kuch Hota Hai", Collections.singletonList(
            "A sweet and romantic movie with great chemistry between the leads"
        ));

        movieRatings.put("Dhoom 2", 3.5);
        movieReviews.put("Dhoom 2", Arrays.asList(
            "A thrilling action movie with great stunts",
            "Hrithik Roshan was amazing"
        ));

        movieRatings.put("Gully Boy", 3.3);
        movieReviews.put("Gully Boy", Collections.singletonList(
            "A powerful movie that sheds light on a unique Indian subculture"
        ));

        movieRatings.put("Kal Ho Naa Ho", 3.1);
        movieReviews.put("Kal Ho Naa Ho", Arrays.asList(
            "A heartwarming story with great performances",
            "The music is still amazing after all these years"
        ));

        movieRatings.put("Dostana", 2.9);
        movieReviews.put("Dostana", Collections.singletonList(
            "A fun and entertaining movie with great comedy"
        ));

        movieRatings.put("Kabir Singh", 2.7);
        movieReviews.put("Kabir Singh", Arrays.asList(
            "A controversial movie that was difficult to watch at times",
            "The acting was good but the storyline was problematic"
        ));

        // Main loop
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. List movies");
            System.out.println("2. Get movie reviews");
            System.out.println("3. Add a movie review");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("List of movies:");
                for (String movie : movieRatings.keySet()) {
                    System.out.println(movie);
                }
            } else if (choice == 2) {
                System.out.println("Enter the name of the movie:");
                String movie = scanner.next();

                if (movieReviews.containsKey(movie)) {
                    System.out.println("Reviews for " + movie + ":");
                    for (String review : movieReviews.get(movie)) {
                        System.out.println(review);
                    }
                                    System.out.println("Average rating: " + movieRatings.get(movie));
            } else {
                System.out.println("No reviews found for " + movie);
            }
        } else if (choice == 3) {
            System.out.println("Enter the name of the movie:");
            String movie = scanner.next();

            if (movieReviews.containsKey(movie)) {
                System.out.println("Enter your review:");
                String review = scanner.next();

                List<String> reviews = movieReviews.get(movie);
                reviews.add(review);
                movieReviews.put(movie, reviews);

                System.out.println("Enter your rating (out of 5):");
                double rating = scanner.nextDouble();

                double currentRating = movieRatings.get(movie);
                double newRating = (currentRating + rating) / 2;
                movieRatings.put(movie, newRating);

                System.out.println("Review and rating added for " + movie);
            } else {
                System.out.println("Movie not found");
            }
        } else if (choice == 4) {
            System.out.println("Exiting...");
            break;
        } else {
            System.out.println("Invalid choice, please try again");
        }
    }

    scanner.close();
}
}
