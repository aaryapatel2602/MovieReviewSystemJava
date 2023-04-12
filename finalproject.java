import java.util.*;

public class AARYA {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Map<String, Double> movieRatings = new HashMap<>();
Map<String, List<String>> movieReviews = new HashMap<>();
Map<Integer, String> movieNames = new HashMap<>();
int count = 1;
    // Add some initial movie ratings and reviews
    movieRatings.put("Dilwale Dulhania Le Jayenge", 4.5);
    movieReviews.put("Dilwale Dulhania Le Jayenge", Arrays.asList(
        "Great movie, highly recommended!",
        "One of my all-time favorites"
    ));
    movieNames.put(count, "Dilwale Dulhania Le Jayenge");
    count++;

    movieRatings.put("3 Idiots", 4.3);
    movieReviews.put("3 Idiots", Arrays.asList(
        "Amazing movie with a great message",
        "The performances were fantastic"
    ));
    movieNames.put(count, "3 Idiots");
    count++;

    movieRatings.put("Lagaan", 4.1);
    movieReviews.put("Lagaan", Collections.singletonList(
        "An epic sports drama with an excellent soundtrack"
    ));
    movieNames.put(count, "Lagaan");
    count++;

    movieRatings.put("Kabhi Khushi Kabhie Gham", 3.9);
    movieReviews.put("Kabhi Khushi Kabhie Gham", Collections.singletonList(
        "A classic Bollywood family drama with great music"
    ));
    movieNames.put(count, "Kabhi Khushi Kabhie Gham");
    count++;

    movieRatings.put("Kuch Kuch Hota Hai", 3.7);
    movieReviews.put("Kuch Kuch Hota Hai", Collections.singletonList(
        "A sweet and romantic movie with great chemistry between the leads"
    ));
    movieNames.put(count, "Kuch Kuch Hota Hai");
    count++;

    movieRatings.put("Dhoom 2", 3.5);
    movieReviews.put("Dhoom 2", Arrays.asList(
        "A thrilling action movie with great stunts",
        "Hrithik Roshan was amazing"
    ));
    movieNames.put(count, "Dhoom 2");
    count++;

    movieRatings.put("Gully Boy", 3.3);
    movieReviews.put("Gully Boy", Collections.singletonList(
        "A powerful movie that sheds light on a unique Indian subculture"
    ));
    movieNames.put(count, "Gully Boy");
    count++;

    movieRatings.put("Kal Ho Naa Ho", 3.1);
    movieReviews.put("Kal Ho Naa Ho", Arrays.asList(
        "A heartwarming story with great performances",
        "The music is still amazing after all these years"
    ));
    movieNames.put(count, "Kal Ho Naa Ho");
    count++;

    movieRatings.put("Dostana", 2.9);
    movieReviews.put("Dostana", Collections.singletonList(
        "A fun and entertaining movie with great comedy"
    ));
    movieNames.put(count, "Dostana");
    count++;

    movieRatings.put("Kabir Singh", 2.7);
    movieReviews.put("Kabir Singh", Arrays.asList(
        "A controversial movie that was difficult to watch at times",
        "The acting was good but the storyline was problematic"
    ));
    movieNames.put(count, "Kabir Singh");
    count++;

    // Main loop
    while (true) {
        System.out.println("Welcome to Bollywood Movie Recommender System!");
System.out.println("Please enter the number of the operation you would like to perform:");
System.out.println("1. Get movie details");
System.out.println("2. Get top-rated movies");
System.out.println("3. Search for movies by keyword");
System.out.println("4. Add a new movie");
System.out.println("5. Exit");
  
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            System.out.println("Please enter the name of the movie:");
            scanner.nextLine();
            String movieName = scanner.nextLine();
            if (movieNames.containsValue(movieName)) {
                double rating = movieRatings.get(movieName);
                List<String> reviews = movieReviews.get(movieName);
                System.out.println("Movie: " + movieName);
                System.out.println("Rating: " + rating);
                if (reviews.size() > 0) {
                    System.out.println("Reviews:");
                    for (String review : reviews) {
                        System.out.println("- " + review);
                    }
                }
            } else {
                System.out.println("Sorry, the movie \"" + movieName + "\" could not be found.");
            }
            break;
        case 2:
            System.out.println("Top-rated movies:");
            TreeMap<String, Double> sortedMovies = new TreeMap<>(new ValueComparator(movieRatings));
            sortedMovies.putAll(movieRatings);
            int i = 1;
            for (String name : sortedMovies.keySet()) {
                System.out.println(i + ". " + name + " (" + sortedMovies.get(name) + ")");
                i++;
            }
            break;
        case 3:
            System.out.println("Please enter a keyword to search for:");
            scanner.nextLine();
            String keyword = scanner.nextLine();
            boolean found = false;
            for (String name : movieNames.values()) {
                if (name.toLowerCase().contains(keyword.toLowerCase())) {
                    double rating = movieRatings.get(name);
                    System.out.println(name + " (" + rating + ")");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Sorry, no movies were found with the keyword \"" + keyword + "\".");
            }
            break;
        case 4:
            System.out.println("Please enter the name of the movie:");
            scanner.nextLine();
            String newMovieName = scanner.nextLine();
            if (movieNames.containsValue(newMovieName)) {
                System.out.println("Sorry, a movie with the name \"" + newMovieName + "\" already exists.");
            } else {
                System.out.println("Please enter the rating of the movie (0.0 - 5.0):");
                double newMovieRating = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Please enter a review of the movie (optional):");
                String newMovieReview = scanner.nextLine();
                List<String> newReviews = new ArrayList<>();
                if (!newMovieReview.equals("")) {
                    newReviews.add(newMovieReview);
                }
                movieNames.put(count, newMovieName);
                movieRatings.put(newMovieName, newMovieRating);
                movieReviews.put(newMovieName, newReviews);
                count++;
                System.out.println("The movie \"" + newMovieName + "\" has been added.");
            }
            break;
        case 5:
            System.out.println("Thank you for using the Bollywood Movie Recommender System!");
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    }
}
}

static class ValueComparator implements Comparator<String> {
    Map<String, Double> map;
    Map<String, Double> base;

    public ValueComparator(Map<String, Double> base) {
        this.base = base;
        this.map = new HashMap<String, Double>();
    }

    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
}
