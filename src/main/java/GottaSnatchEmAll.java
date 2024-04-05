import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.isEmpty() && !myCollection.containsAll(theirCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        for (Set<String> collection : collections.subList(1, collections.size()))
            common.retainAll(collection);

        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}
