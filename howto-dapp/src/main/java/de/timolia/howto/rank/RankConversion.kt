package de.timolia.howto.rank

import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

object RankConversion {
    fun getRank(text: String): Rank? {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(Function.identity()) { rank -> getSimilarity(text, rank.getFemale()).coerceAtLeast(getSimilarity(text, rank.male)) })
                .entries
                .stream()
                .max(Comparator.comparingDouble { (_, value) -> value })
                .filter { e -> e.value > 0.1 }
                .map { (key, _) -> key }
                .orElse(null)
    }

    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */
    private fun getSimilarity(s1: String, s2: String): Double {
        var longer = s1
        var shorter = s2
        if (s1.length < s2.length) { // longer should always have greater length
            longer = s2
            shorter = s1
        }
        val longerLength = longer.length
        return if (longerLength == 0) {
            1.0 /* both strings are zero length */
        } else (longerLength - editDistance(longer, shorter)) / longerLength.toDouble()
    }

    // Example implementation of the Levenshtein Edit Distance
    // See http://rosettacode.org/wiki/Levenshtein_distance#Java
    private fun editDistance(s1: String, s2: String): Int {
        var s1 = s1
        var s2 = s2
        s1 = s1.lowercase(Locale.getDefault())
        s2 = s2.lowercase(Locale.getDefault())
        val costs = IntArray(s2.length + 1)
        for (i in 0..s1.length) {
            var lastValue = i
            for (j in 0..s2.length) {
                if (i == 0) costs[j] = j else {
                    if (j > 0) {
                        var newValue = costs[j - 1]
                        if (s1[i - 1] != s2[j - 1]) newValue = newValue.coerceAtMost(lastValue).coerceAtMost(costs[j]) + 1
                        costs[j - 1] = lastValue
                        lastValue = newValue
                    }
                }
            }
            if (i > 0) costs[s2.length] = lastValue
        }
        return costs[s2.length]
    }
}
