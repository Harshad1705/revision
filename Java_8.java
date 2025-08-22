import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java_8 {

    static void seperate_odd_and_even_numbers(List<Integer> list) {
        Map<Object, List<Integer>> mp = list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));

        System.out.println(mp);

    }

    static void remove_duplicate_element_from_list(List<Integer> list) {
        List<Integer> unique = list.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);
    }

    static void frequency_of_each_character_in_string(String input) {
        Map<Character, Long> res = input.chars().mapToObj(o -> (char) o)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(res);
    }

    static void frequency_of_each_element_in_array(List<Integer> array) {
        Map<Integer, Long> res = array.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(res);
    }

    static void sort_list_in_reverse_order(List<Integer> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }

    static void join_list_of_string_with_prefix_suffix_and_delimiter(List<String> strList) {

        String joinedString = strList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedString);
    }
    
    static void print_multiple_of_5(List<Integer> list) {
        List<Integer> res = list.stream().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println(res);
    }

    static void maximum_and_minimum_in_list(List<Integer> list) {
        int maximum = list.stream().max(Comparator.naturalOrder()).get();
        int minimum = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Maximum: " + maximum + ", Minimum: " + minimum);
    }
    
    static void merge_two_unsorted_array_into_sorted_array(int[] a, int[] b) {
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::print);
    }

    static void merge_two_unsorted_array_into_sorted_array_withoout_duplicated(int[] a, int[] b) {
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::print);
    }

    static void three_maximum_and_three_minimum_in_list(List<Integer> list) {
        list.stream().sorted().limit(3).forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }

    public static void if_two_string_are_anagram_or_not(String s1, String s2) {
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("Strings are anagram");
        } else {
            System.out.println("Strings are not anagram");
        }
    }

    public static void sum_of_all_digit(int val) {
        int sum = Stream.of(String.valueOf(val).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sum);
    }

    static void second_largest_element_in_array(List<Integer> list) {
        int secondMax = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondMax);
    }

    static void sort_the_string_according_to_length(List<String> strList) {
        List<String> res = strList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(res);
    }

    static void sum_and_average_of_array(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        OptionalDouble average = Arrays.stream(arr).average();

        System.out.println("Sum: " + sum + " Average: " + average);
    }

    static void common_element_betweer_arrays(List<Integer> a, List<Integer> b) {
        List<Integer> l = a.stream().filter(b::contains).collect(Collectors.toList());
        System.out.println(l);
    }

    static void reverse_each_word_in_string(String str) {
        String res = Stream.of(str.split(" ")).map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }

    static void sum_of_10_natural_number() {
        int res = IntStream.range(1, 10).sum();
        System.out.println(res);
    }

    static void reverse_integer_array(List<Integer> arr) {
        Collections.reverse(arr);
        System.out.println(arr);
    }

    static void print_first_10_even_number() {
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);;
    }

    static void most_repeating_element_in_Array(List<String> list) {
        Map<String, Long> mp = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Entry<String, Long> ans = mp.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(ans);
    }
    
    static void check_palindrome(String str) {
        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - 1 - i));

        if (isPalindrome) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
    }
    
    static void check_string_start_with_number_in_array(List<String> list) {
        list.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::print);
    }

    static void extract_duplicate_element_from_list(List<Integer> list) {
        Set<Integer> uniqueElement = new HashSet<>();

        Set<Integer> duplicateElement = list.stream().filter(i -> !uniqueElement.add(i)).collect(Collectors.toSet());

        System.out.println(duplicateElement);

    }
    
    static void extract_duplicate_character_from_list(String str) {
        Set<String> uniqueElement = new HashSet<>();

        Set<String> duplicateElement = Arrays.stream(str.split("")).filter(i -> !uniqueElement.add(i))
                .collect(Collectors.toSet());

        System.out.println(duplicateElement);

    }
    
    static void first_repeated_character_in_string(String str) {
        Map<String, Long> mp = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
                
        String firstRepeated = mp.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
                .findFirst().get();
        System.out.println(firstRepeated);
    }
    
    static void first_non_repeated_character_in_string(String str) {
        Map<String, Long> mp = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        String firstNonRepeated = mp.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst().get();
        System.out.println(firstNonRepeated);
    }
    
    static void fibonacci_series() {
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                .limit(10).map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));
    }
    
    static void first_10_odd_numbers() {
        Stream.iterate(new int[] { 1, 3 }, f -> new int[] { f[1], f[1] + 2 })
                .limit(10).map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));
    }
    
    static void last_element_of_Array(List<String> list) {
        String last = list.stream().skip(list.size() - 1).findFirst().get();
        System.out.println(last);
    }

    static void find_age_of_person() {
        LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate today = LocalDate.now();
         
        System.out.println(ChronoUnit.YEARS.between(birthDay, today));
    }
    
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        seperate_odd_and_even_numbers(list);
        
        List<Integer> list2 = Arrays.asList(1, 2, 1, 4, 2, 6, 3, 8, 4);
        remove_duplicate_element_from_list(list2);

        String str = "abcabca";
        frequency_of_each_character_in_string(str);
        
        frequency_of_each_element_in_array(list2);

        sort_list_in_reverse_order(list2);

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        join_list_of_string_with_prefix_suffix_and_delimiter(listOfStrings);
        
        List<Integer> list3 = Arrays.asList(1, 2, 5, 8, 10, 15, 20, 8, 4);
        print_multiple_of_5(list3);

        maximum_and_minimum_in_list(list3);

        int[] a = new int[] {4, 2, 5, 1};
        int[] b = new int[] {8, 1, 9, 5};
        merge_two_unsorted_array_into_sorted_array(a, b);
        System.out.println();
        merge_two_unsorted_array_into_sorted_array_withoout_duplicated(a, b);
        
        System.out.println();
        three_maximum_and_three_minimum_in_list(list3);

        String s1 = "RaceCar";
        String s2 = "CarRace";
        if_two_string_are_anagram_or_not(s1, s2);
        
        int val = 1234;
        sum_of_all_digit(val);

        second_largest_element_in_array(list3);

        List<String> listOfStringss = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
         
        sort_the_string_according_to_length(listOfStringss);

        sum_and_average_of_array(a);

        common_element_betweer_arrays(list3, list2);
        
        String str1 = "Java Concept Of The Day";
        reverse_each_word_in_string(str1);

        sum_of_10_natural_number();

        reverse_integer_array(list);

        print_first_10_even_number();

    
        List<String> listOfStringsss = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        most_repeating_element_in_Array(listOfStringsss);

        check_palindrome("ROTATOR");

        List<String> stringss = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        check_string_start_with_number_in_array(stringss);

        System.out.println();
        extract_duplicate_element_from_list(list2);

        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        extract_duplicate_character_from_list(inputString);

        first_repeated_character_in_string(inputString);
        
        first_non_repeated_character_in_string(inputString);

        fibonacci_series();

        System.out.println();
        first_10_odd_numbers();

        System.out.println();
        last_element_of_Array(stringss);

        find_age_of_person();
        
        
    }


}
